
<%@page import="model.dao.AlunoDAO"%>
<%@page import="model.dto.Aluno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
        String mensagem = "";
        try {
            String alunoId = request.getParameter("id");

            if (alunoId != null && !alunoId.isEmpty()) {
                Aluno objAluno = new Aluno();
                objAluno.setPkid_aluno(Integer.parseInt(alunoId));
                objAluno.setAluno_nome(request.getParameter("nome"));
                objAluno.setAluno_data_de_nascimento(request.getParameter("data"));
                objAluno.setAluno_cpf(request.getParameter("cpf"));
                objAluno.setAluno_sexo(request.getParameter("sexo"));
                objAluno.setAluno_telefone(request.getParameter("telefone"));
                objAluno.setAluno_cep(request.getParameter("cep"));
                objAluno.setAluno_rua(request.getParameter("rua"));
                objAluno.setAluno_numero(Integer.parseInt(request.getParameter("numero")));
                objAluno.setAluno_complemento(request.getParameter("complemento"));
                objAluno.setAluno_cidade(request.getParameter("cidade"));
                objAluno.setAluno_estado(request.getParameter("estado"));

                
                System.out.println("Alterando aluno: " + objAluno.getAluno_nome() + ", CPF: " + objAluno.getAluno_cpf());

                AlunoDAO objAlunoDAO = new AlunoDAO();
                objAlunoDAO.AlterarAluno(objAluno);

                mensagem = "Aluno foi alterado com sucesso!";
            } else {
                mensagem = "ID do aluno não encontrado.";
            }
        } catch (Exception e) {
            mensagem = "Erro ao alterar o aluno: " + e.getMessage();
            e.printStackTrace();
        }

        out.print("<p>" + mensagem + "</p>");
        
        response.sendRedirect("alunos.jsp");
    %>

    <a href="alunos.jsp">Voltar para a lista de alunos</a>
    </body>
</html>
