package daos;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.Conexao;

import models.Usuario;

public class UsuarioDAO {

	private int usuarioExcluir;

	public void cadastraUsuario(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome,cpf,email,senha,telefone) VALUES (?, ?, ?, ?, ? )";
		PreparedStatement pstm = null;
		Connection con = null;

		try {

			con = Conexao.createConnectionToMySQL();

			pstm = con.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());

			pstm.setString(2, usuario.getCpf());

			pstm.setString(3, usuario.getEmail());

			pstm.setString(4, usuario.getSenha());

			pstm.setString(5, usuario.getTelefone());

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

	public List<Usuario> listarUsuario() {
		String sql = "SELECT * FROM usuario";
		PreparedStatement pstm = null;
		Connection con = null;
		ResultSet rs = null;
		List<Usuario> usuarios = new ArrayList<>();

		try {
			con = Conexao.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();

			while (rs.next()) {
				Usuario usuario = new Usuario();

				usuario.setNome(rs.getString("nome"));
				usuario.setCpf(rs.getString("cpf"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuario.setTelefone(rs.getString("telefone"));
				usuarios.add(usuario);
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao listar usuários");
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
		return usuarios;
	}

	public void atualizarUsuario(Usuario usuario, int id) {
		String sql = "UPDATE usuario SET nome = ?, cpf = ?, email = ?, senha = ?, telefone = ? WHERE id = ?";
		PreparedStatement pstm = null;
		Connection con = null;

		try {
			con = Conexao.createConnectionToMySQL();
			pstm = con.prepareStatement(sql);

			pstm.setString(1, usuario.getNome());

			pstm.setString(2, usuario.getCpf());

			pstm.setString(3, usuario.getEmail());

			pstm.setString(4, usuario.getSenha());

			pstm.setString(5, usuario.getTelefone());
			pstm.setInt(6, id);

			pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro ao atualizar usuário");
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

	public void excluirUsuario(int id) throws Exception {
		String sql = "DELETE FROM usuario WHERE id = ?";
		Connection con = null;
		con = Conexao.createConnectionToMySQL();
		try (PreparedStatement stmt = con.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public Usuario buscarUsuario(int id) {

		Usuario usuario = null;

		String sql = "SELECT * FROM usuario WHERE id   = ?";

		try (PreparedStatement stmt = Conexao.prepareStatement(sql)) {

			stmt.setInt(1, id);

			ResultSet resultado = stmt.executeQuery();

			if (resultado.next()) {

				usuario = new Usuario();

				usuario.setId(resultado.getInt("id"));

				usuario.setNome(resultado.getString("nome"));

				usuario.setCpf(resultado.getString("cpfUsuario"));

				usuario.setEmail(resultado.getString("email"));

				usuario.setTelefone(resultado.getString("telefone"));
			}

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return usuario;

	}

	public void atualizarUsuario1(Usuario usuarioAtualizar) {

	}

	public void excluirConsulta(int usuarioIdExcluir) {

	}

}
