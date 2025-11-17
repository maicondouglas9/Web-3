package br.edu.qi.creativeevent.model.conexaobd

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ConexaoBD (contexto:Context) : SQLiteOpenHelper(contexto,NOME,null,VERSAO) {

    companion object{
        private val NOME : String = "bd_eventos"
        private val VERSAO : Int = 1
    }

    override fun onCreate(bd_eventos: SQLiteDatabase?) {
        bd_eventos!!.execSQL("create table tb_evento(" +
                "pkidevento integer primary key autoincrement," +
                "nome varchar(200) not null," +
                "data varchar(10) not null," +
                "horario varchar(5) not null," +
                "local varchar(100) not null," +
                "descricao varchar(255) not null)")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }
}