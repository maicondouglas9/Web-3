<%@page import="model.dto.Funcionario"%>
<%@page import="model.dao.FuncionarioDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="../css/estilos4.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Excluir Funcionário</title>
    </head>
    <body>
        <form action="excluirFuncionario.jsp" method="post">
            <h1>Excluir dados do funcionário</h1>
            <div id="dados">
                <div>
                    <label for="id">Código do funcionário:</label>
                    <input name="id" id="id" type="text" value="<%= request.getParameter("id")%>" readonly>
                </div>
                <div>
                    <label for="nome">Nome do funcionário:</label>
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
