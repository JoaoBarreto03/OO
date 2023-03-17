package Entrega2;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciarVeiculo {
	List<VeiculoPasseio> veiculoPasseio;
	List<Motocicleta> motos;
	List<VeiculoCarga> veiculoCarga;
	List<VeiculoPassageiro> veiculoPassageiro;

	int passeio = 0, passageiro = 0, carga = 0, utilitario = 0, motocicleta = 0;
	
	public GerenciarVeiculo() {
		
	}
	
	public void passeio() {
		veiculoPasseio = new LinkedList<>();
	}
	public void motocicleta() {
		motos = new LinkedList<>();
	}
	public void carga() {
		veiculoCarga = new LinkedList<>();
	}
	public void passageiro() {
		veiculoPassageiro = new LinkedList<>();
	}
	
	
	public boolean cadastrarVeiculo(Veiculo veiculo) {
		
		boolean resposta = false;
		switch(veiculo.getTipo()) {
			case "Passeio":
				
				if(passeio == 0) {
					this.passeio();
					passeio++;
				}
				resposta = veiculoPasseio.add((VeiculoPasseio) veiculo);
				break;
			case "Motocicleta":
				if(motocicleta == 0) {
					this.motocicleta();
					motocicleta++;
				}
						
				resposta = motos.add((Motocicleta) veiculo);
				break;
			case "Carga":
				if(carga == 0) {
					this.carga();
					carga++;
				}
						
				resposta = veiculoCarga.add((VeiculoCarga) veiculo);
				break;
			case "Passageiro":
				if(passageiro == 0) {
					this.passageiro();
					passageiro++;
				}
				
						
				resposta = veiculoPassageiro.add((VeiculoPassageiro) veiculo);
				break;
			default: 
				JOptionPane.showMessageDialog(null, "ERRO");
		}
		
		return resposta;
	}
	
	
	
	public boolean excluirVeiculo(int renavam) {
		boolean resp = false;
		Veiculo v;
		
		v = pesquisarRenavam_RetornaVeiculo(renavam, 0);
		if(v != null) resp = true;
		if(resp) {
			switch(v.getTipo()) {
				case "Passeio":
					veiculoPasseio.remove(v);	
					break;
				case "Motocicleta":
					motos.remove(v);
					break;
				case "Carga":
					veiculoCarga.remove(v);
					break;
				case "Passageiro":
					veiculoPassageiro.remove(v);
					break;
					
			}
		} 
		
		return resp;
	}	
	
	public void strPasseio(VeiculoPasseio p, int qtd) {
		JOptionPane.showMessageDialog(null, qtd+":\nVe�culo do tipo: "+p.getTipo()+"\nRENAVAM: "+p.getRenavam()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nCategoria: "+p.getCategoria()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nAr-condicionado: "+p.isArCondicionado()+"\nDire��o hidr�ulica: "+p.isDirHidraulica()+"\nAutom�tico: "+p.isAutomatico()+"\nLocado: "+p.isReservado());
	}
	
	public void strMoto(Motocicleta p, int qtd) {
		JOptionPane.showMessageDialog(null, qtd+":\nVe�culo do tipo: "+p.getTipo()+"\nRENAVAM: "+p.getRenavam()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nModo de pilotagem: "+p.getModoConducao()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nControle de tra��o: "+p.isControleTracao()+"\nFreios ABS: "+p.isFreioAbs()+"\nPiloto autom�tico: "+p.isPilotoAut()+"\nLocado: "+p.isReservado());
	}
	
	public void strCarga(VeiculoCarga p, int qtd) {
		JOptionPane.showMessageDialog(null, qtd+":\nVe�culo do tipo: "+p.getTipo()+"\nRENAVAM: "+p.getRenavam()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nCapacidade de Carga: "+p.getCapacidadeCarga()+" KG"+ "\nTipo de carga: "+p.getTipoCarga()+"\nTamanho do compartimento: "+p.getCapTanque()+" Litros\nTara: "+p.getTara()+" KG"+"\nLocado: "+p.isReservado());
	}
	
	public void strPassageiro(VeiculoPassageiro p, int qtd) {
		JOptionPane.showMessageDialog(null, qtd+":\nVe�culo do tipo: "+p.getTipo()+"\nRENAVAM: "+p.getRenavam()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nCapacidade de passageiros: "+p.getCapacidadePassageiros()+"\nCapacidade de carga: "+p.getCapacidadeCarga()+" KG\nAr-condicionado: "+p.isArCondicionado()+"\nDire��o hidr�ulica: "+p.isDirHidraulica()+"\nTV a bordo: "+p.isTelevisao()+"\nLocado: "+p.isReservado());
	}
	public boolean pesquisarRenavam(int renavam, int teste) {
		boolean resp = false;
	
		if(veiculoPasseio != null && resp == false) {
			for(VeiculoPasseio p : veiculoPasseio) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nCategoria: "+p.getCategoria()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nAr-condicionado: "+p.isArCondicionado()+"\nDire��o hidr�ulica: "+p.isDirHidraulica()+"\nAutom�tico: "+p.isAutomatico()+"\nLocado: "+p.isReservado());
					resp = true;
				}
					
			}
		} 

				
		if(motos != null && resp == false) {
			for(Motocicleta p : motos) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nModo de pilotagem: "+p.getModoConducao()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nControle de tra��o: "+p.isControleTracao()+"\nFreios ABS: "+p.isFreioAbs()+"\nPiloto autom�tico: "+p.isPilotoAut()+"\nLocado: "+p.isReservado());
					resp = true;
				} 
			}
		} 

			
		if(veiculoCarga != null && resp == false) {
			for(VeiculoCarga p : veiculoCarga) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nCapacidade de Carga: "+p.getCapacidadeCarga()+" KG\nTipo de carga: "+p.getTipoCarga()+"\nTamanho do compartimento: "+p.getCapTanque()+" Litros\nTara: "+p.getTara()+" KG"+"\nLocado: "+p.isReservado());
					resp = true;
				}
			}
		} 		
			
		if(veiculoPassageiro != null && resp == false) {
			for(VeiculoPassageiro p : veiculoPassageiro) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nCapacidade de passageiros: "+p.getCapacidadePassageiros()+"\nCapacidade de carga: "+p.getCapacidadeCarga()+" KG\nAr-condicionado: "+p.isArCondicionado()+"\nDire��o hidr�ulica: "+p.isDirHidraulica()+"\nTV a bordo: "+p.isTelevisao()+"\nLocado: "+p.isReservado());
					resp = true;
				} 
			}
		} 
		
		if(teste != 0) {
			try {
				if(!resp) {
					throw new ObjetoNaoEncontradoException();
				}
			} catch(ObjetoNaoEncontradoException e) {
				JOptionPane.showMessageDialog(null, "Renavam n�o encontrado no sistema");
			}
		}
		
		return resp;
	}	
	
	public Veiculo pesquisarRenavam_RetornaVeiculo(int renavam, int teste) {
		Veiculo v = null;
		boolean resp = false;
		
		if(veiculoPasseio != null && resp == false) {
			for(VeiculoPasseio p : veiculoPasseio) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nCategoria: "+p.getCategoria()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nAr-condicionado: "+p.isArCondicionado()+"\nDire��o hidr�ulica: "+p.isDirHidraulica()+"\nAutom�tico: "+p.isAutomatico()+"\nLocado: "+p.isReservado());
					v = p;
					resp = true;
				}
					
			}
		} 
				
		if(motos != null && resp == false) {
			for(Motocicleta p : motos) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nModo de pilotagem: "+p.getModoConducao()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nControle de tra��o: "+p.isControleTracao()+"\nFreios ABS: "+p.isFreioAbs()+"\nPiloto autom�tico: "+p.isPilotoAut()+"\nLocado: "+p.isReservado());
					v = p;
					resp = true;
				} 
			}
		} 

			
		if(veiculoCarga != null && resp == false) {
			for(VeiculoCarga p : veiculoCarga) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nCapacidade de Carga: "+p.getCapacidadeCarga()+" KG\nTipo de carga: "+p.getTipoCarga()+"\nTamanho do compartimento: "+p.getCapTanque()+" Litros\nTara: "+p.getTara()+" KG"+"\nLocado: "+p.isReservado());
					v = p;
					resp = true;
				}
			}
		} 		
			
		if(veiculoPassageiro != null && resp == false) {
			for(VeiculoPassageiro p : veiculoPassageiro) {
				if(p.getRenavam() == renavam) {
					if(teste != 0) JOptionPane.showMessageDialog(null, "RENAVAM encontrado no sistema.\nVe�culo do tipo: "+p.getTipo()+"\nMarca: "+p.getMarca().toUpperCase()+"\nModelo: "+p.getModelo().toUpperCase()+"\nValor di�ria: R$ "+p.getValorDiaria()+"\nCapacidade de passageiros: "+p.getCapacidadePassageiros()+"\nCapacidade de carga: "+p.getCapacidadeCarga()+" KG\nAr-condicionado: "+p.isArCondicionado()+"\nDire��o hidr�ulica: "+p.isDirHidraulica()+"\nTV a bordo: "+p.isTelevisao()+"\nLocado: "+p.isReservado());
					v = p;
					resp = true;
				} 
			}
		} 
		
		if(teste != 0) {
			try {
				if(!resp) {
					throw new ObjetoNaoEncontradoException();
				}
			} catch(ObjetoNaoEncontradoException e) {
				JOptionPane.showMessageDialog(null, "Renavam n�o encontrado no sistema");
			}
		}
		
		
		return v;
		
	}	
	public boolean pesquisarMarca(String marca) {
		int qtd = 1; 
		boolean resp = false;
		JOptionPane.showMessageDialog(null, "MARCA:"+marca);
		
		if(veiculoPasseio != null) {
			for(VeiculoPasseio v : veiculoPasseio) {
				if(v.getMarca().equalsIgnoreCase(marca)) {
					resp = true;
					strPasseio(v, qtd);
					qtd++;
				}
			}
		}
		if(motos != null) {
			for(Motocicleta v : motos) {
				if(v.getMarca().equalsIgnoreCase(marca)) {
					resp = true;
					strMoto(v, qtd);
					qtd++;
				}
			}
		}
		if(veiculoCarga != null) {
			for(VeiculoCarga v : veiculoCarga) {
				if(v.getMarca().equalsIgnoreCase(marca)) {
					resp = true;
					strCarga(v, qtd);
					qtd++;
				}
			}
		}
		if(veiculoPassageiro != null) {
			for(VeiculoPassageiro v : veiculoPassageiro) {
				if(v.getMarca().equalsIgnoreCase(marca)) {
					resp = true;
					strPassageiro(v, qtd);
					qtd++;
				}
			}
		}
		return resp;
	}	
	
	public boolean pesquisarModelo(String modelo) {
		int qtd = 1; 
		boolean resp = false;
		JOptionPane.showMessageDialog(null, "Modelo: "+modelo);
		
		if(veiculoPasseio != null) {
			for(VeiculoPasseio v : veiculoPasseio) {
				if(v.getModelo().equalsIgnoreCase(modelo)) {
					resp = true;
					strPasseio(v, qtd);
					qtd++;
				}
			}
		}
		if(motos != null) {
			for(Motocicleta v : motos) {
				if(v.getModelo().equalsIgnoreCase(modelo)) {
					resp = true;
					strMoto(v, qtd);
					qtd++;
				}
			}
		}
		if(veiculoCarga != null) {
			for(VeiculoCarga v : veiculoCarga) {
				if(v.getModelo().equalsIgnoreCase(modelo)) {
					resp = true;
					strCarga(v, qtd);
					qtd++;
				}
			}
		}
		if(veiculoPassageiro != null) {
			for(VeiculoPassageiro v : veiculoPassageiro) {
				if(v.getModelo().equalsIgnoreCase(modelo)) {
					resp = true;
					strPassageiro(v, qtd);
					qtd++;
				}
			}
		}
		
		return resp;
	}		
	
	public boolean pesquisarCategoria(String categoria) {
		int qtd = 1; 
		boolean resp = false;
		JOptionPane.showMessageDialog(null, "Categoria: "+categoria);
		
		if(veiculoPasseio != null) {
			for(VeiculoPasseio v : veiculoPasseio) {
				if(v.getCategoria().equalsIgnoreCase(categoria)) {
					resp = true;
					strPasseio(v,qtd);
					qtd++;
				}
			}
		}
		
		return resp;
	}	
	
	public boolean pesquisarTipo(String tipo) {
		int qtd = 1; 
		boolean resp = false;
		JOptionPane.showMessageDialog(null, "Tipo: "+tipo);
		
		switch(tipo) {
			case "Passeio":
				if(veiculoPasseio != null) {
					for(VeiculoPasseio v : veiculoPasseio) {
						resp = true;
						strPasseio(v, qtd);
						qtd++;
					}
				} else {
					JOptionPane.showMessageDialog(null, "N�o h� ve�culos do tipo passeio cadastrados.");
				}
				break;
			case "Motocicleta":
				if(motos != null) {
					for(Motocicleta v : motos) {
						resp = true;
						strMoto(v, qtd);
						qtd++;
					}
				} else {
					JOptionPane.showMessageDialog(null, "N�o h� ve�culos do tipo motocicleta cadastrados.");
				}
				break;
			case "Carga":
				if(veiculoCarga != null) {
					for(VeiculoCarga v : veiculoCarga) {
						resp = true;
						strCarga(v, qtd);
						qtd++;
					}
				} else {
					JOptionPane.showMessageDialog(null, "N�o h� ve�culos do tipo carga cadastrados.");
				}
				break;
			case "Passageiro":
				if(veiculoPassageiro != null) {
					for(VeiculoPassageiro v : veiculoPassageiro) {
						resp = true;
						strPassageiro(v, qtd);
						qtd++;
					}
				} else {
					JOptionPane.showMessageDialog(null, "N�o h� ve�culos do tipo passageiro cadastrados.");
				}
				break;
		}
		
		return resp;
	}	
	
	public boolean atualizarDados(int renavam) {
	
		boolean resp = false, validaEmBranco = false, novamente = true;
		Veiculo v;
		String escolha = null;
		int temp = 0;
		
		
		v = pesquisarRenavam_RetornaVeiculo(renavam, 0);
		if(v != null) resp = true;
		if(resp) {
			while(novamente) {
				switch(v.getTipo()) {
				case "Passeio":
					VeiculoPasseio p;
					p = (VeiculoPasseio) v;
					while(!validaEmBranco) {
						escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Marca\n[B] Modelo\n[C] Categoria\n[D] Valor di�ria\n[E] Outros").toUpperCase();
						validaEmBranco = Main.verifica(escolha); 
						temp = Main.valido(escolha, 5);
						if(temp == 0) validaEmBranco = false;
					} validaEmBranco = false;
					
					switch(escolha) {
						case "A":
							String marca = null; 
							marca = Main.funcMarca(false);
							v.setMarca(marca);
							break;
						case "B":
							String modelo = null; 
							modelo = Main.funcModelo(false);
							v.setModelo(modelo);
							break;
						case "C":
							String categoria = null; 
							categoria = Main.funcCategoria(validaEmBranco);
							p.setCategoria(categoria);
							break;
							
						case "D":
							float valorDiaria = 0; 
							valorDiaria = Main.funcValorDiaria(false);
							v.setValorDiaria(valorDiaria);
							v.precoDiarias(); // altera o valor das di�rias ( reduzida, empresarial e mensal), de acordo com o novo valor da di�ria.
							break;
						case "E":
							while(!validaEmBranco) {
								escolha = JOptionPane.showInputDialog("Outros:\n[A] Ar-condicionado\n[B] Dire��o hidr�ulica\n[C] Autom�tico").toUpperCase();
								validaEmBranco = Main.verifica(escolha); 
								temp = Main.valido(escolha, 3);
								if(temp == 0) validaEmBranco = false;
							} validaEmBranco = false;
							
							switch(escolha) {
								case "A":
									boolean arCondicionado = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue ar condicionado?", "Ar Condicionado",JOptionPane.YES_NO_OPTION);
									if(temp == 0) arCondicionado = true;
									p.setArCondicionado(arCondicionado);
									break;
								case "B":
									boolean dirHidraulica = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue dire��o hidr�ulica?", "Dire��o Hidr�ulica",JOptionPane.YES_NO_OPTION);	
									if(temp == 0) dirHidraulica = true;
									p.setDirHidraulica(dirHidraulica);
									break;
								case "C":
									boolean automatico = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo � autom�tico?", "Autom�tico",JOptionPane.YES_NO_OPTION);	
									if(temp == 0) automatico = true;
									p.setAutomatico(automatico);
									break;
							}
							break;
					}
					break;
				case "Motocicleta":
					Motocicleta m;
					m = (Motocicleta) v;
					while(!validaEmBranco) {
						escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Marca\n[B] Modelo\n[C] Modo de pilotagem\n[D] Valor di�ria\n[E] Outros").toUpperCase();
						validaEmBranco = Main.verifica(escolha); 
						temp = Main.valido(escolha, 5);
						if(temp == 0) validaEmBranco = false;
					} validaEmBranco = false;
					
					switch(escolha) {
						case "A":
							String marca = null; 
							marca = Main.funcMarca(false);
							v.setMarca(marca);
							break;
						case "B":
							String modelo = null; 
							modelo = Main.funcModelo(false);
							v.setModelo(modelo);
							break;
						case "C":
							
							String modoConducao = null;
							
							while(!validaEmBranco) {
								modoConducao = JOptionPane.showInputDialog("Modo de pilotagem:\n[A] Cidade\n[B] Estrada\n[C] Sport\n[D] Off-Road").toUpperCase();
								validaEmBranco = Main.verifica(modoConducao); 
								temp = Main.valido(modoConducao, 4);
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
							m.setModoConducao(modoConducao);
							break;
							
						case "D":
							float valorDiaria = 0; 
							valorDiaria = Main.funcValorDiaria(false);
							v.setValorDiaria(valorDiaria);
							v.precoDiarias();
							break;
						case "E":
							while(!validaEmBranco) {
								escolha = JOptionPane.showInputDialog("Outros:\n[A] Controle de tra��o\n[B] Freio ABS\n[C] Piloto autom�tico").toUpperCase();
								validaEmBranco = Main.verifica(escolha); 
								temp = Main.valido(escolha, 3);
								if(temp == 0) validaEmBranco = false;
							} validaEmBranco = false;
							
							switch(escolha) {
								case "A":
									boolean controleTracao = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue controle de tra��o?", "Controle tra��o",JOptionPane.YES_NO_OPTION);
									if(temp == 0) controleTracao = true;
									m.setControleTracao(controleTracao);
									break;
								case "B":
									boolean freioAbs = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue freio ABS?", "Freio",JOptionPane.YES_NO_OPTION);	
									if(temp == 0) freioAbs = true;
									m.setFreioAbs(freioAbs);
									break;
								case "C":
									boolean pilotoAutomatico = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue piloto autom�tico?", "Piloto autom�tico",JOptionPane.YES_NO_OPTION);	
									if(temp == 0) pilotoAutomatico = true;
									m.setPilotoAut(pilotoAutomatico);
									break;
							}
							break;
					}
					break;
				case "Carga":
					VeiculoCarga vc;
					vc = (VeiculoCarga) v;
					while(!validaEmBranco) {
						escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Marca\n[B] Modelo\n[C] Tara\n[D] Valor di�ria\n[E] Tipo carga").toUpperCase();
						validaEmBranco = Main.verifica(escolha); 
						temp = Main.valido(escolha, 5);
						if(temp == 0) validaEmBranco = false;
					} validaEmBranco = false;
					
					switch(escolha) {
						case "A":
							String marca = null; 
							marca = Main.funcMarca(false);
							v.setMarca(marca);
							break;
						case "B":
							String modelo = null; 
							modelo = Main.funcModelo(false);
							v.setModelo(modelo);
							break;
						case "C":
							String strTara = null;
							int tara = 0;
							while(!validaEmBranco) {
								strTara = JOptionPane.showInputDialog("Digite a tara do ve�culo (seu peso quando est� vazio): ");
								validaEmBranco = Main.verifica(strTara);
								if(validaEmBranco) validaEmBranco = Main.verificaNum(strTara);
								if(validaEmBranco) tara = Integer.parseInt(strTara);
							} validaEmBranco = false;	
							vc.setTara(tara);
							break;
							
						case "D":
							float valorDiaria = 0; 
							valorDiaria = Main.funcValorDiaria(false);
							v.setValorDiaria(valorDiaria);
							v.precoDiarias();
							break;
						case "E":
							String tipoCarga = null;
							
							while(!validaEmBranco) {
								tipoCarga = JOptionPane.showInputDialog("Tipo de compartimento:\n[A] Ba� (carga-fechada)\n[B] Graneleiro (carga-aberta)\n[C] Basculante (carga aberta com capacidade de descarreg�-la)").toUpperCase();
								validaEmBranco = Main.verifica(tipoCarga); 
								temp = Main.valido(tipoCarga, 3);
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
							
							vc.setTipoCarga(tipoCarga);
							break;
					}
					break;
				case "Passageiro":
					VeiculoPassageiro vp;
					vp = (VeiculoPassageiro) v;
					while(!validaEmBranco) {
						escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Marca\n[B] Modelo\n[C] Quantidade de passageiros\n[D] Valor di�ria\n[E] Outros").toUpperCase();
						validaEmBranco = Main.verifica(escolha); 
						temp = Main.valido(escolha, 5);
						if(temp == 0) validaEmBranco = false;
					} validaEmBranco = false;
					switch(escolha) {
						case "A":
							String marca = null; 
							marca = Main.funcMarca(false);
							v.setMarca(marca);
							break;
						case "B":
							String modelo = null; 
							modelo = Main.funcModelo(false);
							v.setModelo(modelo);
							break;
						case "C":
							String strCapacidadePassageiros = null;
							int capacidadePassageiros = 0;
							while(!validaEmBranco) {
								strCapacidadePassageiros = JOptionPane.showInputDialog("Digite a capacidade de passageiros contando com o motorista: ");
								validaEmBranco = Main.verifica(strCapacidadePassageiros);
								if(validaEmBranco) validaEmBranco = Main.verificaNum(strCapacidadePassageiros);
								if(validaEmBranco) capacidadePassageiros = Integer.parseInt(strCapacidadePassageiros);
							} validaEmBranco = false;
							vp.setCapacidadePassageiros(capacidadePassageiros);
							break;
						case "D":
							float valorDiaria = 0; 
							valorDiaria = Main.funcValorDiaria(false);
							v.setValorDiaria(valorDiaria);
							v.precoDiarias();
							break;
						case "E":
							while(!validaEmBranco) {
								escolha = JOptionPane.showInputDialog("Outros:\n[A] Ar-condicionado\n[B] Dire��o hidr�ulica\n[C] Tv a bordo").toUpperCase();
								validaEmBranco = Main.verifica(escolha); 
								temp = Main.valido(escolha, 3);
								if(temp == 0) validaEmBranco = false;
							} validaEmBranco = false;
							
							switch(escolha) {
								case "A":
									boolean arCondicionado = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue ar condicionado?", "Ar Condicionado",JOptionPane.YES_NO_OPTION);
									if(temp == 0) arCondicionado = true;
									vp.setArCondicionado(arCondicionado);
									break;
								case "B":
									boolean dirHidraulica = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue dire��o hidr�ulica?", "Dire��o Hidr�ulica",JOptionPane.YES_NO_OPTION);	
									if(temp == 0) dirHidraulica = true;
									vp.setDirHidraulica(dirHidraulica);
									break;
								case "C":
									boolean tv = false;
									
									temp = JOptionPane.showConfirmDialog(null, "O ve�culo possue TV a bordo	?", "Autom�tico",JOptionPane.YES_NO_OPTION);	
									if(temp == 0) tv = true;
									vp.setTelevisao(tv);
									break;
							}
						
					}
				}
				temp = JOptionPane.showConfirmDialog(null, "Deseja atualizar outro dado?", "Autoriza��o",JOptionPane.YES_NO_OPTION);	
				if(temp == 1) novamente = false;
			}
		} 
		
		return resp;
	
	}	
	
}