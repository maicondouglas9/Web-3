package model.dto;

import java.time.LocalDate;

public class Aluno {
    
    private int pkid_aluno;
    private String aluno_nome;
    private String aluno_data_de_nascimento;
    private String aluno_cpf;
    private String aluno_sexo;
    private String aluno_telefone;
    private String aluno_cep;
    private String aluno_rua;
    private int aluno_numero;
    private String aluno_cidade;
    private String aluno_complemento;
    private String aluno_estado;

    
    public int getPkid_aluno() {
        return pkid_aluno;
    }

    public void setPkid_aluno(int pkid_aluno) {
        this.pkid_aluno = pkid_aluno;
    }

    public String getAluno_nome() {
        return aluno_nome;
    }

    public void setAluno_nome(String aluno_nome) {
        this.aluno_nome = aluno_nome;
    }

    public String getAluno_data_de_nascimento() {
        return aluno_data_de_nascimento;
    }

    public void setAluno_data_de_nascimento(String aluno_data_de_nascimento) {
        this.aluno_data_de_nascimento = aluno_data_de_nascimento;
    }

    public String getAluno_cpf() {
        return aluno_cpf;
    }

    public void setAluno_cpf(String aluno_cpf) {
        this.aluno_cpf = aluno_cpf;
    }

    public String getAluno_sexo() {
        return aluno_sexo;
    }

    public void setAluno_sexo(String aluno_sexo) {
        this.aluno_sexo = aluno_sexo;
    }

    public String getAluno_telefone() {
        return aluno_telefone;
    }

    public void setAluno_telefone(String aluno_telefone) {
        this.aluno_telefone = aluno_telefone;
    }

    public String getAluno_cep() {
        return aluno_cep;
    }

    public void setAluno_cep(String aluno_cep) {
        this.aluno_cep = aluno_cep;
    }

    public String getAluno_rua() {
        return aluno_rua;
    }

    public void setAluno_rua(String aluno_rua) {
        this.aluno_rua = aluno_rua;
    }

    public int getAluno_numero() {
        return aluno_numero;
    }

    public void setAluno_numero(int aluno_numero) {
        this.aluno_numero = aluno_numero;
    }

    public String getAluno_cidade() {
        return aluno_cidade;
    }

    public void setAluno_cidade(String aluno_cidade) {
        this.aluno_cidade = aluno_cidade;
    }

    public String getAluno_complemento() {
        return aluno_complemento;
    }

    public void setAluno_complemento(String aluno_complemento) {
        this.aluno_complemento = aluno_complemento;
    }

    public String getAluno_estado() {
        return aluno_estado;
    }

    public void setAluno_estado(String aluno_estado) {
        this.aluno_estado = aluno_estado;
    }       
}
