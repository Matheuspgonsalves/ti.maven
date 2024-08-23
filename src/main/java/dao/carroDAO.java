package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Carro;


public class carroDAO extends DAO{
    public List<Carro> listar() {
        List<Carro> carros = new ArrayList<>();
        String sql = "SELECT * FROM carro";

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = conexao_bd();
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();

            while(rs.next()){
                Carro carro = new Carro();
                carro.setCodigo(rs.getInt("codigo"));
                carro.setModelo(rs.getString("modelo"));
                carro.setAno(rs.getString("ano"));
                carro.setMarca(rs.getString("marca"));
                carros.add(carro);
            }
        }
        catch (SQLException e) {
            System.err.println("Erro ao listar os carros: " + e.getMessage());
        }
        finally {
            try {
                if(rs != null) rs.close();
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
        return carros;
    }

    public void inserir(Carro carro) {
        String sql = "INSERT INTO carro (codigo, modelo, ano, marca) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexao_bd();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, carro.getCodigo());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getAno());
            stmt.setString(4, carro.getMarca());

            stmt.executeUpdate();
            System.out.println("Carro inserido com sucesso");
        } catch (SQLException e) {
            System.err.println("Erro ao inserir o carro " + e.getMessage());
        } finally {
            try {
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public void atualizar(Carro carro) {
        String sql = "UPDATE INTO carro (codigo, modelo, ano, marca) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexao_bd();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, carro.getCodigo());
            stmt.setString(2, carro.getModelo());
            stmt.setString(3, carro.getAno());
            stmt.setString(4, carro.getMarca());

            stmt.executeUpdate();

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Carro atualizado com sucesso!");
            } else {
                System.out.println("Nenhum carro encontrado com o código fornecido.");
            }
        }
        catch (SQLException e) {
            System.err.println("Erro ao atualizar o carro " + e.getMessage());
        }
        finally {
            try {
                if(stmt != null) stmt.close();
                if(conn != null) conn.close();
            }
            catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }
    }

    public void excluir(int codigo) {
        String sql = "DELETE FROM carro WHERE codigo = ?";

        Connection conn = null;
        PreparedStatement stmt = null;

        try {
            conn = conexao_bd();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, codigo);

            int rowsAffected = stmt.executeUpdate();

            if (rowsAffected > 0) {
                System.out.println("Carro excluído com sucesso!");
            } else {
                System.out.println("Nenhum carro encontrado com o código fornecido.");
            }
        }
        catch (SQLException e) {
            System.err.println("Erro ao excluir o carro: " + e.getMessage());
        }
        finally {
            try {
                if (stmt != null) stmt.close(); // Fecha o PreparedStatement
                if (conn != null) conn.close(); // Fecha a conexão
            } catch (SQLException e) {
                System.err.println("Erro ao fechar recursos: " + e.getMessage());
            }
        }

    }
}
