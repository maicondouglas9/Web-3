<%@page import="model.dto.Aluno"%>
<%@page import="model.dao.AlunoDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="../css/estilo3.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Aluno</title>
    </head>
    <body>
        <form action="excluirAluno.jsp" method="post">
            <h1>Excluir dados do aluno</h1>
            <div id="dados">
                <div>
                    <label for="nome">Codigo do aluno:</label>
                    <input name="id" id="nome" type="text" value="<%= request.getParameter("id")%>" readonly>
                </div>
                <div>
                    <label for="nome">Nome do aluno:</label>
                    <input name="nome" id="nome" type="text" value="<%= request.getParameter("nome")%>" readonly>
                </div>

                <div>
                    <label for="data">Data de nascimento:</label>
                    <input name="data" id="data" type="text" value="<%= request.getParameter("data")%>" readonly>
                </div>


                <input type="hidden" name="id" value="<%= request.getParameter("id")%>">

                <div>
                    <input type="submit" value="Excluir">
                </div>
            </div>
        </form>
    </body>
</html>
