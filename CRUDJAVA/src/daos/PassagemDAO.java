package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Conexao;
import models.Passagem;

public class PassagemDAO { 

	public void cadastrapassagem(Passagem passagem) {
		String sql = "INSERT INTO passagem (destino,data_passagem,preco) VALUES (?, ?, ? )";
		PreparedStatement pstm = null;
		Connection con = null;

		try {

			con = Conexao.createConnectionToMySQL();

			pstm = con.prepareStatement(sql);

			pstm.setString(1, passagem.getDestino());

			pstm.setDate(2, passagem.getData());

			pstm.setDouble(3, passagem.getPreco());

		System.out.println("Cadastrou! com sucesso");
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

	public static List<Passagem> listarPassagem() {
		String sql = "SELECT * FROM passagem";
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<Passagem> passagens = new ArrayList<>();

		try {
			con = Conexao.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Passagem passagem = new Passagem(sql, null, null);

				passagem.setDestino(rs.getString("destino"));
				passagem.setData(rs.getDate("data_passagem"));
				passagem.setPreco(rs.getDouble("preco"));
				passagens.add(passagem);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar passagem");
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
		return passagens;
	}
	
	public static void atualizarPassagem(Passagem passagem) {
		String sql = "UPDATE passagem SET destino = ?, data_passagem = ?, preco = ? WHERE id = ?";
		PreparedStatement pstm = null;
		Connection con = null;

		try {
			con = Conexao.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
            pstm.setString(1,passagem.getDestino());
			pstm.setDate(2, passagem.getData());
			pstm.setDouble(3, passagem.getPreco());

			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar passagem");
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

	
	public void excluirpassagem(int id) {
		String sql = "DELETE FROM passagem WHERE id_passagem = ?";
		Connection Conexao = null;
		try (PreparedStatement stmt = Conexao.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Passagem buscar(int id) {

		Passagem passagem = null;

		String sql = "SELECT * FROM passagem WHERE id = ?";

		try (PreparedStatement stmt = Conexao.prepareStatement(sql)) {

			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {

				passagem = new Passagem();

				passagem.setDestino(passagem.getDestino());

				passagem.setData(passagem.getData());

				passagem.setPreco(passagem.getPreco());

			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return passagem;

	}

	public static void fecharConexao() {
		
		
	}

	public Passagem atualizarPassagem(Passagem passagemToUpdate, int passagemIdAtualizar) {
		
		return null;
	}

	public Passagem buscarPassagem(int passagemIdExcluir) {
		
		return null;
	}

	public void excluirDestino(int passagemIdExcluir) {
	
		
	}

	public void excluirPassagem(int passagemIdExcluir) {
		
		
	}

	public void excluirConsulta(int passagemIdExcluir) {
	
		
	}

	public Passagem buscarUsuario(int int1) {
		
		return null;
	}

}
