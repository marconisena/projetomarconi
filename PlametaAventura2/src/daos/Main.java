package daos;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import models.Compra;
import models.Passagem;
import models.Usuario;

public class Main {

	private static final Calendar cal = null;
	private static Scanner scanner;

	public static void main(String[] args) throws Exception {
		Calendar cal = Calendar.getInstance();
		
		Usuario usuario1 = new Usuario();
		usuario1.setNome("pedro");
		usuario1.setCpf("11255000");
		usuario1.setEmail("joao.silv@uni9.br.com");
		usuario1.setSenha("1216");
		usuario1.setTelefone("119471444");

		UsuarioDAO usuarioDAO = new UsuarioDAO();
//	usuarioDAO.cadastraUsuario(usuario1);

	List<Usuario> usuarios1 = usuarioDAO.listarUsuario();
		for (Usuario u : usuarios1) {
		System.out.println("\nNome: " + u.getNome() + ", Cpf: " + u.getCpf() + ", Email: " + u.getEmail()
					+ ", Senha: " + u.getSenha() + ", Telefone: " + u.getTelefone());}
	
		
		usuario1.setNome("marconi");
		usuarioDAO.atualizarUsuario(usuario1, 1);


		usuarioDAO.excluirUsuario(1);
	Passagem passagem11 = new Passagem();
	passagem11.setDestino("");

		cal.set(2023, Calendar.JANUARY,7);
		passagem11.setData(new Date(cal.getTimeInMillis()));

		passagem11.setPreco(280.52);


		PassagemDAO passagemDAO = new PassagemDAO();
		passagemDAO.cadastrapassagem(passagem11);


	List<Passagem> passagens = passagemDAO.listarPassagem();
		for (Passagem p : passagens) {
			System.out.println("Destino: " + p.getDestino() + ", Data: " + p.getData() + ", Preço: " + p.getPreco());
	


		passagem11.setDestino("rio");
		passagemDAO.atualizarPassagem(passagem11.getId());

		passagemDAO.excluirPassagem(1);
    }
		
		Compra compra1 = new Compra();
		
		compra1.setId_passagem(5); 
		compra1.setId_usuario(6); 

		CompraDAO compraDAO = new CompraDAO();
		compraDAO.cadastraCompra(compra1);

	
		List<Compra> compras1 = compraDAO.listarCompras();
	for (Compra c : compras1) {
			 System.out.println("ID: " + c.getId() + ", ID Passagem: " +
			 c.getId_passagem() + ", ID Usuário: " + c.getId_usuario());
		
		compraDAO.AtualizarCompra(compra1.getId());
		
		compraDAO.excluirCompra(4);
	}
	}
}
	
	
	
