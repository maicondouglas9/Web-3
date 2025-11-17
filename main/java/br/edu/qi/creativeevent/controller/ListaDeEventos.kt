package br.edu.qi.creativeevent.controller

import android.app.Activity
import android.content.Intent
import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.ContextMenu
import android.view.Gravity
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.ArrayAdapter
import android.widget.SearchView
import android.widget.Toolbar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.qi.creativeevent.R
import br.edu.qi.creativeevent.databinding.ActivityListaDeEventosBinding
import br.edu.qi.creativeevent.model.dao.EventosDAO
import br.edu.qi.creativeevent.model.dto.Eventos
import java.util.Locale


class ListaDeEventos : AppCompatActivity() {
    private lateinit var binding: ActivityListaDeEventosBinding
    private lateinit var objEventos: EventosDAO
    private lateinit var im : MenuInflater
    private lateinit var excluir : MenuItem
    private lateinit var alterar : MenuItem
    private lateinit var todosOsEventos: MutableList<Eventos>
    var eventosFiltrados : MutableList<Eventos> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        this.binding = ActivityListaDeEventosBinding.inflate(layoutInflater)
        setContentView(this.binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var i : Intent

        this.binding.btnVoltar.setOnClickListener{
            i = Intent(this, MainActivity::class.java)
            startActivity(i)

        }

        this.binding.btnCriar.setOnClickListener {
            i = Intent(this, CriarEvento::class.java)
            startActivity(i)
        }


        this.objEventos = EventosDAO(this)
        this.todosOsEventos = this.objEventos.listarEventos().toMutableList()
        this.eventosFiltrados = this.todosOsEventos.toMutableList()

        val adaptador = ArrayAdapter(this,android.R.layout.simple_list_item_1,this.eventosFiltrados)

        this.binding.lstEventos.adapter = adaptador

        this.im = menuInflater

        this.binding.itPesquisar.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return true
            }

            override fun onQueryTextChange(nome: String?): Boolean {

                pesquisarEventos(nome!!)

                return true
            }
        })

        registerForContextMenu(this.binding.lstEventos)


    }



    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        this.im.inflate(R.menu.menu_contexto,menu)

        this.excluir = menu!!.findItem(R.id.itExcluir)
        this.alterar = menu.findItem(R.id.itAlterar)

        this.excluir.setOnMenuItemClickListener {menuItem ->
            val eventoEscolhido = menuItem.menuInfo as AdapterContextMenuInfo
            val eventoAExcluir : Eventos = this.eventosFiltrados[eventoEscolhido.position]

            AlertDialog.Builder(this)
                .setTitle("Atenção")
                .setMessage("Deseja excluir o evento\n$eventoAExcluir")
                .setNegativeButton("Não",null)
                .setPositiveButton("Sim"){_,_ ->
                    this.objEventos.excluirEvento(eventoAExcluir)
                    this.todosOsEventos.remove(eventoAExcluir)
                    this.eventosFiltrados.remove(eventoAExcluir)
                    this.binding.lstEventos.invalidateViews()

                }
                .create().show()



            true
        }

        this.alterar.setOnMenuItemClickListener {menuItem ->

            val eventoEscolhido = menuItem.menuInfo as AdapterContextMenuInfo
            val eventoAlterado : Eventos = this.eventosFiltrados[eventoEscolhido.position]

            var i = Intent(this, AlterarEvento::class.java)
            i.putExtra("id", eventoAlterado.id)
            i.putExtra("nome", eventoAlterado.nome)
            i.putExtra("data", eventoAlterado.data)
            i.putExtra("horario", eventoAlterado.horario)
            i.putExtra("local", eventoAlterado.local)
            i.putExtra("descricao", eventoAlterado.descricao)
            startActivity(i)

            true
        }
    }


    fun pesquisarEventos(nome : String){
        this.eventosFiltrados.clear()

        for (i in this.todosOsEventos.indices){
            if (this.todosOsEventos[i].nome!!.lowercase(Locale.getDefault()).contains(nome.lowercase(
                    Locale.getDefault()))){
                this.eventosFiltrados.add(this.todosOsEventos[i])
            }
        }
        this.binding.lstEventos.invalidateViews()
    }
}