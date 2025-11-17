package br.edu.qi.creativeevent.model.dao

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import br.edu.qi.creativeevent.model.conexaobd.ConexaoBD
import br.edu.qi.creativeevent.model.dto.Eventos

class EventosDAO (contexto:Context) {

    private val conexaoBD : ConexaoBD = ConexaoBD(contexto)
    private val bd_eventos :SQLiteDatabase = this.conexaoBD.writableDatabase

    fun criarEvento(objEventos: Eventos){
        val valoresCampos = ContentValues()

        valoresCampos.put("nome",objEventos.nome)
        valoresCampos.put("data", objEventos.data)
        valoresCampos.put("horario",objEventos.horario)
        valoresCampos.put("local", objEventos.local)
        valoresCampos.put("descricao",objEventos.descricao)

        this.bd_eventos.insert("tb_evento",null,valoresCampos)
    }

    fun listarEventos() : List<Eventos> {

        val todosOsEventos : MutableList<Eventos> = ArrayList()

        val campos = arrayOf("pkidevento","nome","data","horario","local","descricao")

        val cursor = this.bd_eventos.query("tb_evento", campos,null,null,null,null,null,null)

        while (cursor.moveToNext()){

            val objEventos : Eventos = Eventos()

            objEventos.id = cursor.getInt(0)
            objEventos.nome = cursor.getString(1)
            objEventos.data = cursor.getString(2)
            objEventos.horario = cursor.getString(3)
            objEventos.local = cursor.getString(4)
            objEventos.descricao = cursor.getString(5)

            todosOsEventos.add(objEventos)

        }
        return todosOsEventos
    }

    fun excluirEvento(objEventos: Eventos) {
        val id = arrayOf(objEventos.id.toString())
        this.bd_eventos.delete("tb_evento","pkidevento = ?", id)
    }

    fun alterarEvento(objEventos: Eventos){


        val valoresCampos = ContentValues()

        valoresCampos.put("nome",objEventos.nome)
        valoresCampos.put("data", objEventos.data)
        valoresCampos.put("horario",objEventos.horario)
        valoresCampos.put("local", objEventos.local)
        valoresCampos.put("descricao",objEventos.descricao)

        val id = arrayOf(objEventos.id.toString())
        this.bd_eventos.update("tb_evento", valoresCampos, "pkidEvento = ?", id)

    }

}