<%@page import="model.dao.FuncionarioDAO"%>
<%@page import="model.dto.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Excluir Funcionário</title>
</head>
<body>
    <%
        String mensagem = "";
        try {
            String funcionarioId = request.getParameter("id");
            
            if (funcionarioId != null && !funcionarioId.isEmpty()) {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setPkid_funcionario(Integer.parseInt(funcionarioId));
                
                FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
                objFuncionarioDAO.ExcluirFuncionario(objFuncionario.getPkid_funcionario());
;

                mensagem = "Funcionário excluído com sucesso!";
            } else {
                mensagem = "ID do funcionário não encontrado.";
            }
        } catch (Exception e) {
            mensagem = "Erro ao excluir funcionário: " + e.getMessage();
        }

        out.print("<p>" + mensagem + "</p>");
        
        response.sendRedirect("funcionario.jsp");
    %>

    <a href="funcionarios.jsp">Voltar para a lista de funcionários</a>
</body>
</html>
