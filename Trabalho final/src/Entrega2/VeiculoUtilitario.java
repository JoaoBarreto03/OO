package Entrega2;

public class VeiculoUtilitario extends Veiculo{
	private int capacidadeCarga;

	public VeiculoUtilitario(String marca, String modelo, String tipo, int anoFabricacao, int anoModelo, int renavam,
			int capTanque, float valorDiaria, int capacidadeCarga) {
		super(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria);
		this.capacidadeCarga = capacidadeCarga;
	}

	public int getCapacidadeCarga() {
		return capacidadeCarga;
	}

	public void setCapacidadeCarga(int capacidadeCarga) {
		this.capacidadeCarga = capacidadeCarga;
	}
	
	
	
	
}