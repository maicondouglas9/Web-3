<%@page import="model.dao.AlunoDAO"%>
<%@page import="model.dto.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Excluir Aluno</title>
</head>
<body>
    <%
        String mensagem = "";
        try {
            String alunoId = request.getParameter("id");
            
            if (alunoId != null && !alunoId.isEmpty()) {
                Aluno objAluno = new Aluno();
                objAluno.setPkid_aluno(Integer.parseInt(alunoId));
                
                AlunoDAO objAlunoDAO = new AlunoDAO();
                objAlunoDAO.ExcluirAluno(objAluno);

                mensagem = "Aluno excluído com sucesso!";
            } else {
                mensagem = "ID do aluno não encontrado.";
            }
        } catch (Exception e) {
            mensagem = "Erro ao excluir aluno: " + e.getMessage();
        }

        out.print("<p>" + mensagem + "</p>");
        
        response.sendRedirect("alunos.jsp");
    %>

    <a href="alunos.jsp">Voltar para a lista de alunos</a>
</body>
</html>
