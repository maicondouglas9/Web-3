package model.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.conexaobd.ConexaoBD;
import model.dto.Aluno;

public class AlunoDAO {

    Connection conexao;
    PreparedStatement ps;
    ResultSet resultado;
    ArrayList<Aluno> lista = new ArrayList<>();

    public void CadastrarAluno(Aluno objAluno) throws ClassNotFoundException {

        String sql = "insert into aluno (aluno_nome, aluno_data_de_nascimento, aluno_cpf, aluno_sexo, aluno_telefone, aluno_cep, aluno_rua, aluno_numero, aluno_cidade, aluno_complemento, aluno_estado) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conexao = new ConexaoBD().Conexao();
        if (conexao == null) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.");
            return;
        }

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objAluno.getAluno_nome());
            ps.setString(2, objAluno.getAluno_data_de_nascimento());
            ps.setString(3, objAluno.getAluno_cpf());
            ps.setString(4, objAluno.getAluno_sexo());
            ps.setString(5, objAluno.getAluno_telefone());
            ps.setString(6, objAluno.getAluno_cep());
            ps.setString(7, objAluno.getAluno_rua());
            ps.setInt(8, objAluno.getAluno_numero());
            ps.setString(9, objAluno.getAluno_cidade());
            ps.setString(10, objAluno.getAluno_complemento());
            ps.setString(11, objAluno.getAluno_estado());

            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro no CadastroAluno(): " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos do cadastro: " + e.getMessage());
            }
        }
    }

    public ArrayList<Aluno> ListaDeAlunos() {

        String sql = "select * from aluno";
        conexao = new ConexaoBD().Conexao();

        try {
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery(sql);

            while (resultado.next()) {
                Aluno objAluno = new Aluno();
                objAluno.setPkid_aluno(resultado.getInt("pkid_aluno"));
                objAluno.setAluno_nome(resultado.getString("aluno_nome"));
                objAluno.setAluno_data_de_nascimento(resultado.getString("aluno_data_de_nascimento"));
                objAluno.setAluno_telefone(resultado.getString("aluno_telefone"));
                objAluno.setAluno_sexo(resultado.getString("aluno_sexo"));
                objAluno.setAluno_cpf(resultado.getString("aluno_cpf"));
                objAluno.setAluno_cep(resultado.getString("aluno_cep"));
                objAluno.setAluno_rua(resultado.getString("aluno_rua"));
                objAluno.setAluno_numero(resultado.getInt("aluno_numero"));
                objAluno.setAluno_complemento(resultado.getString("aluno_complemento"));
                objAluno.setAluno_cidade(resultado.getString("aluno_cidade"));
                objAluno.setAluno_estado(resultado.getString("aluno_estado"));

                lista.add(objAluno);

            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro na Lista(): " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.close();
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos da lista: " + e.getMessage());
            }
        }

        return lista;

    }

    public void ExcluirAluno(Aluno objAluno) throws ClassNotFoundException {
    System.out.println("Tentando excluir aluno com ID: " + objAluno.getPkid_aluno());
    String sql = "DELETE FROM aluno WHERE pkid_aluno = ?";

    conexao = new ConexaoBD().Conexao();
    if (conexao == null) {
        JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.");
        return;
    }

    try {
        ps = conexao.prepareStatement(sql);
        ps.setInt(1, objAluno.getPkid_aluno());

        int linhasAfetadas = ps.executeUpdate(); // Correção no método de execução
        if (linhasAfetadas > 0) {
            System.out.println("Aluno excluído com sucesso!");
        } else {
            System.out.println("Nenhum aluno foi encontrado com esse ID.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Deu erro no ExcluirAluno(): " + e.getMessage());
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos do excluir: " + e.getMessage());
        }
    }
}
    public void AlterarAluno(Aluno objAluno) throws ClassNotFoundException {
    System.out.println("Tentando alterar aluno com ID: " + objAluno.getPkid_aluno());
    String sql = "update aluno set aluno_nome = ?, aluno_data_de_nascimento = ?, aluno_cpf = ?, aluno_sexo = ?, aluno_telefone = ?, aluno_cep = ?, aluno_rua = ?, aluno_numero = ?, aluno_cidade = ?, aluno_complemento = ?, aluno_estado = ? WHERE pkid_aluno = ?";

    conexao = new ConexaoBD().Conexao();
    if (conexao == null) {
        JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.");
        return;
    }

    try {
        ps = conexao.prepareStatement(sql);
        ps.setString(1, objAluno.getAluno_nome());
        ps.setString(2, objAluno.getAluno_data_de_nascimento());
        ps.setString(3, objAluno.getAluno_cpf());
        ps.setString(4, objAluno.getAluno_sexo());
        ps.setString(5, objAluno.getAluno_telefone());
        ps.setString(6, objAluno.getAluno_cep());
        ps.setString(7, objAluno.getAluno_rua());
        ps.setInt(8, objAluno.getAluno_numero());
        ps.setString(9, objAluno.getAluno_complemento());
        ps.setString(10, objAluno.getAluno_cidade());
        ps.setString(11, objAluno.getAluno_estado());
        ps.setInt(12, objAluno.getPkid_aluno());

        int linhasAfetadas = ps.executeUpdate();
        if (linhasAfetadas > 0) {
            System.out.println("Aluno foi alterado com sucesso!");
        } else {
            System.out.println("Nenhum aluno foi encontrado com esse ID.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Deu erro no AlterarAluno(): " + e.getMessage());
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos de alterar aluno: " + e.getMessage());
        }
    }
}

}
