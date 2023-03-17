package Entrega2;

public class Reserva {
	private int diarias, numReserva;
	private float valorSeguroTerceiro, valorSeguroCarro, valorImposto, valorTotal, valorDiaria, valorDiarias;
	private boolean seguroCarro;
	private String tipoDiaria, dataLocacao, horaLocacao, dataEntrega, horaEntrega;
	private PessoaFisica locador = null;
	private Veiculo veiculoLocado = null;
	private PessoaJuridica empresa = null;
	
	public Reserva() {
		
	}

	public Reserva(int diarias, float valorSeguroTerceiro, float valorSeguroCarro, float valorImposto, float valorTotal,
			float valorDiaria, float valorDiarias, boolean seguroCarro, String tipoDiaria, int numReserva,
			String dataLocacao, String horaLocacao, String dataEntrega, PessoaFisica locador, Veiculo veiculoLocado) {
		super();
		this.diarias = diarias;
		this.valorSeguroTerceiro = valorSeguroTerceiro;
		this.valorSeguroCarro = valorSeguroCarro;
		this.valorImposto = valorImposto;
		this.valorTotal = valorTotal;
		this.valorDiaria = valorDiaria;
		this.valorDiarias = valorDiarias;
		this.seguroCarro = seguroCarro;
		this.tipoDiaria = tipoDiaria;
		this.numReserva = numReserva;
		this.dataLocacao = dataLocacao;
		this.horaLocacao = horaLocacao;
		this.dataEntrega = dataEntrega;
		this.locador = locador;
		this.veiculoLocado = veiculoLocado;
		this.horaEntrega = horaLocacao;	
	}

	public Reserva(int diarias, int numReserva, float valorSeguroTerceiro, float valorSeguroCarro, float valorImposto,
			float valorTotal, float valorDiaria, float valorDiarias, boolean seguroCarro, String tipoDiaria,
			String dataLocacao, String horaLocacao, String dataEntrega, PessoaFisica locador, Veiculo veiculoLocado,
			PessoaJuridica empresa) {
		super();
		this.diarias = diarias;
		this.numReserva = numReserva;
		this.valorSeguroTerceiro = valorSeguroTerceiro;
		this.valorSeguroCarro = valorSeguroCarro;
		this.valorImposto = valorImposto;
		this.valorTotal = valorTotal;
		this.valorDiaria = valorDiaria;
		this.valorDiarias = valorDiarias;
		this.seguroCarro = seguroCarro;
		this.tipoDiaria = tipoDiaria;
		this.dataLocacao = dataLocacao;
		this.horaLocacao = horaLocacao;
		this.dataEntrega = dataEntrega;
		this.locador = locador;
		this.veiculoLocado = veiculoLocado;
		this.empresa = empresa;
		this.horaEntrega = horaLocacao;
	}

	public PessoaJuridica getEmpresa() {
		return empresa;
	}

	public void setEmpresa(PessoaJuridica empresa) {
		this.empresa = empresa;
	}

	public float getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(float valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public float getValorDiarias() {
		return valorDiarias;
	}

	public void setValorDiarias(float valorDiarias) {
		this.valorDiarias = valorDiarias;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public PessoaFisica getLocador() {
		return locador;
	}

	public void setLocador(PessoaFisica locador) {
		this.locador = locador;
	}


	public Veiculo getVeiculoLocado() {
		return veiculoLocado;
	}





	public void setVeiculoLocado(Veiculo veiculoLocado) {
		this.veiculoLocado = veiculoLocado;
	}





	public int getDiarias() {
		return diarias;
	}

	public void setDiarias(int diarias) {
		this.diarias = diarias;
	}

	public float getValorSeguroTerceiro() {
		return valorSeguroTerceiro;
	}

	public void setValorSeguroTerceiro(float valorSeguroTerceiro) {
		this.valorSeguroTerceiro = valorSeguroTerceiro;
	}

	public float getValorSeguroCarro() {
		return valorSeguroCarro;
	}

	public void setValorSeguroCarro(float valorSeguroCarro) {
		this.valorSeguroCarro = valorSeguroCarro;
	}

	public float getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(float valorImposto) {
		this.valorImposto = valorImposto;
	}

	public boolean isSeguroCarro() {
		return seguroCarro;
	}

	public void setSeguroCarro(boolean seguroCarro) {
		this.seguroCarro = seguroCarro;
	}

	public String getTipoDiaria() {
		return tipoDiaria;
	}

	public void setTipoDiaria(String tipoDiaria) {
		this.tipoDiaria = tipoDiaria;
	}

	public int getNumReserva() {
		return numReserva;
	}

	public void setNumReserva(int numReserva) {
		this.numReserva = numReserva;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getHoraLocacao() {
		return horaLocacao;
	}

	public void setHoraLocacao(String horaLocacao) {
		this.horaLocacao = horaLocacao;
	}

	public String getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(String dataEntrega) {
		this.dataEntrega = dataEntrega;
	}

	public String getHoraEntrega() {
		return horaEntrega;
	}

	public void setHoraEntrega(String horaEntrega) {
		this.horaEntrega = horaEntrega;
	}
	
}