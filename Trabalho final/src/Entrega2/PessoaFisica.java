package Entrega2;

public class PessoaFisica extends Locatario{
	private String nome, cpf, estadoCivil;
	private boolean jaEstaContratada = false;
	

	public PessoaFisica() {
		
	}

	public PessoaFisica(Endereco endereco, String email, String telefone, String nome, String cpf, String estadoCivil) {
		super(endereco, email, telefone);
		this.nome = nome;
		this.cpf = cpf;
		this.estadoCivil = estadoCivil;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public boolean isJaEstaContratada() {
		return jaEstaContratada;
	}

	public void setJaEstaContratada(boolean jaEstaContratada) {
		this.jaEstaContratada = jaEstaContratada;
	}
	
	
}