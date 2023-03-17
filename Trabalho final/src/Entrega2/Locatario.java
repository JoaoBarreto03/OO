package Entrega2;

public class Locatario {
	private String email, telefone;
	private Endereco endereco;
	private boolean locador = false; // verifica se a pessoa f�sica ou pessoa jur�dica est� locando algum carro
	private int locacoes = 0; // quantidade de loca��es 
	
	public Locatario() {
		
	}

	public Locatario(Endereco endereco, String email, String telefone) {
		this.endereco = endereco;
		this.email = email;
		this.telefone = telefone;
	}



	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public boolean isLocador() {
		return locador;
	}

	public void setLocador(boolean locador) {
		this.locador = locador;
	}

	public int getLocacoes() {
		return locacoes;
	}

	public void setLocacoes(int locacoes) {
		this.locacoes = locacoes;
	}
	
}