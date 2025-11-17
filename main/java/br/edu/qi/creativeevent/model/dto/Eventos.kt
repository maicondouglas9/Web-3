package br.edu.qi.creativeevent.model.dto

class Eventos {

    var id : Int = 0
    var nome : String? = null
    var data : String? = null
    var horario : String? = null
    var local : String? = null
    var descricao : String? = null

    override fun toString(): String {
        return """
            
            ID: $id
            NOME: $nome
            DATA: $data
            HORÁRIO: $horario
            Local: $local
            DESCRIÇÂO: $descricao
            
        """.trimIndent()
    }


}