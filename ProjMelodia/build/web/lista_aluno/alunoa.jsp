

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <link href="../css/estilo3.css" rel="stylesheet" type="text/css"/>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Amaranth:ital,wght@0,400;0,700;1,400;1,700&display=swap" rel="stylesheet">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar aluno</title>
    </head>
    <body>
        <form action="alterarAluno.jsp" method="post">
    <h1>Alterar dados do aluno</h1>
    <div id="dados">
        <div>
            <label for="id">Código do aluno:</label>
            <input name="id" id="id" type="text" value="<%= request.getParameter("id") %>" readonly>
        </div>
        <div>
            <label for="nome">Nome do aluno:</label>
            <input name="nome" id="nome" type="text" value="<%= request.getParameter("nome") %>">
        </div>
        <div>
            <label for="data">Data de nascimento:</label>
            <input name="data" id="data" type="text" value="<%= request.getParameter("data") %>">
        </div>
        <div>
            <label for="cpf">CPF:</label>
            <input name="cpf" id="cpf" type="text" value="<%= request.getParameter("cpf") %>">
        </div>
        <div>
            <label for="sexo">Sexo:</label>
            <select name="sexo" id="sexo">
                <option value="Masculino" <%= "Masculino".equals(request.getParameter("sexo")) ? "selected" : "" %>>Masculino</option>
                <option value="Feminino" <%= "Feminino".equals(request.getParameter("sexo")) ? "selected" : "" %>>Feminino</option>
            </select>
        </div>
        <div>
            <label for="telefone">Telefone:</label>
            <input name="telefone" id="telefone" type="text" value="<%= request.getParameter("telefone") %>">
        </div>
        <div>
            <label for="cep">CEP:</label>
            <input name="cep" id="cep" type="text" value="<%= request.getParameter("cep") %>">
        </div>
        <div>
            <label for="rua">Rua:</label>
            <input name="rua" id="rua" type="text" value="<%= request.getParameter("rua") %>">
        </div>
        <div>
            <label for="numero">Número:</label>
            <input name="numero" id="numero" type="number" value="<%= request.getParameter("numero") %>">
        </div>
        <div>
            <label for="complemento">Complemento:</label>
            <input name="complemento" id="complemento" type="text" value="<%= request.getParameter("complemento") %>">
        </div>
        <div>
            <label for="cidade">Cidade:</label>
            <input name="cidade" id="cidade" type="text" value="<%= request.getParameter("cidade") %>">
        </div>
        <div>
            <label for="estado">Estado:</label>
            <select name="estado" id="estado">
                <option value="AC" <%= "AC".equals(request.getParameter("estado")) ? "selected" : "" %>>Acre</option>
                <option value="AL" <%= "AL".equals(request.getParameter("estado")) ? "selected" : "" %>>Alagoas</option>
                <option value="AP" <%= "AP".equals(request.getParameter("estado")) ? "selected" : "" %>>Amapá</option>
                <option value="AM" <%= "AM".equals(request.getParameter("estado")) ? "selected" : "" %>>Amazonas</option>
                <option value="BA" <%= "BA".equals(request.getParameter("estado")) ? "selected" : "" %>>Bahia</option>
                <option value="CE" <%= "CE".equals(request.getParameter("estado")) ? "selected" : "" %>>Ceará</option>
                <option value="DF" <%= "DF".equals(request.getParameter("estado")) ? "selected" : "" %>>Distrito Federal</option>
                <option value="ES" <%= "ES".equals(request.getParameter("estado")) ? "selected" : "" %>>Espírito Santo</option>
                <option value="GO" <%= "GO".equals(request.getParameter("estado")) ? "selected" : "" %>>Goiás</option>
                <option value="MA" <%= "MA".equals(request.getParameter("estado")) ? "selected" : "" %>>Maranhão</option>
                <option value="MT" <%= "MT".equals(request.getParameter("estado")) ? "selected" : "" %>>Mato Grosso</option>
                <option value="MS" <%= "MS".equals(request.getParameter("estado")) ? "selected" : "" %>>Mato Grosso do Sul</option>
                <option value="MG" <%= "MG".equals(request.getParameter("estado")) ? "selected" : "" %>>Minas Gerais</option>
                <option value="PA" <%= "PA".equals(request.getParameter("estado")) ? "selected" : "" %>>Pará</option>
                <option value="PB" <%= "PB".equals(request.getParameter("estado")) ? "selected" : "" %>>Paraíba</option>
                <option value="PR" <%= "PR".equals(request.getParameter("estado")) ? "selected" : "" %>>Paraná</option>
                <option value="PE" <%= "PE".equals(request.getParameter("estado")) ? "selected" : "" %>>Pernambuco</option>
                <option value="PI" <%= "PI".equals(request.getParameter("estado")) ? "selected" : "" %>>Piauí</option>
                <option value="RJ" <%= "RJ".equals(request.getParameter("estado")) ? "selected" : "" %>>Rio de Janeiro</option>
                <option value="RN" <%= "RN".equals(request.getParameter("estado")) ? "selected" : "" %>>Rio Grande do Norte</option>
                <option value="RS" <%= "RS".equals(request.getParameter("estado")) ? "selected" : "" %>>Rio Grande do Sul</option>
                <option value="RO" <%= "RO".equals(request.getParameter("estado")) ? "selected" : "" %>>Rondônia</option>
                <option value="RR" <%= "RR".equals(request.getParameter("estado")) ? "selected" : "" %>>Roraima</option>
                <option value="SC" <%= "SC".equals(request.getParameter("estado")) ? "selected" : "" %>>Santa Catarina</option>
                <option value="SP" <%= "SP".equals(request.getParameter("estado")) ? "selected" : "" %>>São Paulo</option>
                <option value="SE" <%= "SE".equals(request.getParameter("estado")) ? "selected" : "" %>>Sergipe</option>
                <option value="TO" <%= "TO".equals(request.getParameter("estado")) ? "selected" : "" %>>Tocantins</option>
            </select>
        </div>

        <div>
            <input type="submit" value="Alterar">
        </div>
    </div>
</form>

    </body>
</html>
