package Entrega2;

public class VeiculoPasseio extends Veiculo{
	private String categoria;
	private boolean arCondicionado, dirHidraulica, automatico;
	
	public VeiculoPasseio(String marca, String modelo, String tipo, int anoFabricacao, int anoModelo, int renavam,
			int capTanque, float valorDiaria, String categoria, boolean arCondicionado, boolean dirHidraulica,
			boolean automatico) {
		super(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria);
		this.categoria = categoria;
		this.arCondicionado = arCondicionado;
		this.dirHidraulica = dirHidraulica;
		this.automatico = automatico;
	}

	public VeiculoPasseio() {
		
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public boolean isArCondicionado() {
		return arCondicionado;
	}

	public void setArCondicionado(boolean arCondicionado) {
		this.arCondicionado = arCondicionado;
	}

	public boolean isDirHidraulica() {
		return dirHidraulica;
	}

	public void setDirHidraulica(boolean dirHidraulica) {
		this.dirHidraulica = dirHidraulica;
	}

	public boolean isAutomatico() {
		return automatico;
	}

	public void setAutomatico(boolean automatico) {
		this.automatico = automatico;
	}
	
	
	
}
