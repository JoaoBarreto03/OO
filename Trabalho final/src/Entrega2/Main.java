package Entrega2;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.awt.HeadlessException;
import java.text.DecimalFormat;
import java.text.ParseException;

import javax.swing.JOptionPane;


public class Main {
	
	static GerenciarVeiculo gerenciaVeic = new GerenciarVeiculo();
	static GerenciadorLocatario gerenciaLoc = new GerenciadorLocatario();
	static GerenciadorReservas gerenciaReserva = new GerenciadorReservas();
	static int numReserva = 1;
	
	
	public static void main(String[] args) {
		int valida = 0;
		char escolha1 = 0;
		boolean emBranco = false;
		
		while(escolha1 != 'D') {
			String strEscolha1 = null;
			while(!emBranco) {
				strEscolha1 = JOptionPane.showInputDialog("========MENU PRINCIPAL=========\nA) Gerenciar Locat�rios\nB) Gerenciar Frota\nC) Gerenciar Reservar\nD) Sair do Programa");
				emBranco = verifica(strEscolha1);
			} emBranco = false;
			strEscolha1 = strEscolha1.toUpperCase();
			escolha1 = strEscolha1.charAt(0);
			valida = valido(strEscolha1,4); 
			if(valida == 1) {
				valida = 0;
				switch(escolha1) {					
					case 'A':
						String strEscolhaA = null;
						while(!emBranco || valida == 0) {
							strEscolhaA = JOptionPane.showInputDialog("Menu Gerenciar Locat�rios:\nA) Cadastrar Locat�rio\nB) Buscar Locat�rio\nC) Editar Locat�rio\nD) Excluir locat�rio\nE) Menu principal").toUpperCase();
							emBranco = verifica(strEscolhaA);
							valida = valido(strEscolhaA, 5);
						} emBranco = false; valida = 0;
						char escolhaA = strEscolhaA.charAt(0); 
						casoA(escolhaA);
						break;
			
					case 'B':
						String strEscolhaB = null;
						while(!emBranco || valida == 0) {
							strEscolhaB = JOptionPane.showInputDialog("Menu Ger�ncia de Frotas:\nA) Cadastrar ve�culos\nB) Pesquisar Ve�culo\nC) Atualizar dados de um ve�culo\nD) Remover ve�culo da frota\nE) Menu principal").toUpperCase();
							emBranco = verifica(strEscolhaB);
							valida = valido(strEscolhaB, 5);
						} emBranco = false; valida = 0;
						char escolhaB = strEscolhaB.charAt(0);
						casoB(escolhaB);
						break;
					case 'C':
						String strEscolhaC = null;
						while(!emBranco || valida == 0) {
							strEscolhaC = JOptionPane.showInputDialog("Menu Ger�ncia de Reservas:\nA) Cadastrar reserva\nB) Pesquisar/Emitir relat�rio de uma reserva\nC) Emitir relat�rios de reservas\nD) Excluir reserva\nE) Editar reserva\nF) Menu principal").toUpperCase();
							emBranco = verifica(strEscolhaC);
							valida = valido(strEscolhaC, 6);
						} emBranco = false; valida = 0;
						char escolhaC = strEscolhaC.charAt(0);
						casoC(escolhaC);
						break;
					case 'D':
						int escolha = JOptionPane.showConfirmDialog(null, "Deseja mesmo sair?");
						if(escolha != 0) {
							escolha1 = ' ';
							JOptionPane.showMessageDialog(null, "Retornando ao menu principal.");
						}
						break;
				}
			} 
			
		}
		
	}
	
	private static void casoC(char escolhaC) {
		boolean emBranco = false;
		int valida = 0;
		switch(escolhaC) {
			case 'A':
				String escolha = null;
				while(!emBranco || valida == 0) {
					escolha = JOptionPane.showInputDialog("Menu de Cadastro de Ve�culos:\nA) Reserva por pessoa f�sica\nB) Reserva por pessoa jur�dica\nC) Menu principal").toUpperCase();
					emBranco = verifica(escolha);
					valida = valido(escolha, 3);
				} emBranco = false; valida = 0;
				char escolhaChar = escolha.charAt(0); 
				escolhaC_A(escolhaChar);
				break;
			case 'B':
				escolhaC_B();
				break;
			case 'C':
				escolhaC_C();
				break;
			case 'D':
				escolhaC_D();
				break;
			case 'E':
				escolhaC_E();
				break;
			case 'F':
				menuPrincipal();
				break;
				
		}
		
	}

	private static void escolhaC_E() {
		
		boolean validaEmBranco = false, resp = false;
		int numeroReserva = 0;
		String strNumeroReserva = null;
		while(!validaEmBranco) {
			strNumeroReserva = JOptionPane.showInputDialog("Digite o numero da reserva: ");
			validaEmBranco = verifica(strNumeroReserva);
			if(validaEmBranco) validaEmBranco = verificaNum(strNumeroReserva); 
			if(validaEmBranco) numeroReserva = Integer.parseInt(strNumeroReserva); 
		} validaEmBranco = false;
		
		resp = gerenciaReserva.editarReserva(numeroReserva);
		
		try {
			if(!resp) throw new ObjetoNaoEncontradoException();
			JOptionPane.showMessageDialog(null, "Dados atualizados com sucesso.");
		} catch(ObjetoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel atualizar os dados.");
		}
		
	}

