<%@page import="model.dao.FuncionarioDAO"%>
<%@page import="model.dto.Funcionario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    String mensagem = "";
    try {
        String funcionarioId = request.getParameter("id");

        if (funcionarioId != null && !funcionarioId.isEmpty()) {
            Funcionario objFuncionario = new Funcionario();
            objFuncionario.setPkid_funcionario(Integer.parseInt(funcionarioId));
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

            System.out.println("Alterando funcionário: " + objFuncionario.getFuncionario_nome() + ", CPF: " + objFuncionario.getFuncionario_cpf());

            FuncionarioDAO objFuncionarioDAO = new FuncionarioDAO();
            objFuncionarioDAO.AlterarFuncionario(objFuncionario);

            mensagem = "Funcionário foi alterado com sucesso!";
        } else {
            mensagem = "ID do funcionário não encontrado.";
        }
    } catch (Exception e) {
        mensagem = "Erro ao alterar o funcionário: " + e.getMessage();
        e.printStackTrace();
    }

    out.print("<p>" + mensagem + "</p>");
    
    response.sendRedirect("funcionario.jsp");
%>
