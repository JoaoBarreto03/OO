package Entrega2;

public class VeiculoCarga extends VeiculoUtilitario{
	private int tara, tamCompartimento;
	private String tipoCarga;
	
	public VeiculoCarga(String marca, String modelo, String tipo, int anoFabricacao, int anoModelo, int renavam,
			int capTanque, float valorDiaria, int capacidadeCarga, int tara, int tamCompartimento, String tipoCarga) {
		super(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria, capacidadeCarga);
		this.tara = tara;
		this.tamCompartimento = tamCompartimento;
		this.tipoCarga = tipoCarga;
	}

	public int getTara() {
		return tara;
	}

	public void setTara(int tara) {
		this.tara = tara;
	}

	public int getTamCompartimento() {
		return tamCompartimento;
	}

	public void setTamCompartimento(int tamCompartimento) {
		this.tamCompartimento = tamCompartimento;
	}

	public String getTipoCarga() {
		return tipoCarga;
	}

	public void setTipoCarga(String tipoCarga) {
		this.tipoCarga = tipoCarga;
	}
	
	
	
	
	
	
}