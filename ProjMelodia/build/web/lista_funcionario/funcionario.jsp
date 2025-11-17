<%@page import="model.dto.Funcionario"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.dao.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="../css/estilos4.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
        <link rel="shortcut icon" href="img/marca2.png" type="image/png">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Funcionários</title>
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
                FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
                ArrayList<Funcionario> listaf = objFuncionarioDAO.ListaDeFuncionarios();

                out.print("<div class='funcionario-lista'>");

                for (int num = 0; num < listaf.size(); num++) {
                    out.print("<div class='funcionario-item'>");
                    out.print("<p><strong>Codigo do funcionario</strong> " + listaf.get(num).getPkid_funcionario()+ "</p>");
                    out.print("<p><strong>Nome:</strong> " + listaf.get(num).getFuncionario_nome() + "</p>");
                    out.print("<p><strong>Data de nascimento:</strong> " + listaf.get(num).getFuncionario_data_de_nascimento() + "</p>");

                    out.print("<a href='funcionariox.jsp?id=" + listaf.get(num).getPkid_funcionario()
                            + "&nome=" + listaf.get(num).getFuncionario_nome()
                            + "&data=" + listaf.get(num).getFuncionario_data_de_nascimento()
                            + "&cpf=" + listaf.get(num).getFuncionario_cpf()
                            + "&sexo=" + listaf.get(num).getFuncionario_sexo()
                            + "&telefone=" + listaf.get(num).getFuncionario_telefone()
                            + "&cep=" + listaf.get(num).getFuncionario_cep()
                            + "&rua=" + listaf.get(num).getFuncionario_rua()
                            + "&numero=" + listaf.get(num).getFuncionario_numero()
                            + "&complemento=" + listaf.get(num).getFuncionario_complemento()
                            + "&cidade=" + listaf.get(num).getFuncionario_cidade()
                            + "&estado=" + listaf.get(num).getFuncionario_estado()
                            + "' class='btn-excluir'>Excluir</a>");
                    
                    out.print("<a href='funcionarioa.jsp?id=" + listaf.get(num).getPkid_funcionario()
                            + "&nome=" + listaf.get(num).getFuncionario_nome()
                            + "&data=" + listaf.get(num).getFuncionario_data_de_nascimento() 
                            + "&cpf=" + listaf.get(num).getFuncionario_cpf() 
                            + "&sexo=" + listaf.get(num).getFuncionario_sexo()
                            + "&telefone=" + listaf.get(num).getFuncionario_telefone()
                            + "&cep=" + listaf.get(num).getFuncionario_cep()
                            + "&rua=" + listaf.get(num).getFuncionario_rua()
                            + "&numero=" + listaf.get(num).getFuncionario_numero()
                            + "&complemento=" + listaf.get(num).getFuncionario_complemento()
                            + "&cidade=" + listaf.get(num).getFuncionario_cidade()
                            + "&estado=" + listaf.get(num).getFuncionario_estado() 
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
