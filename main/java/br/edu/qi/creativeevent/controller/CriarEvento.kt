package br.edu.qi.creativeevent.controller

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.qi.creativeevent.R
import br.edu.qi.creativeevent.databinding.ActivityCriarEventoBinding
import br.edu.qi.creativeevent.model.dao.EventosDAO
import br.edu.qi.creativeevent.model.dto.Eventos
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.Locale


class CriarEvento : AppCompatActivity() {
    private lateinit var binding: ActivityCriarEventoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.binding = ActivityCriarEventoBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.binding.edtDataCriar.addTextChangedListener(object : TextWatcher{
            var isUpdating = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(isUpdating) return

                val str = s.toString().filter { it.isDigit() }
                val formatted = StringBuilder()

                var i = 0

                while (i < str.length && i < 8) {
                    if (i == 2 || i == 4) formatted.append('/')
                    formatted.append(str[i])
                    i++
                }
                isUpdating = true
                binding.edtDataCriar.setText(formatted.toString())
                binding.edtDataCriar.setSelection(formatted.length)
                isUpdating = false
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        this.binding.edtHoraCriar.addTextChangedListener(object : TextWatcher{
            var isUpdating = false

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if(isUpdating) return

                val str = s.toString().filter { it.isDigit() }
                val formatted = StringBuilder()

                var i = 0

                while (i<str.length && i < 4) {
                    if (i==2) formatted.append(':')
                    formatted.append(str[i])
                    i++
                }
                isUpdating = true
                binding.edtHoraCriar.setText(formatted.toString())
                binding.edtHoraCriar.setSelection(formatted.length)
                isUpdating = false
            }

            override fun afterTextChanged(s: Editable?) {}
        })

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var i : Intent

        this.binding.btnCriarVoltar.setOnClickListener {
            i = Intent(this, ListaDeEventos::class.java)
            startActivity(i)
        }

        this.binding.btnEventoCriar.setOnClickListener {
            val objEventos = Eventos()

            val dataDigitada = this.binding.edtDataCriar.text.toString().trim()


            if (dataDigitada.length != 10) {
                Toast.makeText(this, "Data incompleta!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!validarData(dataDigitada)) {
                Toast.makeText(this, "Data inválida!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val horarioDigitado = this.binding.edtHoraCriar.text.toString()

            if (!validarHorario(horarioDigitado)) {
                Toast.makeText(this,"Horário inválido!!!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            objEventos.nome = this.binding.edtNomeCriar.text.toString()
            objEventos.data = dataDigitada
            objEventos.local = this.binding.edtLocalCriar.text.toString()
            objEventos.horario = horarioDigitado
            objEventos.descricao = this.binding.edtDrecricaoCriar.text.toString()

            val objEventosDAO = EventosDAO(this)
            objEventosDAO.criarEvento(objEventos)



            i = Intent(this, ListaDeEventos::class.java)
            startActivity(i)
        }

        this.binding.btnLimparCampos.setOnClickListener {

            this.binding.edtNomeCriar.setText("")
            this.binding.edtDataCriar.setText("")
            this.binding.edtDrecricaoCriar.setText("")
            this.binding.edtLocalCriar.setText("")
            this.binding.edtHoraCriar.setText("")

        }


    }

    fun validarData(dataStr: String): Boolean {
        return try {
            val formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
                .withResolverStyle(ResolverStyle.STRICT)
                .withLocale(Locale("pt", "BR"))
            LocalDate.parse(dataStr, formatter)
            true
        } catch (e: DateTimeException) {
            false
        }
    }



    fun validarHorario(horaStr: String): Boolean{
        return try {
            val formatted = DateTimeFormatter.ofPattern("HH:mm")
            val hora = LocalTime.parse(horaStr, formatted)
            true
        } catch (e: Exception){
            false
        }
    }

}

