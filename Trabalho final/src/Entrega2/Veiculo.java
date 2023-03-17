package Entrega2;

public class Veiculo {
	private boolean reservado = false;
	private String marca, modelo, tipo;
	private int anoFabricacao, anoModelo, renavam, capTanque;
	private float valorDiaria, valorDiariaReduzida, valorDiariaEmpresarial, valorDiariaMensal;
	
	public Veiculo() {
		
	}

	public Veiculo(String marca, String modelo, String tipo, int anoFabricacao, int anoModelo, int renavam,
			int capTanque, float valorDiaria) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.tipo = tipo;
		this.anoFabricacao = anoFabricacao;
		this.anoModelo = anoModelo;
		this.renavam = renavam;
		this.capTanque = capTanque;
		this.valorDiaria = valorDiaria;
		this.precoDiarias();
		
	}


	
	public void precoDiarias() {
		valorDiariaReduzida = (float) (valorDiaria*0.9); // Di�ria reduzida 10% de desconto
		valorDiariaEmpresarial = (float) (valorDiaria*0.86); // Di�ria empresarial tem um desconto de 15%
		valorDiariaMensal =  (float) (valorDiaria*0.80); // Di�ria mensal tem um desconto de 20%
	}
	
	
	
	public float getValorDiariaReduzida() {
		return valorDiariaReduzida;
	}

	public void setValorDiariaReduzida(float valorDiariaReduzida) {
		this.valorDiariaReduzida = valorDiariaReduzida;
	}

	public float getValorDiariaEmpresarial() {
		return valorDiariaEmpresarial;
	}

	public void setValorDiariaEmpresarial(float valorDiariaEmpresarial) {
		this.valorDiariaEmpresarial = valorDiariaEmpresarial;
	}

	public float getValorDiariaMensal() {
		return valorDiariaMensal;
	}

	public void setValorDiariaMensal(float valorDiariaMensal) {
		this.valorDiariaMensal = valorDiariaMensal;
	}

	public boolean isReservado() {
		return reservado;
	}

	public void setReservado(boolean reservado) {
		this.reservado = reservado;
	}
	
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getModelo() {
		return modelo;
	}
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
	public int getAnoFabricacao() {
		return anoFabricacao;
	}
	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}
	public int getAnoModelo() {
		return anoModelo;
	}
	public void setAnoModelo(int anoModelo) {
		this.anoModelo = anoModelo;
	}
	public int getRenavam() {
		return renavam;
	}
	public void setRenavam(int renavam) {
		this.renavam = renavam;
	}
	public int getCapTanque() {
		return capTanque;
	}
	public void setCapTanque(int capTanque) {
		this.capTanque = capTanque;
	}
	public float getValorDiaria() {
		return valorDiaria;
	}
	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

}
