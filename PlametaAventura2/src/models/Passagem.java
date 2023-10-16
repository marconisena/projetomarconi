package models;

import java.sql.Date;

public class Passagem {
   private int id;
	public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

	private String Destino;
	private Date data;
	private Double preco;

	

	

	public Passagem(String destino, Date data, Double preco) {
		
		Destino = destino;
		this.data = data;
		this.preco = preco;
	}

	public Passagem() {
		
	}

	public String getDestino() {
		return Destino;
	}

	public void setDestino(String destino) {
		Destino = destino;
	}

	public Date getData() {
		return data;
	}

	public void setData(java.util.Date date) {
		this.data = (Date) date;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double string) {
		this.preco = string;
	}

	public Date setData() {

		return null;
	}

	public void setDescricaoPassagem(String nextLine) {
		
		
	}



	public void setPassagem(Passagem passagemConsulta) {
		
		
	}

	public void inserirPassagem(String destino2, String data2, double preco2) {
		
		
	}

	public String getData_passagem() {
		// TODO Auto-generated method stub
		return null;
	}

	

	
}