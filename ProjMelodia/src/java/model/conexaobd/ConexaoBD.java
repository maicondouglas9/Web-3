package model.conexaobd;

import java.sql.*;
import javax.swing.JOptionPane;

public class ConexaoBD {

    private Connection conexao;

    public Connection Conexao() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/bdmelodia?useSSL=false&serverTimezone=UTC&user=root&password=";
            this.conexao = DriverManager.getConnection(url);
        } catch (ClassNotFoundException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Deu erro no getConexao()");
        }

        return conexao;
    }

    public boolean testarConexao() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
