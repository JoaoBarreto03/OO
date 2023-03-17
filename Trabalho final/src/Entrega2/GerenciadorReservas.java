package Entrega2;

import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorReservas {
	List<Reserva> reservas = new LinkedList<>();
	DecimalFormat df = new DecimalFormat("0.00");
	SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
	SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
	
	public boolean cadastrarReserva(Reserva reserva) {
		boolean resp = false;
		
		if(reserva != null) {
			resp = reservas.add(reserva);
			//aumenta em 1 o n�mero de loca��es que a pf e/ou pj fizeram.
			reserva.getLocador().setLocacoes(reserva.getLocador().getLocacoes()+1);
			if(reserva.getEmpresa() != null) {
				reserva.getEmpresa().setLocacoes(reserva.getEmpresa().getLocacoes()+1);
			}
		}
		
		return resp;
	}
	
	public Reserva pesquisarReservas(int numReserva) {
		Reserva r = null;
		if(reservas != null) {
			for(Reserva p : reservas) {
				if(p.getNumReserva() == numReserva) {
					r = p;
				}
			}
		}
		
		return r;
	}
	
	public boolean excluirReserva(int num) {
		Reserva reserva = null;
		boolean resp = false;
		
		reserva = pesquisarReservas(num);
		
		if(reserva != null && reservas.size() > 0) {
			reserva.getVeiculoLocado().setReservado(false); // agora o veiculo n�o est� mais locado
			if(reserva.getLocador().getLocacoes() == 1) { // se for igual 1 significa que ap�s essa exclus�o a pf n�o estar� locando mais nenhum carro
				reserva.getLocador().setLocador(false); // agora o locador n�o est� locando mais o ve�culo
			}
			if(reserva.getEmpresa() != null) {
				if(reserva.getEmpresa().getLocacoes() == 1) { // se a quantidade de loca��es for igual a 1 significa que ap�s essa exclus�o do carro a pj n�o est� mais locando nenhum carro
					reserva.getEmpresa().setLocador(false); // agora a empresa n�o est� mais locando o ve�culo
				}
				reserva.getEmpresa().setLocacoes(reserva.getEmpresa().getLocacoes()-1); // diminui em 1 a quantidade de loca��es da pj
			}
			reserva.getLocador().setLocacoes(reserva.getLocador().getLocacoes()-1); // diminui em 1 a quantidade de loca��es da pf
			resp = reservas.remove(reserva);
		}
		
		return resp;
	}
	
	public boolean editarReserva(int num) {
		int temp = 0;
		Reserva reserva = null;
		boolean resp = false, validaEmBranco = false, novamente = true;
		String escolha = null;
		
		reserva = pesquisarReservas(num);
		
		if(reserva != null && reservas.size() > 0) {
			resp = true;	
			while(novamente) {
				temp = 0;
				while(!validaEmBranco) {
					escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Di�rias\n[B] Seguro pr�prio\n[C] Data loca��o\n[D] Hora loca��o").toUpperCase();
					validaEmBranco = Main.verifica(escolha); 
					temp = Main.valido(escolha, 4);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				switch(escolha) {
					case "A":
						String strDiarias, dataEntrega = null;
						int diarias = 0;
						float valorDiarias = 0, valorTotal = 0, valorSeguroCarro = 0, valorSeguroTerceiro = 0, valorImposto = 0;
						
						while(!validaEmBranco) {
							strDiarias = JOptionPane.showInputDialog("Digite quantas di�rias: ");
							validaEmBranco = Main.verifica(strDiarias);
							if(validaEmBranco) validaEmBranco = Main.verificaNum(strDiarias);
							if(validaEmBranco) diarias = Integer.parseInt(strDiarias);
						} validaEmBranco = false;
						
						
						
						
						if(diarias >= 30) {	
							reserva.setTipoDiaria("Mensal");
							reserva.setValorDiaria(reserva.getVeiculoLocado().getValorDiariaMensal());
							valorDiarias = diarias * reserva.getVeiculoLocado().getValorDiariaMensal();
							valorSeguroTerceiro = (float) (valorDiarias * 0.12);
							valorImposto = (float) (valorDiarias * 0.05);
							if(reserva.isSeguroCarro()) {
								valorSeguroCarro = (float) (valorDiarias * 0.08);
							}
							valorTotal = valorDiarias + valorSeguroCarro + valorSeguroTerceiro + valorImposto;
							
						} else {
							valorDiarias = diarias * reserva.getValorDiaria();
							valorSeguroTerceiro = (float) (valorDiarias * 0.12);
							valorImposto = (float) (valorDiarias * 0.05);
							if(reserva.isSeguroCarro()) {
								valorSeguroCarro = (float) (valorDiarias * 0.08);
							}
							
							valorTotal = valorDiarias + valorSeguroCarro + valorSeguroTerceiro + valorImposto;
						}
						
						reserva.setValorDiarias(valorDiarias);
						reserva.setDiarias(diarias);
						reserva.setValorSeguroTerceiro(valorSeguroTerceiro);
						reserva.setValorSeguroCarro(valorSeguroCarro);
						reserva.setValorImposto(valorImposto);
						
						
						dataEntrega = dataEntrega(reserva);
						reserva.setValorTotal(valorTotal);
						reserva.setDataEntrega(dataEntrega);
						break;
					case "B":
						boolean seguroCarro = false;
						float valorSeguroCarroB = 0;
						
						if(!reserva.isSeguroCarro()) {
							temp = JOptionPane.showConfirmDialog(null, "Deseja adicionar seguro de prote��o do pr�prio carro? (o valor � de 8% do valor total das di�rias: R$ "+df.format(reserva.getValorDiarias())+")\nQue seria de: R$ "+df.format(reserva.getValorDiarias()*0.08)+": ", "Seguro",JOptionPane.YES_NO_OPTION);	
							if(temp == 0) {
								seguroCarro = true;
								valorSeguroCarroB = (float) (reserva.getValorDiarias() * 0.08);
								valorTotal = valorSeguroCarroB + reserva.getValorTotal();
								reserva.setValorSeguroCarro(valorSeguroCarroB);
								reserva.setValorTotal(valorTotal);
								reserva.setSeguroCarro(seguroCarro);
							}
						} else {
							temp = JOptionPane.showConfirmDialog(null, "Deseja remover o seguro de prote��o do pr�prio carro? (o valor � de 8% do valor total das di�rias: R$ "+df.format(reserva.getValorDiarias())+")\nQue seria de: R$ "+df.format(reserva.getValorDiarias()*0.08)+": ", "Seguro",JOptionPane.YES_NO_OPTION);	
							if(temp == 0) {
								valorSeguroCarroB = (float) (reserva.getValorDiarias() * 0.08);
								valorTotal = reserva.getValorTotal() - valorSeguroCarroB;
								reserva.setValorTotal(valorTotal);
								reserva.setSeguroCarro(seguroCarro);
								reserva.setValorSeguroCarro(0);
							}
						}
						break;
					case "C":
						boolean valida = false;
						String strDataLocacao = null;
						Date dataLocacao = null, dataEntregaC = null;
						Calendar cal = Calendar.getInstance();
						
						while(!valida) {
							try {
								while(!validaEmBranco) {
									strDataLocacao = JOptionPane.showInputDialog("Digite a data de loca��o (OBS: No formato Dia/Mes/Ano): ");
									validaEmBranco = Main.verifica(strDataLocacao);
								} validaEmBranco = false;
								dataLocacao = formataData.parse(strDataLocacao);
								valida = true;
							} catch (HeadlessException | ParseException e) {
								JOptionPane.showMessageDialog(null, "Input inv�lido, tente novamente.");
							}
						} valida = false;
						
						cal.setTime(dataLocacao);
						cal.add(Calendar.DAY_OF_MONTH, reserva.getDiarias()); 
						dataEntregaC = cal.getTime();
						
						reserva.setDataLocacao(formataData.format(dataLocacao));
						reserva.setDataEntrega(formataData.format(dataEntregaC));
						break;
					case "D":
						valida = false;
						String strHora = null;
						Date horaLocacao = null;
						
						while(!valida) {
							try {
								while(!validaEmBranco) {
									strHora = JOptionPane.showInputDialog("Digite a hora de loca��o (OBS: no formato horas:minutos)	: ");
									validaEmBranco = Main.verifica(strHora);
								} validaEmBranco = false;
								horaLocacao = formataHora.parse(strHora);
								valida = true;
							} catch (HeadlessException | ParseException e) {
								JOptionPane.showMessageDialog(null, "Input inv�lido, tente novamente");
							}
						} valida = false;
						
						reserva.setHoraLocacao(formataHora.format(horaLocacao));
						reserva.setHoraEntrega(formataHora.format(horaLocacao));
						break;
					
				}
				temp = JOptionPane.showConfirmDialog(null, "Deseja atualizar outro dado?", "Autoriza��o",JOptionPane.YES_NO_OPTION);	
				if(temp == 1) novamente = false;
			}
		}
		
		return resp;
	}
	
	public String dataEntrega(Reserva r) {
		Calendar cal = Calendar.getInstance();
		Date dataEntrega = null;
		try {
			dataEntrega = formataData.parse(r.getDataLocacao());
		} catch (ParseException e) {
			
		}
		
		cal.setTime(dataEntrega);
		cal.add(Calendar.DAY_OF_MONTH, r.getDiarias());
		dataEntrega = cal.getTime();
		
		
		
		return formataData.format(dataEntrega);
	}
	
	public boolean emitirRelatorio(int numReserva) {
		boolean resp = false;
		Reserva r = null;
		r = pesquisarReservas(numReserva);
		if(r != null) {
			resp = true;
			if(r.getEmpresa() != null) {
				JOptionPane.showMessageDialog(null, "Reserva: "+r.getNumReserva()+"\nLocat�rio: "+r.getEmpresa().getNomeSocial()+"  || CNPJ: "+r.getEmpresa().getCnpj()+"\nRespons�vel pela loca��o: "+r.getLocador().getNome()+"  || CPF: "+r.getLocador().getCpf()+"\n\n\n****************************** Dados da Loca��o ******************************\n\nIn�cio: "+r.getDataLocacao()+" - "+r.getHoraLocacao()+"\nFim: "+r.getDataEntrega()+" - "+r.getHoraEntrega()+"\nN�mero de di�rias: "+r.getDiarias()+"\n\nTipo: "+r.getVeiculoLocado().getTipo()+"\nVe�culo: "+r.getVeiculoLocado().getMarca()+" - "+r.getVeiculoLocado().getModelo()+"\nAno de fabrica��o / modelo: "+r.getVeiculoLocado().getAnoFabricacao()+" / "+r.getVeiculoLocado().getAnoModelo()+"\nRENAVAM: "+r.getVeiculoLocado().getRenavam()+"\n\nTipo da di�ria: "+r.getTipoDiaria()+"\nValor da di�ria: R$ "+df.format(r.getValorDiaria())+"\nValor total das di�rias: R$ "+df.format(r.getValorDiarias())+"\nValor do seguro de terceiros: R$ "+df.format(r.getValorSeguroTerceiro())+"\nValor do seguro pr�prio R$ "+df.format(r.getValorSeguroCarro())+"\nValor dos impostos: R$ "+df.format(r.getValorImposto())+"\nValor total da loca��o: R$ "+df.format(r.getValorTotal()));
			} else {
				JOptionPane.showMessageDialog(null, "Reserva: "+r.getNumReserva()+"\nLocat�rio: "+r.getLocador().getNome()+"\nRespons�vel pela loca��o: "+r.getLocador().getNome()+" || CPF: "+r.getLocador().getCpf()+"\n\n\n****************************** Dados da Loca��o ******************************\n\nIn�cio: "+r.getDataLocacao()+" - "+r.getHoraLocacao()+"\nFim: "+r.getDataEntrega()+" - "+r.getHoraEntrega()+"\nN�mero de di�rias: "+r.getDiarias()+"\n\nTipo: "+r.getVeiculoLocado().getTipo()+"\nVe�culo: "+r.getVeiculoLocado().getMarca()+" - "+r.getVeiculoLocado().getModelo()+"\nAno de fabrica��o / modelo: "+r.getVeiculoLocado().getAnoFabricacao()+" / "+r.getVeiculoLocado().getAnoModelo()+"\nRENAVAM: "+r.getVeiculoLocado().getRenavam()+"\n\nTipo da di�ria: "+r.getTipoDiaria()+"\nValor da di�ria: R$ "+df.format(r.getValorDiaria())+"\nValor total das di�rias: R$ "+df.format(r.getValorDiarias())+"\nValor do seguro de terceiros: R$ "+df.format(r.getValorSeguroTerceiro())+"\nValor do seguro pr�prio R$ "+df.format(r.getValorSeguroCarro())+"\nValor dos impostos: R$ "+df.format(r.getValorImposto())+"\nValor total da loca��o: R$ "+df.format(r.getValorTotal()));
			}
		}
		
		return resp;
	}
	
	public boolean emitirRelatorios() {
		boolean resp = false;
		int i = 0;
		float valorTotal = 0, valorTotalSeguroTerceiro = 0, valorTotalSeguroProprio = 0, valorTotalImpostos = 0;
		List<String> stringReservas= new LinkedList<>();
		String reservaFinal = "\n";
		
		if(reservas.size() == 0) {
			JOptionPane.showMessageDialog(null, "N�o h� reservas cadastradas.");
		} else {
			resp = true;
			
			for(Reserva r : reservas) {
				stringReservas.add("N�: "+r.getNumReserva()+"                   "+r.getDataLocacao()+" - "+r.getHoraLocacao()+"        "+r.getDataEntrega()+" - "+r.getHoraEntrega()+"        "+r.getVeiculoLocado().getMarca()+" - "+r.getVeiculoLocado().getModelo()+"           R$ "+df.format(r.getValorSeguroTerceiro())+"            R$ "+df.format(r.getValorSeguroCarro())+"            R$ "+df.format(r.getValorImposto())+"         R$ "+df.format(r.getValorTotal())+"\n");
				valorTotalImpostos += r.getValorImposto();
				valorTotalSeguroProprio += r.getValorSeguroCarro();
				valorTotalSeguroTerceiro += r.getValorSeguroTerceiro();
				valorTotal += r.getValorTotal();
			}
			
			for(i = 0; i < stringReservas.size(); i++) {
				reservaFinal += stringReservas.get(i);
			}
			
			JOptionPane.showMessageDialog(null, "                                                                                                                                 Valor                     Valor                        "
					+"\n                                                                                                                                 Seguro                 Seguro          Valor              "
					+"\nRESERVA          In�cio                             Fim                               Ve�culo             Terceiros             Pr�prio          Impostos          Valor Total"+"\n****************************************************************************************************************************************************************************"
					+ reservaFinal + "****************************************************************************************************************************************************************************"
					+"\n                                                                                                                                  R$ "+df.format(valorTotalSeguroTerceiro)+"            R$ "+df.format(valorTotalSeguroProprio)+"           R$ "+df.format(valorTotalImpostos)+"           R$ "+df.format(valorTotal));
		}
		
		
		return resp;
	}
	

	
}