	private static void escolhaC_D() {
		
		boolean validaEmBranco = false, resp = false;
		int numeroReserva = 0;
		String strNumeroReserva = null;
		while(!validaEmBranco) {
			strNumeroReserva = JOptionPane.showInputDialog("Digite o numero da reserva: ");
			validaEmBranco = verifica(strNumeroReserva);
			if(validaEmBranco) validaEmBranco = verificaNum(strNumeroReserva); 
			if(validaEmBranco) numeroReserva = Integer.parseInt(strNumeroReserva); 
		} validaEmBranco = false;
		
		resp = gerenciaReserva.excluirReserva(numeroReserva);
		try {
			if(!resp) throw new ObjetoNaoEncontradoException();
			JOptionPane.showMessageDialog(null, "Reserva excluida com sucesso.");
		} catch(ObjetoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "Reserva n�o foi encontrada.");
		}
		
	}

	private static void escolhaC_C() {
		boolean resp = false;
		
		resp = gerenciaReserva.emitirRelatorios();
		
		
		try {
			if(!resp) throw new ObjetoNaoEncontradoException();
			JOptionPane.showMessageDialog(null, "Relat�rios emitidos com sucesso.");
		} catch(ObjetoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel a emiss�o dos relat�rios.");
		}
		
	}

	private static void escolhaC_B() {
		boolean validaEmBranco = false, resp = false;
		int numeroReserva = 0;
		String strNumeroReserva = null;
		while(!validaEmBranco) {
			strNumeroReserva = JOptionPane.showInputDialog("Digite o numero da reserva: ");
			validaEmBranco = verifica(strNumeroReserva);
			if(validaEmBranco) validaEmBranco = verificaNum(strNumeroReserva); 
			if(validaEmBranco) numeroReserva = Integer.parseInt(strNumeroReserva); 
		} validaEmBranco = false;
		
		resp = gerenciaReserva.emitirRelatorio(numeroReserva);
		
		try {
			if(!resp) throw new ObjetoNaoEncontradoException();
			JOptionPane.showMessageDialog(null, "Emiss�o de relat�rio concluida com sucesso.");
		} catch(ObjetoNaoEncontradoException e) {
			JOptionPane.showMessageDialog(null, "N�o foi poss�vel a emiss�o do relat�rio.");
		}
	}

	private static void escolhaC_A(char escolhaChar) {
		boolean validaEmBranco = false, valida = false, seguroCarro = false, resp = false;
		Veiculo v = new Veiculo();
		PessoaFisica p = new PessoaFisica();
		float valorSeguroTerceiro = 0, valorSeguroCarro = 0, valorImposto = 0, valorTotal = 0, valorDiaria = 0, valorDiarias = 0;
		String cpf = null, strDiarias = null, tipoDiaria = "Normal", strRenavam = null, strDataLocacao = null, strHora = null;
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat formataData = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat formataHora = new SimpleDateFormat("HH:mm");
		DecimalFormat df = new DecimalFormat("0.00");
		Date dataLocacao = null, dataEntrega = null; 
		Date horaLocacao = null;
		int diarias = 0, renavam = 0, temp = 0;
		
		
		switch(escolhaChar) {
			case 'A':
				
				while(!validaEmBranco) {
					strRenavam = JOptionPane.showInputDialog("Digite o RENAVAM do ve�culo que ser� locado: ");
					validaEmBranco = verifica(strRenavam);
					if(validaEmBranco) validaEmBranco = verificaNum(strRenavam);
					if(validaEmBranco) renavam = Integer.parseInt(strRenavam);
					v = gerenciaVeic.pesquisarRenavam_RetornaVeiculo(renavam, 1);
					if(v != null) {
						if(v.isReservado()) {
							JOptionPane.showMessageDialog(null, "O ve�culo ja est� locado.");
							v = null;
						}
					}
				} validaEmBranco = false;
				
				if(v != null) {
					valorDiaria = v.getValorDiaria();
					
					while(!validaEmBranco) {
						cpf = JOptionPane.showInputDialog("Digite o CPF: ");
						validaEmBranco = verifica(cpf);
						validaEmBranco = verificaNumLong(cpf);
						p = (PessoaFisica) gerenciaLoc.pesquisarLocatario(cpf, 1, "CPF", 1);
					} validaEmBranco = false;
					
					if(p != null) {
						while(!valida) {
							try {
								while(!validaEmBranco) {
									strDataLocacao = JOptionPane.showInputDialog("Digite a data de loca��o (OBS: No formato Dia/Mes/Ano): ");
									validaEmBranco = verifica(strDataLocacao);
								} validaEmBranco = false;
								dataLocacao = formataData.parse(strDataLocacao);
								valida = true;
							} catch (HeadlessException | ParseException e) {
								JOptionPane.showMessageDialog(null, "Input inv�lido, tente novamente.");
							}
						} valida = false;
						
						while(!valida) {
							try {
								while(!validaEmBranco) {
									strHora = JOptionPane.showInputDialog("Digite a hora de loca��o (OBS: no formato horas:minutos)	: ");
									validaEmBranco = verifica(strHora);
								} validaEmBranco = false;
								
								horaLocacao = formataHora.parse(strHora);
								valida = true;
							} catch (HeadlessException | ParseException e) {
								JOptionPane.showMessageDialog(null, "Input inv�lido, tente novamente");
							}
						} valida = false;
						
						while(!validaEmBranco) {
							strDiarias = JOptionPane.showInputDialog("Digite quantas di�rias: ");
							validaEmBranco = verifica(strDiarias);
							if(validaEmBranco) validaEmBranco = verificaNum(strDiarias);
							if(validaEmBranco) diarias = Integer.parseInt(strDiarias);
						} validaEmBranco = false;
						
						valorDiarias = valorDiaria * diarias;
						
						cal.setTime(dataLocacao);
						cal.add(Calendar.DAY_OF_MONTH, diarias); // Faz a soma das di�rias para saber quando vai ser o dia da entrega
						dataEntrega = cal.getTime();
						
						
						// coloquei essa de seguir no instagram para o desconto n�o ser t�o de gra�a, ao aceitar � entendido que o locador seguiu o instagram da empresa
						temp = JOptionPane.showConfirmDialog(null, "Deseja que o tipo de loca��o seja de di�ria reduzida? H� um desconto de 10% (verificar se o locador seguiu o instagram da empresa): ", "Di�ria",JOptionPane.YES_NO_OPTION);	
						if(temp == 0) {
							tipoDiaria = "Reduzida";
							valorDiaria = v.getValorDiariaReduzida();
							valorDiarias = valorDiaria * diarias;
						}
						
						if(diarias >= 30) {
							valorDiaria = v.getValorDiariaMensal();
							tipoDiaria = "Mensal";
							JOptionPane.showMessageDialog(null, "Como a loca��o foi mais de 30 dias o tipo de loca��o utilizada foi a mensal que possue 20% de desconto no valor da di�ria comum.\nValor di�ria antes: "+v.getValorDiaria()+"\nValor di�ria atual: "+v.getValorDiariaMensal());
							valorDiarias = valorDiaria * diarias;
						}
						
						valorSeguroTerceiro = (float) (valorDiarias * 0.12);
						valorImposto = (float) (valorDiarias * 0.05);
						
						valorTotal = valorDiarias + valorSeguroCarro + valorSeguroTerceiro + valorImposto;
						
						temp = JOptionPane.showConfirmDialog(null, "Deseja adicionar seguro de prote��o do pr�prio carro? (o valor � de 8% do valor total das di�rias: R$ "+df.format(valorDiarias)+")\nQue seria de: R$ "+df.format(valorDiarias*0.08)+": ", "Seguro",JOptionPane.YES_NO_OPTION);	
						if(temp == 0) {
							seguroCarro = true;
							valorSeguroCarro = (float) (valorDiarias * 0.08);
							valorTotal += valorSeguroCarro;
						}
						
						temp = JOptionPane.showConfirmDialog(null, "Di�rias: "+diarias+"\nValor da di�ria: R$ "+df.format(valorDiaria)+"\nValor total das di�rias: R$ "+df.format(valorDiarias)+"\nValor do seguro de terceiros (OBRIGAT�RIO, 12% do valor total das di�rias): R$ "+df.format(valorSeguroTerceiro)+"\nValor do seguro pr�prio (OPCIONAL, o valor � de 8% do valor total das di�rias): R$ "+df.format(valorSeguroCarro)+"\nValor dos impostos: (OBRIGAT�RIO, 5% do valor total das di�rias): R$ "+df.format(valorImposto)+"\nValor total: R$ "+df.format(valorTotal)+"\nDeseja concluir a loca��o: ", "Concluir loca��o",JOptionPane.YES_NO_OPTION);	
						if(temp == 0) {
							Reserva reserva = new Reserva(diarias, valorSeguroTerceiro, valorSeguroCarro, valorImposto, valorTotal, valorDiaria, valorDiarias, seguroCarro, tipoDiaria, numReserva, formataData.format(dataLocacao), formataHora.format(horaLocacao), formataData.format(dataEntrega) , p, v);
							resp = gerenciaReserva.cadastrarReserva(reserva);
							if(resp) {
								JOptionPane.showMessageDialog(null, "Loca��o concluida com sucesso. N�mero da reserva: "+numReserva+".\nN�o esque�a esse n�mero ele � utilizado para emitir o relat�rio da reserva.");
								v.setReservado(true);
								p.setLocador(true);
								numReserva++;
							}
						} 
						 
						
					}
				}
				break;
			case 'B':
				tipoDiaria = "Empresarial";
				PessoaJuridica pj = null;
				String cnpj = null;
				
				while(!validaEmBranco) {
					strRenavam = JOptionPane.showInputDialog("Digite o RENAVAM do ve�culo que ser� locado: ");
					validaEmBranco = verifica(strRenavam);
					if(validaEmBranco) validaEmBranco = verificaNum(strRenavam);
					if(validaEmBranco) renavam = Integer.parseInt(strRenavam);
					v = gerenciaVeic.pesquisarRenavam_RetornaVeiculo(renavam, 1);
					if(v != null) {
						if(v.isReservado()) {
							JOptionPane.showMessageDialog(null, "O ve�culo ja est� locado.");
							v = null;
						}
					}
				} validaEmBranco = false;
				
				if(v != null) {
					
					valorDiaria = v.getValorDiariaEmpresarial();
					
					while(!validaEmBranco) {
						cnpj = JOptionPane.showInputDialog("Digite o CNPJ: ");
						validaEmBranco = verifica(cnpj);
						validaEmBranco = verificaNumLong(cnpj);
						pj = (PessoaJuridica) gerenciaLoc.pesquisarLocatario(cnpj, 1, "CNPJ", 1);
					} validaEmBranco = false;
					
					
					if(pj != null) {
						
						while(!validaEmBranco) {
							cpf = JOptionPane.showInputDialog("Digite o CPF: ");
							validaEmBranco = verifica(cpf);
							validaEmBranco = verificaNumLong(cpf);
							p = (PessoaFisica) gerenciaLoc.pesquisarLocatario(cpf, 1, "CPF", 1);
							if(p != null) {
								if(!pj.verificaAutorizacao(p)) {
									JOptionPane.showMessageDialog(null, "O CPF informado n�o est� autorizado a fazer loca��es em nome da empresa: "+pj.getNomeSocial());
									p = null;
								}
							}
						} validaEmBranco = false;
						
						if(p != null) {
							while(!valida) {
								try {
									while(!validaEmBranco) {
										strDataLocacao = JOptionPane.showInputDialog("Digite a data de loca��o (OBS: No formato Dia/Mes/Ano): ");
										validaEmBranco = verifica(strDataLocacao);
									} validaEmBranco = false;
									dataLocacao = formataData.parse(strDataLocacao);
									valida = true;
								} catch (HeadlessException | ParseException e) {
									JOptionPane.showMessageDialog(null, "Input inv�lido, tente novamente.");
								}
							} valida = false;
							
							while(!valida) {
								try {
									while(!validaEmBranco) {
										strHora = JOptionPane.showInputDialog("Digite a hora de loca��o (OBS: no formato horas:minutos)	: ");
										validaEmBranco = verifica(strHora);
									} validaEmBranco = false;
									
									horaLocacao = formataHora.parse(strHora);
									valida = true;
								} catch (HeadlessException | ParseException e) {
									JOptionPane.showMessageDialog(null, "Input inv�lido, tente novamente");
								}
							} valida = false;
							while(!validaEmBranco) {
								strDiarias = JOptionPane.showInputDialog("Digite quantas di�rias (Obs: di�ria empresarial tem 14% de desconto): ");
								validaEmBranco = verifica(strDiarias);
								if(validaEmBranco) validaEmBranco = verificaNum(strDiarias);
								if(validaEmBranco) diarias = Integer.parseInt(strDiarias);
							} validaEmBranco = false;
							
							valorDiarias = valorDiaria * diarias;
							
							cal.setTime(dataLocacao);
							cal.add(Calendar.DAY_OF_MONTH, diarias);
							dataEntrega = cal.getTime();
							
							
							
							if(diarias >= 30) {
								valorDiaria = v.getValorDiariaMensal();
								tipoDiaria = "Mensal";
								JOptionPane.showMessageDialog(null, "Como a loca��o foi mais de 30 dias o tipo de loca��o utilizada foi a mensal que possue 20% de desconto no valor da di�ria comum.\nValor di�ria antes: "+v.getValorDiaria()+"\nValor di�ria atual: "+v.getValorDiariaMensal());
								valorDiarias = valorDiaria * diarias;
							}
							
							valorSeguroTerceiro = (float) (valorDiarias * 0.12);
							valorImposto = (float) (valorDiarias * 0.05);
							
							valorTotal = valorDiarias + valorSeguroCarro + valorSeguroTerceiro + valorImposto;
							
							temp = JOptionPane.showConfirmDialog(null, "Deseja adicionar seguro de prote��o do pr�prio carro? (o valor � de 8% do valor total das di�rias: R$ "+df.format(valorDiarias)+")\nQue seria de: R$ "+df.format(valorDiarias*0.08)+": ", "Seguro",JOptionPane.YES_NO_OPTION);	
							if(temp == 0) {
								seguroCarro = true;
								valorSeguroCarro = (float) (valorDiarias * 0.08);
								valorTotal += valorSeguroCarro;
							}
							
							temp = JOptionPane.showConfirmDialog(null, "Di�rias: "+diarias+"\nValor da di�ria: R$ "+df.format(valorDiaria)+"\nValor total das di�rias: R$ "+df.format(valorDiarias)+"\nValor do seguro de terceiros (OBRIGAT�RIO, 12% do valor total das di�rias): R$ "+df.format(valorSeguroTerceiro)+"\nValor do seguro pr�prio (OPCIONAL, o valor � de 8% do valor total das di�rias): R$ "+df.format(valorSeguroCarro)+"\nValor dos impostos: (OBRIGAT�RIO, 5% do valor total das di�rias): R$ "+df.format(valorImposto)+"\nValor total: R$ "+df.format(valorTotal)+"\nDeseja concluir a loca��o: ", "Concluir loca��o",JOptionPane.YES_NO_OPTION);	
							if(temp == 0) {
								Reserva reserva = new Reserva(diarias, numReserva, valorSeguroTerceiro, valorSeguroCarro, valorImposto, valorTotal, valorDiaria, valorDiarias, seguroCarro, tipoDiaria, formataData.format(dataLocacao), formataHora.format(horaLocacao), formataData.format(dataEntrega), p, v, pj);
								resp = gerenciaReserva.cadastrarReserva(reserva);
								if(resp) {
									JOptionPane.showMessageDialog(null, "Loca��o concluida com sucesso. N�mero da reserva: "+numReserva+".\nN�o esque�a esse n�mero ele � utilizado para emitir o relat�rio da reserva.");
									v.setReservado(true);
									p.setLocador(true);
									numReserva++;
								}
							} 
						}
					}
					
				}
				break;
			case 'C':
				menuPrincipal();
				break;
		}
		
	}

	private static void casoB(char escolhaB) {
		boolean emBranco = false;
		int valida = 0;
		
		switch(escolhaB) {
			case 'A':
				String strEscolhaCad = null;
				while(!emBranco || valida == 0) {
					strEscolhaCad = JOptionPane.showInputDialog("Menu de Cadastro de Ve�culos:\nA) Cadastrar ve�culo de passeio\nB) Cadastrar motocicleta\nC) Cadastrar ve�culo de carga\nD) Cadastrar ve�culo de passageiro\nE) Menu principal");
					emBranco = verifica(strEscolhaCad);
					valida = valido(strEscolhaCad, 5);
				} emBranco = false; valida = 0;
				strEscolhaCad = strEscolhaCad.toUpperCase();
				char escolhaCad = strEscolhaCad.charAt(0); 
				escolhaB_A(escolhaCad);
				break;
			case 'B':
				String strEscolhaPesq = null;
				while(!emBranco || valida == 0) {
					strEscolhaPesq = JOptionPane.showInputDialog("Menu de Pesquisa de Ve�culos:\nA) Pesquisar ve�culo pelo Renavam\nB) Pesquisar ve�culo por marca\nC) Pesquisar ve�culo por modelo\nD) Pesquisar ve�culo por tipo\nE) Pesquisar por categoria\nF) Menu principal");
					emBranco = verifica(strEscolhaPesq);
					valida = valido(strEscolhaPesq, 6);
				} emBranco = false; valida = 0;
				strEscolhaPesq = strEscolhaPesq.toUpperCase();
				char escolhaPesq = strEscolhaPesq.charAt(0); 
				escolhaB_B(escolhaPesq);
				break;
			case 'C':
				escolhaB_C();
				break;
			case 'D':
				escolhaB_D();
				break;
				
				
			case 'E':
				menuPrincipal();
				break;
				
		}
		
	}

	private static void escolhaB_C() {
		int renavam = 0;
		boolean resp = false;
		Veiculo v = null;
		
		renavam = funcRenavamPesquisa(false);
		
		v = gerenciaVeic.pesquisarRenavam_RetornaVeiculo(renavam, 1);
		
		
		if(v != null) {
			//Verifica se o ve�culo n�o est� locado, se estiver n�o ser� poss�vel atualizar os dados.
			if(!v.isReservado()) {
				
				resp = gerenciaVeic.atualizarDados(renavam);
				
				if(resp) {
					JOptionPane.showMessageDialog(null, "Dado do ve�culo atualizado com sucesso.");
				}
			} else {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel atualizar os dados desse ve�culo, ele est� locado no momento.");
			}
		}
		
	}

	private static String tipoVeiculo() {
		String strEscolha = null;
		int escolha = 0;
		boolean validaEmBranco = false;
		while(!validaEmBranco) {
			strEscolha = JOptionPane.showInputDialog("Qual o tipo do ve�culo:\n[A] Passeio\n[B] Motocicleta\n[C] Carga\n[D] Passageiro\n[E] Sair");
			strEscolha = strEscolha.toUpperCase();
			validaEmBranco = verifica(strEscolha);
			escolha = valido(strEscolha, 5);
			if(escolha == 0) validaEmBranco = false;
		} validaEmBranco = false;
		return strEscolha;
	}

	private static void escolhaB_D() {
		String strRenavam = null;
		boolean validaEmBranco = false, resp = false;
		int renavam = 0;
		Veiculo v = null;
		
		while(!validaEmBranco) {
			strRenavam = JOptionPane.showInputDialog("Digite o RENAVAM do ve�culo que ser� removido: ");
			validaEmBranco = verifica(strRenavam);
			if(validaEmBranco) validaEmBranco = verificaNum(strRenavam); 
			if(validaEmBranco) renavam = Integer.parseInt(strRenavam);
		}
		
		v = gerenciaVeic.pesquisarRenavam_RetornaVeiculo(renavam, 1);
		
		if(v != null) {
			if(!v.isReservado()) {
				resp = gerenciaVeic.excluirVeiculo(renavam);
				
				if(resp) {
					JOptionPane.showMessageDialog(null, "Ve�culo removido com sucesso");
				} 
			} else {
				JOptionPane.showMessageDialog(null, "N�o � poss�vel excluir esse ve�culo, ele est� locado no momento.");
			}
		}
		
		
		
		
	}

	//Menu de pesquisa de ve�culos
	private static void escolhaB_B(char escolhaPesq) {
		boolean validaEmBranco = false; boolean resp = false;
		switch(escolhaPesq) {
			case 'A':
				int renavam = 0;
				
				renavam = funcRenavamPesquisa(false);
				
				resp = gerenciaVeic.pesquisarRenavam(renavam,  1);
					
				
				
				break;
			case 'B':
				String strMarca = null; 
				validaEmBranco = false;
				
				while(!validaEmBranco) {
					strMarca = JOptionPane.showInputDialog("Digite a marca: ");
					validaEmBranco = verifica(strMarca);
				}
				resp = gerenciaVeic.pesquisarMarca(strMarca);
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "Nenhum ve�culo com essa marca foi encontrado no sistema.");
				}
				break;
			case 'C':
				String strModelo = null;
				validaEmBranco = false; 
				
				while(!validaEmBranco) {
					strModelo = JOptionPane.showInputDialog("Digite o modelo: ");
					validaEmBranco = verifica(strModelo);
				}
				resp = gerenciaVeic.pesquisarModelo(strModelo);
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "Nenhum ve�culo desse modelo foi encontrado no sistema.");
				}
				break;
			case 'D':
				String strTipo = null, escolha = null;
				
				strTipo = tipoVeiculo();
				escolha = tipo(strTipo);
				
				if(!strTipo.equalsIgnoreCase("E")) {
					resp = gerenciaVeic.pesquisarTipo(escolha);
					
					try {
						if(!resp) {
							throw new ObjetoNaoEncontradoException();
						}
					} catch(ObjetoNaoEncontradoException e) {
						JOptionPane.showMessageDialog(null, "Nenhum ve�culo desse tipo foi encontrado no sistema.");
					}
				}
				break;
			
				
			case 'E':
				String categoria = null;
				int temp = 0;
				
				while(!validaEmBranco) {
					categoria = JOptionPane.showInputDialog("Qual a categoria a ser pesquisada:\n[A] Compacto\n[B] Compacto de luxo\n[C] Sedan\n[D] SUV").toUpperCase();
					validaEmBranco = verifica(categoria);
					temp = valido(categoria, 4);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				
				switch(categoria) {
					case "A":
						categoria = "Compacto";
						break;
					case "B":
						categoria = "Compacto de luxo";
						break;
					case "C":
						categoria = "Sedan";
						break;
					case "D":
						categoria = "SUV";
						break;
				}
				
				resp = gerenciaVeic.pesquisarCategoria(categoria);
				
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "Nenhum ve�culo dessa categoria foi encontrado no sistema.");
				}
				
				break;
			case 'F':
				menuPrincipal();
				break;
				
				
		}
	}

	private static String tipo(String strEscolha) {
		String tipo = null;
		switch(strEscolha) {
		case "A":
			tipo = "Passeio";
			break;
		case "B":
			tipo = "Motocicleta";
			break;
		case "C":
			tipo = "Carga";
			break;
		case "D": 
			tipo = "Passageiro";
			break;
		case "E":
			menuPrincipal();
			break;
			
	}
		return tipo;
	}

	//Menu de cadastro de ve�culos
	private static void escolhaB_A(char escolhaCad) {
		boolean validaEmBranco = false, resp = false;
		String marca = null, modelo = null, categoria = null, tipo = null;
		int anoFabricacao = 0, anoModelo = 0, renavam = 0, capTanque = 0, temp = 0; 
		float valorDiaria = 0;
		
		switch(escolhaCad) {
		// Cadastro de ve�culos de passeio
			case 'A':
				
				tipo = "Passeio";
				
				boolean arCondicionado = false, dirHidraulica = false, automatico = false;
				
				
				JOptionPane.showMessageDialog(null, "==== Cadastro de ve�culos de passeio ====");
				
				marca = funcMarca(false);
				modelo = funcModelo(false);
				categoria = funcCategoria(false);
				anoFabricacao = funcAnoFabricacao(false);
				anoModelo = funcAnoModelo(false);
				renavam = funcRenavam(false);
				capTanque = funcCapTanque(false);
				valorDiaria = funcValorDiaria(false);
			
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue ar condicionado?", "Ar Condicionado",JOptionPane.YES_NO_OPTION);
				if(temp == 0) arCondicionado = true;
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue dire��o hidr�ulica?", "Dire��o Hidr�ulica",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) dirHidraulica = true;
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo � autom�tico?", "Autom�tico",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) automatico = true;
				
				VeiculoPasseio veiculo = new VeiculoPasseio(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria, categoria, arCondicionado, dirHidraulica, automatico);
				resp = gerenciaVeic.cadastrarVeiculo(veiculo);
				verificaCadastro(resp);
				break;
		// Cadastro de motocicletas
			case 'B':
				String modoConducao = null;
				boolean controleTracao = false, freioAbs = false, pilotoAut = false;
				tipo = "Motocicleta";
				
				JOptionPane.showMessageDialog(null, "==== Cadastro de motocicletas ====");
				marca = funcMarca(false);
				modelo = funcModelo(false);
				
				while(!validaEmBranco) {
					modoConducao = JOptionPane.showInputDialog("Modo de pilotagem:\n[A] Cidade\n[B] Estrada\n[C] Sport\n[D] Off-Road").toUpperCase();
					validaEmBranco = verifica(modoConducao); 
					temp = valido(modoConducao, 4);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				switch(modoConducao) {
					case "A":
						modoConducao = "Cidade";
						break;
					case "B":
						modoConducao = "Estrada";
						break;
					case "C":
						modoConducao = "Sport";
						break;
					case "D":
						modoConducao = "Off-Road";
						break;
				}
				
				anoFabricacao = funcAnoFabricacao(false);
				anoModelo = funcAnoModelo(false);
				renavam = funcRenavam(false);
				capTanque = funcCapTanque(false);
				valorDiaria = funcValorDiaria(false);
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue controle de tra��o?", "Tra��o",JOptionPane.YES_NO_OPTION);
				if(temp == 0) controleTracao = true;
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue freios abs?", "Freio Abs",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) freioAbs = true;
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue piloto autom�tico?", "Autom�tico",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) pilotoAut = true;
				
				Motocicleta moto = new Motocicleta(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria, controleTracao, freioAbs, pilotoAut, modoConducao);
				resp = gerenciaVeic.cadastrarVeiculo(moto);
				verificaCadastro(resp);	
				break;
				
			// Cadastro de ve�culos de carga
			case 'C':
				tipo = "Carga";
				int tara = 0, tamCompartimento = 0, capacidadeCarga = 0;
				String tipoCarga = null, strTara = null, strTamCompartimento = null, strCapacidadeCarga = null;
				
				
				marca = funcMarca(false);
				modelo = funcModelo(false);
				
				while(!validaEmBranco) {
					tipoCarga = JOptionPane.showInputDialog("Tipo de compartimento:\n[A] Ba� (carga-fechada)\n[B] Graneleiro (carga-aberta)\n[C] Basculante (carga aberta com capacidade de descarreg�-la)").toUpperCase();
					validaEmBranco = verifica(tipoCarga); 
					temp = valido(tipoCarga, 3);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				switch(tipoCarga) {
					case "A":
						tipoCarga = "Bau";
						break;
					case "B":
						tipoCarga = "Graneleiro";
						break;
					case "C":
						tipoCarga = "Basculante";
						break;
				}
				
				while(!validaEmBranco) {
					strCapacidadeCarga = JOptionPane.showInputDialog("Digite a capacidade de carga em KG: ");
					validaEmBranco = verifica(strCapacidadeCarga);
					if(validaEmBranco) validaEmBranco = verificaNum(strCapacidadeCarga);
					if(validaEmBranco) capacidadeCarga = Integer.parseInt(strCapacidadeCarga);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					strTara = JOptionPane.showInputDialog("Digite a tara do ve�culo (seu peso quando est� vazio) em KG: ");
					validaEmBranco = verifica(strTara);
					if(validaEmBranco) validaEmBranco = verificaNum(strTara);
					if(validaEmBranco) tara = Integer.parseInt(strTara);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					strTamCompartimento = JOptionPane.showInputDialog("Digite o tamanho do compartimento em litros: ");
					validaEmBranco = verifica(strTamCompartimento);
					if(validaEmBranco) validaEmBranco = verificaNum(strTamCompartimento);
					if(validaEmBranco) tamCompartimento = Integer.parseInt(strTamCompartimento);
				} validaEmBranco = false;
				
				anoFabricacao = funcAnoFabricacao(false);
				anoModelo = funcAnoModelo(false);
				renavam = funcRenavam(false);
				capTanque = funcCapTanque(false);
				valorDiaria = funcValorDiaria(false);
				
				VeiculoCarga veiculoCarga = new VeiculoCarga(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria, capacidadeCarga, tara, tamCompartimento, tipoCarga);
				resp = gerenciaVeic.cadastrarVeiculo(veiculoCarga);
				verificaCadastro(resp);
				break;
				
			case 'D':
				tipo = "Passageiro";
				int capacidadePassageiros = 0, capacidadeCargaP = 0;
				String strCapacidadePassageiros = null, strCapacidadeCargaP = null;
				boolean televisao = false, arCondicionadoP = false, dirHidraulicaP = false;
				
				
				marca = funcMarca(false);
				modelo = funcModelo(false);
				
				
				
				while(!validaEmBranco) {
					strCapacidadePassageiros = JOptionPane.showInputDialog("Digite a capacidade de passageiros contando com o motorista: ");
					validaEmBranco = verifica(strCapacidadePassageiros);
					if(validaEmBranco) validaEmBranco = verificaNum(strCapacidadePassageiros);
					if(validaEmBranco) capacidadePassageiros = Integer.parseInt(strCapacidadePassageiros);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					strCapacidadeCargaP = JOptionPane.showInputDialog("Digite a capacidade de carga em KG: ");
					validaEmBranco = verifica(strCapacidadeCargaP);
					if(validaEmBranco) validaEmBranco = verificaNum(strCapacidadeCargaP);
					if(validaEmBranco) capacidadeCargaP = Integer.parseInt(strCapacidadeCargaP);
				} validaEmBranco = false;
				
				
				anoFabricacao = funcAnoFabricacao(false);
				anoModelo = funcAnoModelo(false);
				renavam = funcRenavam(false);
				capTanque = funcCapTanque(false);
				valorDiaria = funcValorDiaria(false);
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue ar condicionado?", "Ar Condicionado",JOptionPane.YES_NO_OPTION);
				if(temp == 0) arCondicionadoP = true;
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue dire��o hidr�ulica?", "Dire��o Hidr�ulica",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) dirHidraulicaP = true;
				
				temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue TV a bordo?", "TV",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) televisao = true;
				
				VeiculoPassageiro veiculoPassageiro = new VeiculoPassageiro(marca, modelo, tipo, anoFabricacao, anoModelo, renavam, capTanque, valorDiaria, capacidadeCargaP, arCondicionadoP, dirHidraulicaP, televisao, capacidadePassageiros);
				resp = gerenciaVeic.cadastrarVeiculo(veiculoPassageiro);
				verificaCadastro(resp);
				break;
			case 'E':
				menuPrincipal();
				break;
				
		}
		
	}
	
	private static int funcRenavamPesquisa(boolean validaEmBranco) {
		String strRenavam = null;
		int renavam = 0;
		while(!validaEmBranco) {
			strRenavam = JOptionPane.showInputDialog("Digite o RENAVAM: ");
			validaEmBranco = verifica(strRenavam);
			if(validaEmBranco) validaEmBranco = verificaNum(strRenavam); 
			if(validaEmBranco) renavam = Integer.parseInt(strRenavam);
		}
		return renavam;
	}

	public static float funcValorDiaria(boolean validaEmBranco) {
		float valorDiaria = 0;
		String strValorDiaria = null;
		while(!validaEmBranco) {
			strValorDiaria = JOptionPane.showInputDialog("Digite o valor da di�ria: ");
			validaEmBranco = verifica(strValorDiaria);
			if(validaEmBranco) validaEmBranco = verificaNumFloat(strValorDiaria);
			if(validaEmBranco) valorDiaria = Float.parseFloat(strValorDiaria);
			if(valorDiaria <= 0) validaEmBranco = false; // para que n�o haja di�rias menores ou iguais a 0
		} validaEmBranco = false;
		return valorDiaria;
	}

	private static boolean verificaNumFloat(String strValorDiaria) {
		boolean resp = false;
		@SuppressWarnings("unused")
		float num = 0;
		try {
			num = Float.parseFloat(strValorDiaria);
			resp = true;
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Input inv�lido - Digite um n�mero v�lido");
		}
		return resp;
	}

	private static int funcCapTanque(boolean validaEmBranco) {
		int capTanque = 0;
		String strCapTanque = null;
		
		while(!validaEmBranco) {
			strCapTanque = JOptionPane.showInputDialog("Digite a capacidade do tanque: ");
			validaEmBranco = verifica(strCapTanque);
			if(validaEmBranco) validaEmBranco = verificaNum(strCapTanque);
			if(validaEmBranco) capTanque = Integer.parseInt(strCapTanque);
		}
		return capTanque;
	}

	public static int funcRenavam(boolean validaEmBranco) {
		int renavam = 0;
		String strRenavam = null;
		
		while(!validaEmBranco) {
			strRenavam = JOptionPane.showInputDialog("Digite o RENAVAM: ");
			validaEmBranco = verifica(strRenavam);
			if(validaEmBranco) validaEmBranco = verificaNum(strRenavam);
			if(validaEmBranco) renavam = Integer.parseInt(strRenavam);
			boolean testa = gerenciaVeic.pesquisarRenavam(renavam, 0); // Verifica se ja existe o renavam no sistema
			if(testa) {
				validaEmBranco = false;
				JOptionPane.showMessageDialog(null, "RENAVAM j� existente no sistema. Tente novamente...");
			}
		}
		return renavam;
	}

	private static int funcAnoModelo(boolean validaEmBranco) {
		String strAnoModelo = null;
		int anoModelo = 0;
		
		while(!validaEmBranco) {
			strAnoModelo = JOptionPane.showInputDialog("Digite o ano do modelo: ");
			validaEmBranco = verifica(strAnoModelo);
			if(validaEmBranco) validaEmBranco = verificaNum(strAnoModelo);
			if(validaEmBranco) anoModelo = Integer.parseInt(strAnoModelo);
		} 
		return anoModelo;
	}

	private static int funcAnoFabricacao(boolean validaEmBranco) {
		int anoFabricacao = 0;
		String strAnoFabricacao = null;
		while(!validaEmBranco) {
			strAnoFabricacao = JOptionPane.showInputDialog("Digite o ano de fabrica��o: ");
			validaEmBranco = verifica(strAnoFabricacao);
			if(validaEmBranco) validaEmBranco = verificaNum(strAnoFabricacao); // verifica se o input colocado foi de inteiros
			if(validaEmBranco) anoFabricacao = Integer.parseInt(strAnoFabricacao); // faz o cast de String para int	
		} 
		
		return anoFabricacao;
	}

	public static String funcCategoria(boolean validaEmBranco) {
		String categoria = null;
		int temp = 0;
		
		while(!validaEmBranco) {
			categoria = JOptionPane.showInputDialog("Categoria:\n[A] Compacto\n[B] Compacto de luxo\n[C] Sedan\n[D] SUV").toUpperCase();
			validaEmBranco = verifica(categoria);
			temp = valido(categoria, 4);
			if(temp == 0) validaEmBranco = false;
		} 
		
		
		
		switch(categoria) {
			case "A":
				categoria = "Compacto";
				break;
			case "B":
				categoria = "Compacto de luxo";
				break;
			case "C":
				categoria = "Sedan";
				break;
			case "D":
				categoria = "SUV";
				break;
		}
		
		return categoria;
	}

	public static String funcModelo(boolean validaEmBranco) {
		String modelo = null; 
		
		while(!validaEmBranco) {
			modelo = JOptionPane.showInputDialog("Digite o modelo: ");
			validaEmBranco = verifica(modelo);
		}
		return modelo;
	}

	public static String funcMarca(boolean validaEmBranco) {
		String marca =  null;
		while(!validaEmBranco) {
			marca = JOptionPane.showInputDialog("Digite a marca: ");
			validaEmBranco = verifica(marca); // Verifica se a vari�vel est� em branco
		}
		return marca;
	}

	private static void verificaCadastro(boolean resp) {
		if(resp == true) {
			JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso.");
		} else {
			JOptionPane.showMessageDialog(null, "Cadastro n�o foi realizado.");
		}
		
	}

	//fun��o que verifica se o input est� dentro das op��es vi�veis
	public static int valido(String strEscolha1, int tam) {
		int valida = 0;
		strEscolha1 = strEscolha1.toUpperCase();		
		if(tam == 2) {
			String a = "AB";
			if(a.contains(strEscolha1)) {
				valida = 1;
			}
		} 
		if(tam == 3) {
			String a = "ABC";
			if(a.contains(strEscolha1)) {
				valida = 1;
			}
		} 
		
		if(tam == 4) {
			String a = "ABCD";
			if(a.contains(strEscolha1)) {
				valida = 1;
			}
		}
		
		if(tam == 5) {
			String a = "ABCDE";
			if(a.contains(strEscolha1)) {
				valida = 1;
			}
		}
		
		if(tam == 6) {
			String a = "ABCDEF";
			if(a.contains(strEscolha1)) {
				valida = 1;
			}
		}
		if(tam == 7) {
			String a = "ABCDEFG";
			if(a.contains(strEscolha1)) {
				valida = 1;
			}
		}
		
		
		if(valida == 0) {
			
			JOptionPane.showMessageDialog(null, "Input inv�lido - RETORNANDO...");
			
		}
		return valida;
	}

	// Gerenciar Locat�rios
	private static void casoA(char escolhaA) {
		boolean validaEmBranco = false;
		String strEscolha = null;
		switch(escolhaA) {
			case 'A':
				JOptionPane.showMessageDialog(null, "==== Cadastrar Locat�rio ====");
				while(!validaEmBranco) {
					strEscolha = JOptionPane.showInputDialog(null, "A) Cadastro de pessoa f�sica\nB) Cadastro de pessoa jur�dica\nC) Menu principal").toUpperCase();
					validaEmBranco= verifica(strEscolha);
					int temp = valido(strEscolha, 3);
					if(temp == 0) validaEmBranco = false;
				}
				escolhaA_A(strEscolha);
				
			
				break;
			case 'B':
				JOptionPane.showMessageDialog(null, "==== Pesquisar Locat�rio ====");
				while(!validaEmBranco) {
					strEscolha = JOptionPane.showInputDialog(null, "A) Pesquisar pelo nome\nB) Pesquisar pelo nome social da empresa\nC) Pesquisar pelo CPF\nD) Pesquisar pelo CNPJ\nE) Pesquisar pelo E-MAIL\nF) Menu principal").toUpperCase();
					validaEmBranco= verifica(strEscolha);
					int temp = valido(strEscolha, 6);
					if(temp == 0) validaEmBranco = false;
				}
				escolhaA_B(strEscolha);
				break;
			case 'C':
				JOptionPane.showMessageDialog(null, "==== Editar Locat�rio ====");
				while(!validaEmBranco) {
					strEscolha = JOptionPane.showInputDialog(null, "A) Atualizar pessoa f�sica\nB) Atualizar pessoa jur�dica\nC) Menu principal").toUpperCase();
					validaEmBranco= verifica(strEscolha);
					int temp = valido(strEscolha, 3);
					if(temp == 0) validaEmBranco = false;
				}
				escolhaA_C(strEscolha);
				
				break;
			case 'D':
				JOptionPane.showMessageDialog(null, "==== Excluir Locat�rio ====");
				while(!validaEmBranco) {
					strEscolha = JOptionPane.showInputDialog(null, "A) Excluir pessoa f�sica\nB) Excluir pessoa jur�dica\nC) Menu principal").toUpperCase();
					validaEmBranco= verifica(strEscolha);
					int temp = valido(strEscolha, 3);
					if(temp == 0) validaEmBranco = false;
				}
				escolhaA_D(strEscolha);
				break;
			case 'E':
				menuPrincipal();
				break;
		}
		
	}
	
	private static void escolhaA_C(String strEscolha) {
		boolean resp = false;
		switch(strEscolha) {
			case "A":
				resp = false;
				PessoaFisica locatarioPf = new PessoaFisica();
				
				locatarioPf = funcCPF(false, locatarioPf);
				
				if(locatarioPf != null) resp = gerenciaLoc.editarPessoaFisica(locatarioPf);
				
				if(resp) {
					JOptionPane.showMessageDialog(null, "Dado do locatario atualizado com sucesso.");
				}
				
				break;
			case "B":
				resp = false;
				boolean validaEmBranco = false;
				String cnpj = null;
				PessoaJuridica locatarioPj = new PessoaJuridica();
				
				while(!validaEmBranco) {
					cnpj = JOptionPane.showInputDialog("Digite o CNPJ: ");
					validaEmBranco = verifica(cnpj);
					validaEmBranco = verificaNum(cnpj);
					if(validaEmBranco) locatarioPj = (PessoaJuridica) gerenciaLoc.pesquisarLocatario(cnpj, 1, "CNPJ",1);
				} validaEmBranco = false;
				
				if(locatarioPj != null) resp = gerenciaLoc.editarPessoaJuridica(locatarioPj);
				
				if(resp) {
					JOptionPane.showMessageDialog(null, "Dado do locatario atualizado com sucesso.");
				}
				
				
				break;
			case "C":
				menuPrincipal();
				break;
		}
		
	}

	private static PessoaFisica funcCPF(boolean validaEmBranco, PessoaFisica locatario) {
		String cpf = null;
		while(!validaEmBranco) {
			cpf = JOptionPane.showInputDialog("Digite o CPF: ");
			validaEmBranco = verifica(cpf);
			validaEmBranco = verificaNumLong(cpf);
			if(validaEmBranco) locatario = (PessoaFisica) gerenciaLoc.pesquisarLocatario(cpf, 1, "CPF", 1);
		} validaEmBranco = false;
		return locatario;
	}

	private static void escolhaA_B(String strEscolha) {
		boolean validaEmBranco = false, resp = false;
		switch(strEscolha) {
			case "A":
				String nome = null;
				while(!validaEmBranco) {
					nome = JOptionPane.showInputDialog("Digite o nome: ");
					validaEmBranco = verifica(nome);
				} validaEmBranco = false;
				
				if(gerenciaLoc.pesquisarLocatario(nome, 1, "NOME",0) != null) {
					resp = true;
				}
				
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "O Nome informado n�o foi encontrado no sistema.");
				}
				break;
			case "B":
				resp = false;
				String nomeSocial = null;
				while(!validaEmBranco) {
					nomeSocial = JOptionPane.showInputDialog("Digite o nome: ");
					validaEmBranco = verifica(nomeSocial);
				} validaEmBranco = false;
				
				if(gerenciaLoc.pesquisarLocatario(nomeSocial, 1, "NOME SOCIAL",0) != null) {
					resp = true;
				}
				
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "O Nome social da empresa n�o foi encontrado no sistema.");
				}
				break;
			case "C":
				resp = false;
				String cpf = null;
				while(!validaEmBranco) {
					cpf = JOptionPane.showInputDialog("Digite o CPF: ");
					validaEmBranco = verifica(cpf);
					validaEmBranco = verificaNumLong(cpf);
				} validaEmBranco = false;
				
				if(gerenciaLoc.pesquisarLocatario(cpf, 1, "CPF",0) != null) {
					resp = true;
				}
				
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "O CPF informado n�o foi encontrado no sistema.");
				}
				break;
			case "D":
				resp = false;
				String cnpj = null;
				
				while(!validaEmBranco) {
					cnpj = JOptionPane.showInputDialog("Digite o CNPJ: ");
					validaEmBranco = verifica(cnpj);
					validaEmBranco = verificaNumLong(cnpj);
				} validaEmBranco = false;
				
				if(gerenciaLoc.pesquisarLocatario(cnpj, 1, "CNPJ",0) != null) {
					resp = true;
				}
				
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "O CNPJ informado n�o foi encontrado no sistema.");
				}
				break;
			case "E":
				String email = null;
				while(!validaEmBranco) {
					email = JOptionPane.showInputDialog("Digite o E-MAIL: ");
					validaEmBranco = verifica(email);
				} validaEmBranco = false;
				
				if(gerenciaLoc.pesquisarLocatario(email, 1, "EMAIL",0) != null) {
					resp = true;
				}
				
				try {
					if(!resp) {
						throw new ObjetoNaoEncontradoException();
					}
				} catch(ObjetoNaoEncontradoException e) {
					JOptionPane.showMessageDialog(null, "O E-MAIL informado n�o foi encontrado no sistema.");
				}
				break;
			case "F":
				menuPrincipal();
				break;
		}
		
	}

	private static void escolhaA_D(String strEscolha) {
		boolean validaEmBranco = false, resp = false;
		int temp = 0;
		switch(strEscolha) {
			case  "A":	
				Locatario p = null;
				
				
				while(!validaEmBranco) {
					strEscolha = JOptionPane.showInputDialog(null, "A) Excluir pelo CPF\nB) Menu principal").toUpperCase();
					validaEmBranco= verifica(strEscolha);
					temp = valido(strEscolha, 2);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				
				switch(strEscolha) {
					case "A":
						String cpf = null;
						while(!validaEmBranco) {
							cpf = JOptionPane.showInputDialog("Digite o CPF: ");
							validaEmBranco = verifica(cpf);
							validaEmBranco = verificaNumLong(cpf);
							p = gerenciaLoc.pesquisarLocatario(cpf, 0, "CPF",0);
							if(p != null) {
								resp = true;
							}
						} validaEmBranco = false;
						if(resp) {
							if(!p.isLocador()) {
								gerenciaLoc.excluirLocatarioCPF(cpf, "CPF");
								JOptionPane.showMessageDialog(null, "Exlus�o concluida com sucesso.");
							} else {
								JOptionPane.showMessageDialog(null, "N�o � poss�vel fazer a exclus�o, porque a pessoa f�sica em quest�o est� locando um carro.");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Exclus�o n�o foi concluida.\nCPF n�o foi encontrado no sistema.");
						}
						break;
					case "B":
						menuPrincipal();
						break;
				}
				
				break;
			case "B":
				p = null;
				while(!validaEmBranco) {
					strEscolha = JOptionPane.showInputDialog(null, "A) Excluir pelo CNPJ\nB) Menu principal").toUpperCase();
					validaEmBranco= verifica(strEscolha);
					temp = valido(strEscolha, 2);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				
				switch(strEscolha) {
					case "A":
						String cnpj = null;
						while(!validaEmBranco) {
							cnpj = JOptionPane.showInputDialog("Digite o CNPJ: ");
							validaEmBranco = verifica(cnpj);
							validaEmBranco = verificaNumLong(cnpj);
							p = gerenciaLoc.pesquisarLocatario(cnpj, 0, "CNPJ",0);
							if(p != null) {
								resp = true;
							}
						} validaEmBranco = false;
						
						if(resp) {
							if(!p.isLocador()) {
								gerenciaLoc.excluirLocatarioCPF(cnpj, "CNPJ");
								JOptionPane.showMessageDialog(null, "Exlus�o concluida com sucesso.");
							} else {
								JOptionPane.showMessageDialog(null, "N�o � poss�vel fazer a exclus�o da pessoa jur�dica, porque ela est� locando um carro no momento.");
							}
						} else {	
							JOptionPane.showMessageDialog(null, "Exclus�o n�o foi concluida.\nCNPJ n�o foi encontrado no sistema.");
						}
						break;
					case "B":
						menuPrincipal();
						break;
				}
				break;
			case "C":
				menuPrincipal();
				break;
		}
		
		
	}

	
	private static void escolhaA_A(String strEscolha) {
		boolean validaEmBranco = false, resp = false;
		int temp = 0;
		String cpf = null, email = null, telefone = null;
		switch(strEscolha) {
			case "A":
				
				String estadoCivil = null, nome = null;
				Endereco end = null;
				
				while(!validaEmBranco) {
					nome = JOptionPane.showInputDialog("Digite o nome: ");
					validaEmBranco = verifica(nome);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					cpf = JOptionPane.showInputDialog("Digite o CPF: ");
					validaEmBranco = verifica(cpf);
					validaEmBranco = verificaNumLong(cpf);
					if(gerenciaLoc.pesquisarLocatario(cpf, 0, "CPF",0) != null) {
						validaEmBranco = false;
						JOptionPane.showMessageDialog(null, "CPF encontrado no sistema, tente novamente.");
					}
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					email = JOptionPane.showInputDialog("Digite o E-MAIL: ");
					validaEmBranco = verifica(email);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					telefone = JOptionPane.showInputDialog("Digite o telefone: ");
					validaEmBranco = verifica(telefone);
					validaEmBranco = verificaNumLong(telefone);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					 estadoCivil= JOptionPane.showInputDialog("Estado civil:\n[A] Solteiro\n[B] Casado\n[C] Separado\n[D] Divorciado\n[E] Vi�vo").toUpperCase();
					validaEmBranco = verifica(estadoCivil);
					temp = valido(estadoCivil, 5);
					if(temp == 0) validaEmBranco = false;
				} validaEmBranco = false;
				
				switch(estadoCivil) {
					case "A":
						estadoCivil = "Solteiro";
						break;
					case "B":
						estadoCivil = "Casado";
						break;
					case "C":
						estadoCivil = "Separado";
						break;
					case "D":
						estadoCivil = "Divorciado";
						break;
					case "E":
						estadoCivil = "Viuvo";
						break;
				}
				
				end = funcEndereco();
				
				PessoaFisica p = new PessoaFisica(end, email, telefone, nome, cpf, estadoCivil);
				
				//enviando o 0 para mostrar que o que vai ser cadastrado � uma pessoa f�sica.
				resp = gerenciaLoc.cadastrarLocatario(p, 0); 
				
				if(resp) {
					JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar.");
				}
				break;
			case "B":
				List<PessoaFisica> funcionarios = new LinkedList<>();
				PessoaFisica pf = new PessoaFisica();
				PessoaJuridica pessoaJuridica = null;
				String nomeSocial = null, cnpj = null;
				boolean cadastrarAutorizados = false;
				resp = false;
				
				while(!validaEmBranco) {
					nomeSocial = JOptionPane.showInputDialog("Digite o nome social da empresa: ");
					validaEmBranco = verifica(nomeSocial);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					cnpj = JOptionPane.showInputDialog("Digite o CNPJ: ");
					validaEmBranco = verifica(cnpj);
					validaEmBranco = verificaNumLong(cnpj);
					if(gerenciaLoc.pesquisarLocatario(cnpj, 0, "CNPJ",0) != null) {
						validaEmBranco = false;
						JOptionPane.showMessageDialog(null, "CNPJ encontrado no sistema, tente novamente.");
					}
				} validaEmBranco = false;
				
				temp = JOptionPane.showConfirmDialog(null, "Deseja cadastrar funcion�rios autorizados a realizar reservas?\n(Lembrando que � poss�vel cadastrar funcion�rios depois na tela de editar dados de pessoas f�sicas).", "Autoriza��o",JOptionPane.YES_NO_OPTION);	
				if(temp == 0) cadastrarAutorizados = true;
				
				while(cadastrarAutorizados) {
					while(!validaEmBranco) {
						cadastrarAutorizados = false;
						cpf = JOptionPane.showInputDialog("Digite o CPF: ");
						validaEmBranco = verifica(cpf);
						validaEmBranco = verificaNumLong(cpf);
						pf = (PessoaFisica) gerenciaLoc.pesquisarLocatario(cpf, 1, "CPF",1);
						if(pf == null) {
							if(validaEmBranco) JOptionPane.showMessageDialog(null, "CPF n�o encontrado no sistema.");
						} else {	
							if(pf != null) {
								if(pf.isJaEstaContratada()) {
									if(funcionarios.contains(pf)) {
										JOptionPane.showMessageDialog(null, "Funcion�rio j� est� cadastrado nessa empresa.");
									} else {
										JOptionPane.showMessageDialog(null, "Funcion�rio j� est� cadastrado em outra empresa.");
									}
								} else {
									funcionarios.add(pf);
									JOptionPane.showMessageDialog(null, "Funcion�rio foi cadastrado com sucesso.");
									pf.setJaEstaContratada(true);
								}
							}
							resp = true;
						}
					} validaEmBranco = false;
					if(resp) {
						temp = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro funcion�rio?", "Cadastro",JOptionPane.YES_NO_OPTION);
						if(temp == 0) cadastrarAutorizados = true;
					} else {
						temp = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente com um CPF existente?", "Cadastro",JOptionPane.YES_NO_OPTION);
						if(temp == 0) cadastrarAutorizados = true;
					}
				}
				
				while(!validaEmBranco) {
					email = JOptionPane.showInputDialog("Digite o E-MAIL: ");
					validaEmBranco = verifica(email);
				} validaEmBranco = false;
				
				while(!validaEmBranco) {
					telefone = JOptionPane.showInputDialog("Digite o telefone: ");
					validaEmBranco = verifica(telefone);
					validaEmBranco = verificaNumLong(telefone);
				} validaEmBranco = false;
				
				end = funcEndereco();
				
				pessoaJuridica = new PessoaJuridica(end, email, telefone, nomeSocial, cnpj, funcionarios);
				
				//enviando o 1 para mostrar que o que vai ser cadastrado � uma pessoa jur�dica.
				resp = gerenciaLoc.cadastrarLocatario(pessoaJuridica, 1); 
				
				if(resp) {
					JOptionPane.showMessageDialog(null, "Cadastro concluido com sucesso");
				} else {
					JOptionPane.showMessageDialog(null, "N�o foi poss�vel cadastrar.");
				}
				
				break;
			case "C":
				menuPrincipal();
				break;
		}
		
	}


	private static Endereco funcEndereco() {
		boolean validaEmBranco = false;
		String rua = null, complemento = null, bairro = null
					, cidade = null, estado = null, numero = null, cep = null; 
		Endereco endereco = null;
		
		
		
		while(!validaEmBranco) {
			estado = JOptionPane.showInputDialog("Digite o estado: ");
			validaEmBranco = verifica(estado);
		} validaEmBranco = false;
		
		while(!validaEmBranco) {
			cidade = JOptionPane.showInputDialog("Digite o nome da cidade: ");
			validaEmBranco = verifica(cidade);
		} validaEmBranco = false;
		
		
		while(!validaEmBranco) {
			bairro = JOptionPane.showInputDialog("Digite o nome do bairro: ");
			validaEmBranco = verifica(bairro);
		} validaEmBranco = false;
		
		while(!validaEmBranco) {
			rua = JOptionPane.showInputDialog("Digite o nome da rua: ");
			validaEmBranco = verifica(rua);
		} validaEmBranco = false;
	
		while(!validaEmBranco) {
			numero = JOptionPane.showInputDialog("Digite o numero: ");
			validaEmBranco = verifica(numero);
			validaEmBranco = verificaNum(numero);
		} validaEmBranco = false;
		
		// sem o valida em branco porque o complemento n�o � obrigat�rio
		complemento = JOptionPane.showInputDialog("Digite o complemento: ");
			
		
		while(!validaEmBranco) {
			cep = JOptionPane.showInputDialog("Digite o CEP: ");
			validaEmBranco = verifica(cep);
			validaEmBranco = verificaNumLong(cep);
		} 
		
		endereco = new Endereco(rua, complemento, bairro, cidade, estado, numero, cep);
		
		return endereco;
	}

	private static void menuPrincipal() {
		JOptionPane.showMessageDialog(null, "Retornando ao menu principal");
	}

	//fun��o que verifica se o input colocado foi de inteiros
	public static boolean verificaNum(String strInteiro) {
		boolean resp = false;
		@SuppressWarnings("unused")
		int inteiro = 0;
		try {
			inteiro = Integer.parseInt(strInteiro);
			resp = true;
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Input inv�lido - Digite um n�mero inteiro");
		}
		return resp;
	}
	
	public static boolean verificaNumLong(String strTelefone) {
		boolean resp = false;
		@SuppressWarnings("unused")
		long inteiro = 0;
		try {
			inteiro = Long.parseLong(strTelefone);
			resp = true;
		} catch(NumberFormatException e){
			JOptionPane.showMessageDialog(null, "Input inv�lido - Digite somente n�meros e sem espa�os");
		}
		return resp;
	}

	public static boolean verifica(String str) {
		boolean resposta = false;
		str = str.replaceAll("\\s+", ""); //retira os espa�os da String.
		//Para casos onde seja enviado espa�os, com isso, ser� pego na exce��o.	Exemplo: strEmail = "    ";
		
		try {
			if(str.equalsIgnoreCase("")) {
				throw new EmBrancoException();
			}
			resposta = true;
		} catch(EmBrancoException e) {
			JOptionPane.showMessageDialog(null, "Voc� respondeu em branco");
		}	
		return resposta;
	}
}