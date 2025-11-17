

<%@page import="model.dao.FuncionarioDAO"%>
<%@page import="model.dto.Funcionario"%>
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

            String tipo = request.getParameter("tipo");
            String nome = request.getParameter("nome");

            if ("aluno".equals(tipo)) {
                Aluno objAluno = new Aluno();
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

                AlunoDAO objAlunoDAO = new AlunoDAO();
                objAlunoDAO.CadastrarAluno(objAluno);
                
                response.sendRedirect("../lista_aluno/alunos.jsp");

            } else if ("funcionario".equals(tipo)) {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setFuncionario_nome(request.getParameter("nome"));
                objFuncionario.setFuncionario_data_de_nascimento(request.getParameter("data"));
                objFuncionario.setFuncionario_cpf(request.getParameter("cpf"));
                objFuncionario.setFuncionario_sexo(request.getParameter("sexo"));
                objFuncionario.setFuncionario_telefone(request.getParameter("telefone"));
                objFuncionario.setFuncionario_cep(request.getParameter("cep"));
                objFuncionario.setFuncionario_rua(request.getParameter("rua"));
                objFuncionario.setFuncionario_numero(Integer.parseInt(request.getParameter("numero")));
                objFuncionario.setFuncionario_complemento(request.getParameter("complemento"));
                objFuncionario.setFuncionario_cidade(request.getParameter("cidade"));
                objFuncionario.setFuncionario_estado(request.getParameter("estado"));

                FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
                objFuncionarioDAO.CadastrarFuncionario(objFuncionario);
                
                response.sendRedirect("../lista_funcionario/funcionario.jsp");

            }
        %>


    </body>
</html>
