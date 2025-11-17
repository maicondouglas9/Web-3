package br.edu.qi.creativeevent.controller

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.qi.creativeevent.R
import br.edu.qi.creativeevent.databinding.ActivityAlterarEventoBinding
import br.edu.qi.creativeevent.model.dao.EventosDAO
import br.edu.qi.creativeevent.model.dto.Eventos
import java.time.DateTimeException
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter
import java.time.format.ResolverStyle
import java.util.Locale

class AlterarEvento : AppCompatActivity() {
    private lateinit var binding: ActivityAlterarEventoBinding
    private var idEvento : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.binding = ActivityAlterarEventoBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
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

        val dao = EventosDAO(this)

        this.binding.edtDataAlterar.addTextChangedListener(object : TextWatcher {
            var isUpdating = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isUpdating) return
                val str = s.toString().filter { it.isDigit() }
                val formatted = StringBuilder()
                var i = 0
                while (i < str.length && i < 8) {
                    if (i == 2 || i == 4) formatted.append('/')
                    formatted.append(str[i])
                    i++
                }
                isUpdating = true
                binding.edtDataAlterar.setText(formatted.toString())
                binding.edtDataAlterar.setSelection(formatted.length)
                isUpdating = false
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        this.binding.edtHoraAlterar.addTextChangedListener(object : TextWatcher {
            var isUpdating = false
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (isUpdating) return
                val str = s.toString().filter { it.isDigit() }
                val formatted = StringBuilder()
                var i = 0
                while (i < str.length && i < 4) {
                    if (i == 2) formatted.append(':')
                    formatted.append(str[i])
                    i++
                }
                isUpdating = true
                binding.edtHoraAlterar.setText(formatted.toString())
                binding.edtHoraAlterar.setSelection(formatted.length)
                isUpdating = false
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        idEvento = intent.getIntExtra("id", 0)
        val nome = intent.getStringExtra("nome")
        val data = intent.getStringExtra("data")
        val horario = intent.getStringExtra("horario")
        val local = intent.getStringExtra("local")
        val descricao = intent.getStringExtra("descricao")

        this.binding.edtNomeAlterar.setText(nome)
        this.binding.edtDataAlterar.setText(data)
        this.binding.edtHoraAlterar.setText(horario)
        this.binding.edtLocalAlterar.setText(local)
        this.binding.edtDrecricaoAlterar.setText(descricao)

        this.binding.btnEventoAlterar.setOnClickListener {
            val nomeAlterado = this.binding.edtNomeAlterar.text.toString()
            val dataAlterada = this.binding.edtDataAlterar.text.toString()
            val horrioAlterado = this.binding.edtHoraAlterar.text.toString()
            val localAlterado = this.binding.edtLocalAlterar.text.toString()
            val descricaoAlterada = this.binding.edtDrecricaoAlterar.text.toString()

            if (nomeAlterado.isNotEmpty() && dataAlterada.isNotEmpty() && horrioAlterado.isNotEmpty()
                && localAlterado.isNotEmpty() && descricaoAlterada.isNotEmpty()){

                if (!validarData(dataAlterada)) {
                    Toast.makeText(this, "Data inválida!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if (!validarHorario(horrioAlterado)) {
                    Toast.makeText(this, "Horário inválido!", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                val eventoAlterado = Eventos()
                eventoAlterado.id = idEvento
                eventoAlterado.nome = nomeAlterado
                eventoAlterado.data = dataAlterada
                eventoAlterado.horario = horrioAlterado
                eventoAlterado.local = localAlterado
                eventoAlterado.descricao = descricaoAlterada

                dao.alterarEvento(eventoAlterado)
                startActivity(Intent(this,ListaDeEventos::class.java))
            }

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

    fun validarHorario(horaStr: String): Boolean {
        return try {
            val formatted = DateTimeFormatter.ofPattern("HH:mm")
            LocalTime.parse(horaStr, formatted)
            true
        } catch (e: Exception) {
            false
        }
    }

}