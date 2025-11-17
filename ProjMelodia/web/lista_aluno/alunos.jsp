<%@page import="model.dto.Aluno"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.AlunoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="../css/estilo3.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="img/marca2.png" type="image/png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de alunos</title>
    </head>
    <body>
        <div id="menu"> 
            <nav>
                <div id="marca">
                    <a href="../index.html"></a>
                </div>
                <ul>
                    <li><a href="../cadastro/cadastro.html">Cadastro</a></li>
                    <li><a href="../lista_aluno/alunos.jsp">Alunos</a></li>
                    <li><a href="../lista_funcionario/funcionario.jsp">Funcionários</a></li>
                </ul>
            </nav>
        </div>

        <%
            try {
                AlunoDAO objAlunoDAO = new AlunoDAO();
                ArrayList<Aluno> lista = objAlunoDAO.ListaDeAlunos();

                out.print("<div class='aluno-lista'>");

                for (int num = 0; num < lista.size(); num++) {
                    out.print("<div class='aluno-item'>");
                    
                    out.print("<p><strong>Codigo do aluno:</strong> " + lista.get(num).getPkid_aluno()+ "</p>");
                    out.print("<p><strong>Nome:</strong> " + lista.get(num).getAluno_nome() + "</p>");
                    out.print("<p><strong>Data de nascimento:</strong> " + lista.get(num).getAluno_data_de_nascimento() + "</p>");

                   
                    out.print("<a href='alunosx.jsp?id=" + lista.get(num).getPkid_aluno()
                            + "&nome=" + lista.get(num).getAluno_nome()
                            + "&data=" + lista.get(num).getAluno_data_de_nascimento() 
                            + "&cpf=" + lista.get(num).getAluno_cpf() 
                            + "&sexo=" + lista.get(num).getAluno_sexo()
                            + "&telefone=" + lista.get(num).getAluno_telefone()
                            + "&cep=" + lista.get(num).getAluno_cep()
                            + "&rua=" + lista.get(num).getAluno_rua()
                            + "&numero=" + lista.get(num).getAluno_numero()
                            + "&complemento=" + lista.get(num).getAluno_complemento()
                            + "&cidade=" + lista.get(num).getAluno_cidade()
                            + "&estado=" + lista.get(num).getAluno_estado() 
                            + "' class='btn-excluir'>Excluir</a>");
                            
                    out.print("<a href='alunoa.jsp?id=" + lista.get(num).getPkid_aluno()
                            + "&nome=" + lista.get(num).getAluno_nome()
                            + "&data=" + lista.get(num).getAluno_data_de_nascimento() 
                            + "&cpf=" + lista.get(num).getAluno_cpf() 
                            + "&sexo=" + lista.get(num).getAluno_sexo()
                            + "&telefone=" + lista.get(num).getAluno_telefone()
                            + "&cep=" + lista.get(num).getAluno_cep()
                            + "&rua=" + lista.get(num).getAluno_rua()
                            + "&numero=" + lista.get(num).getAluno_numero()
                            + "&complemento=" + lista.get(num).getAluno_complemento()
                            + "&cidade=" + lista.get(num).getAluno_cidade()
                            + "&estado=" + lista.get(num).getAluno_estado() 
                            + "' class='btn-excluir'>Alterar</a>");        

                    out.print("</div>");
                }

                out.print("</div>");
            } catch (Exception e) {
                e.printStackTrace();
            }
        %>
    </body>
</html>
