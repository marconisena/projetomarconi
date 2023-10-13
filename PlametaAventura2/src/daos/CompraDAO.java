package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import main.Conexao;
import models.Compra;

public class CompraDAO<ArrayAtualizar> {

	private static final Connection Con = null;
	PassagemDAO passagemDAO = new PassagemDAO();

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public void cadastraCompra(Compra compra) {
		String sql = "INSERT INTO compra (    id_passagem, id_usuario) VALUES (?,  ?  )";
		PreparedStatement pstm = null;
		Connection con = null;

		try {

			con = Conexao.createConnectionToMySQL();

			pstm = con.prepareStatement(sql);
          
		   
			pstm.setInt(1, compra.getId_passagem());
			pstm.setInt(2, compra.getId_usuario());

			System.out.println("Cadastrou com sucesso!");
			
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro do cadastro");

		} finally {
			try {

				if (pstm != null) {

					pstm.close();

				}

				if (con != null) {

					con.close();

				}

			} catch (Exception e) {

				e.printStackTrace();
			}
		}
	}

	public ArrayList<Compra> listarCompras() {
		String sql = "SELECT * FROM compra";
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		ArrayList<Compra> compras = new ArrayList<>();

		try {
			con = Conexao.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Compra compra = new Compra(1, 2);
				compra.setId_passagem(rs.getInt("id_passagem"));
				compra.setId_usuario(rs.getInt("id_usuario"));
				compras.add(compra);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar compras");
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstm != null) {
					pstm.close();
				}
				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return compras;
	}

	public void AtualizarCompra(Compra compra) {
		String sql = "UPDATE compras SET  id_usuario = ?,  id_passagem = ? " + "WHERW id = ?";

		Connection con = null;
		PreparedStatement pstm = null;
		try {
			con = Conexao.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery(); 
			
			pstm.setInt(1, compra.getId_passagem());
			pstm.setInt(2, compra.getId());
			pstm.execute();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {

				}
				pstm.close();

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void excluirCompra(int id) {
		String sql = "DELETE FROM compra WHERE id_passagem = ?";
		Connection con = null;

		try {
			con = Conexao.createConnectionToMySQL();
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Compra buscarCompra(int id) {

		Compra compra = null;

		String sql = "SELECT * FROM compra WHERE id = ?";

		try (PreparedStatement stmt = Conexao.prepareStatement(sql)) {

			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {

				compra = new Compra();

				compra.setId(resultado.getInt("id"));

				compra.setId_usuario(usuarioDAO.buscarUsuario(resultado.getInt("id")));

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return compra;

	}

	public void fecharConexao() {

	}

	public void AtualizarCompra(int id) {

	}

}
