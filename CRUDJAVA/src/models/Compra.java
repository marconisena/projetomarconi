package models;

public class Compra {

	private int id;
	private int id_usuario;
	private int id_passagem;

	public Compra(int id_usuario, int id_passagem) {
		this.id_usuario = id_usuario;
		this.id_passagem = id_passagem;
	}

	public Compra() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int string) {
		this.id_usuario = string;
	}

	public  int getId_passagem() {
		return id_passagem;
	}

	public void setId_passagem(int id_passagem) {
		this.id_passagem = id_passagem;
	}

	public void setId_passagem(Passagem buscarUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void setId_usuario(Usuario buscarUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void inserirCompra(int idDaCompra, int idDoUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void inserirCompra(int iDoPassagem, int idDaCompra, int idDoUsuario) {
		// TODO Auto-generated method stub
		
	}

	public void atualizarCompra(int idDaCompraParaAtualizar, int novoIdDoUsuario) {
		// TODO Auto-generated method stub
		
	}





}
