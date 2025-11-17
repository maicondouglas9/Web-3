package model.dao;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.conexaobd.ConexaoBD;
import model.dto.Funcionario;

public class FuncionarioDAO {

    Connection conexao;
    PreparedStatement ps;
    ResultSet resultado;
    ArrayList<Funcionario> listaf = new ArrayList<>();

    public void CadastrarFuncionario(Funcionario objFuncionario) throws ClassNotFoundException {

        String sql = "insert into funcionario (funcionario_nome, funcionario_data_de_nascimento, funcionario_cpf, funcionario_sexo, funcionario_telefone, funcionario_cep, funcionario_rua, funcionario_numero, funcionario_cidade, funcionario_complemento, funcionario_estado) values (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        conexao = new ConexaoBD().Conexao();
        if (conexao == null) {
            JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.");
            return;
        }

        try {
            ps = conexao.prepareStatement(sql);
            ps.setString(1, objFuncionario.getFuncionario_nome());
            ps.setString(2, objFuncionario.getFuncionario_data_de_nascimento());
            ps.setString(3, objFuncionario.getFuncionario_cpf());
            ps.setString(4, objFuncionario.getFuncionario_sexo());
            ps.setString(5, objFuncionario.getFuncionario_telefone());
            ps.setString(6, objFuncionario.getFuncionario_cep());
            ps.setString(7, objFuncionario.getFuncionario_rua());
            ps.setInt(8, objFuncionario.getFuncionario_numero());
            ps.setString(9, objFuncionario.getFuncionario_cidade());
            ps.setString(10, objFuncionario.getFuncionario_complemento());
            ps.setString(11, objFuncionario.getFuncionario_estado());

            ps.execute();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro no CadastroFuncionario(): " + e.getMessage());
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (conexao != null) {
                    conexao.close();  // Fechar a Connection
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public ArrayList<Funcionario> ListaDeFuncionarios() {

        String sql = "SELECT * FROM funcionario";
        conexao = new ConexaoBD().Conexao();

        try {
            ps = conexao.prepareStatement(sql);
            resultado = ps.executeQuery(sql);

            while (resultado.next()) {
                Funcionario objFuncionario = new Funcionario();
                objFuncionario.setPkid_funcionario(resultado.getInt("pkid_funcionario"));
                objFuncionario.setFuncionario_nome(resultado.getString("funcionario_nome"));
                objFuncionario.setFuncionario_data_de_nascimento(resultado.getString("funcionario_data_de_nascimento"));
                objFuncionario.setFuncionario_sexo(resultado.getString("funcionario_sexo"));
                objFuncionario.setFuncionario_cpf(resultado.getString("funcionario_cpf"));
                objFuncionario.setFuncionario_cep(resultado.getString("funcionario_cep"));
                objFuncionario.setFuncionario_rua(resultado.getString("funcionario_rua"));
                objFuncionario.setFuncionario_numero(resultado.getInt("funcionario_numero"));
                objFuncionario.setFuncionario_complemento(resultado.getString("funcionario_complemento"));
                objFuncionario.setFuncionario_cidade(resultado.getString("funcionario_cidade"));
                objFuncionario.setFuncionario_estado(resultado.getString("funcionario_estado"));
                
                listaf.add(objFuncionario);
            }

        } catch (SQLException e) {

        }

        return listaf;
    }
    
    public void ExcluirFuncionario(int id) {
        String sql = "DELETE FROM funcionario WHERE pkid_funcionario = ?";
        conexao = new ConexaoBD().Conexao();
        
        try {
            ps = conexao.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir funcionário: " + e.getMessage());
        } finally {
            fecharConexao();
        }
    }
    
    private void fecharConexao() {
        try {
            if (resultado != null) resultado.close();
            if (ps != null) ps.close();
            if (conexao != null) conexao.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar conexão: " + e.getMessage());
        }
    }
    
    public void AlterarFuncionario(Funcionario objFuncionario) throws ClassNotFoundException {
    System.out.println("Tentando alterar funcionário com ID: " + objFuncionario.getPkid_funcionario());
    String sql = "UPDATE funcionario SET funcionario_nome = ?, funcionario_data_de_nascimento = ?, funcionario_cpf = ?, funcionario_sexo = ?, funcionario_telefone = ?, funcionario_cep = ?, funcionario_rua = ?, funcionario_numero = ?, funcionario_cidade = ?, funcionario_complemento = ?, funcionario_estado = ? WHERE pkid_funcionario = ?";

    conexao = new ConexaoBD().Conexao();
    if (conexao == null) {
        JOptionPane.showMessageDialog(null, "Falha na conexão com o banco de dados.");
        return;
    }

    try {
        ps = conexao.prepareStatement(sql);
        ps.setString(1, objFuncionario.getFuncionario_nome());
        ps.setString(2, objFuncionario.getFuncionario_data_de_nascimento());
        ps.setString(3, objFuncionario.getFuncionario_cpf());
        ps.setString(4, objFuncionario.getFuncionario_sexo());
        ps.setString(5, objFuncionario.getFuncionario_telefone());
        ps.setString(6, objFuncionario.getFuncionario_cep());
        ps.setString(7, objFuncionario.getFuncionario_rua());
        ps.setInt(8, objFuncionario.getFuncionario_numero());
        ps.setString(9, objFuncionario.getFuncionario_complemento());
        ps.setString(10, objFuncionario.getFuncionario_cidade());
        ps.setString(11, objFuncionario.getFuncionario_estado());
        ps.setInt(12, objFuncionario.getPkid_funcionario());

        int linhasAfetadas = ps.executeUpdate();
        if (linhasAfetadas > 0) {
            System.out.println("Funcionário foi alterado com sucesso!");
        } else {
            System.out.println("Nenhum funcionário foi encontrado com esse ID.");
        }

    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Deu erro no AlterarFuncionario(): " + e.getMessage());
    } finally {
        try {
            if (ps != null) {
                ps.close();
            }
            if (conexao != null) {
                conexao.close();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar recursos de alterar funcionário: " + e.getMessage());
        }
    }
}

    
}
    


