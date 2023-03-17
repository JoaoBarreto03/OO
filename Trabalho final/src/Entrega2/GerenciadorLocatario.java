package Entrega2;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class GerenciadorLocatario {
	List<PessoaFisica> pessoasFisicas = new LinkedList<>();
	List<PessoaJuridica> pessoasJuridicas = new LinkedList<>();
	
	public GerenciadorLocatario() {
		
	}
	
	
	public boolean cadastrarLocatario(Locatario v, int escolha) {
		boolean resp = false;
		
		switch(escolha) {
			//cadastro de pessoa fisica
			case 0:
				resp = pessoasFisicas.add((PessoaFisica) v);
				break;
			//cadastro de pessoa jur�dica
			case 1:
				resp = pessoasJuridicas.add((PessoaJuridica) v);
		}
		
		return resp;
	}	
	
	public boolean excluirLocatarioCPF(String str, String tipo) {
		boolean resp = false;
		Locatario p;
		
		switch(tipo) {
			case "CPF":
				p = pesquisarLocatario(str, 1, "CPF",1);
				if(p != null) {
					pessoasFisicas.remove(p);
					resp = true;
				}
				break;
			case "CNPJ":
				p = pesquisarLocatario(str, 1, "CNPJ",1);
				if(p != null) {
					pessoasJuridicas.remove(p);
					resp = true;
				}
				break;
		}

		
		return resp;
	}	
	
	public Locatario pesquisarLocatario(String str, int num, String tipo, int num2) {
		Locatario v = null;
		boolean resp = false;
		
		switch(tipo) {
			case "CPF":
				if(pessoasFisicas != null) {
					for(PessoaFisica p : pessoasFisicas) {
						if(p.getCpf().equalsIgnoreCase(str)) {
							if(num != 0) JOptionPane.showMessageDialog(null, "CPF encontrado: "+p.getCpf()+"\nNome: "+p.getNome()+"\nEmail: "+p.getEmail()+"\nTelefone: "+p.getTelefone()+"\nEstado: "+p.getEndereco().getEstado()+"\nCidade: "+p.getEndereco().getCidade());
							v = p;
							resp = true;
						}
					}
				}
				break;
			case "NOME":
				if(pessoasFisicas != null) {
					for(PessoaFisica p : pessoasFisicas) {
						if(p.getNome().equalsIgnoreCase(str)) {
							if(num != 0) JOptionPane.showMessageDialog(null, "Nome encontrado: "+p.getNome()+"\nCPF: "+p.getCpf()+"\nEmail: "+p.getEmail()+"\nTelefone: "+p.getTelefone()+"\nEstado: "+p.getEndereco().getEstado()+"\nCidade: "+p.getEndereco().getCidade());
							v = p;
							resp = true;
						}
					}
				}
				break;
			case "NOME SOCIAL":
				if(pessoasJuridicas != null) {
					for(PessoaJuridica p : pessoasJuridicas) {
						if(p.getNomeSocial().equalsIgnoreCase(str)) {
							if(num != 0) JOptionPane.showMessageDialog(null, "Nome social encontrado: "+p.getNomeSocial()+"\nCNPJ: "+p.getCnpj()+"\nEmail: "+p.getEmail()+"\nTelefone: "+p.getTelefone()+"\nEstado: "+p.getEndereco().getEstado()+"\nCidade: "+p.getEndereco().getCidade());
							v = p;
							resp = true;
						}
					}
				}
				break;
			case "CNPJ":
				if(pessoasJuridicas != null) {
					for(PessoaJuridica p : pessoasJuridicas) {
						if(p.getCnpj().equalsIgnoreCase(str)) {
							if(num != 0) JOptionPane.showMessageDialog(null, "CNPJ Encontrado: "+p.getCnpj()+"\nNome social: "+p.getNomeSocial()+"\nEmail: "+p.getEmail()+"\nTelefone: "+p.getTelefone()+"\nEstado: "+p.getEndereco().getEstado()+"\nCidade: "+p.getEndereco().getCidade());
							v = p;
							resp =  true;
						}
					}
				}
				break;
			case "EMAIL":
				if(pessoasFisicas != null) {
					for(PessoaFisica p : pessoasFisicas) {
						if(p.getEmail().equalsIgnoreCase(str)) {
							if(num != 0) JOptionPane.showMessageDialog(null, "E-mail encontrado: "+p.getEmail()+"\nCPF: "+p.getCpf()+"\nNome: "+p.getNome()+"\nTelefone: "+p.getTelefone());
							v = p;
							resp = true;
						}
					}
				}
				if(pessoasJuridicas != null) {
					for(PessoaJuridica p : pessoasJuridicas) {
						if(p.getEmail().equalsIgnoreCase(str)) {
							if(num != 0) JOptionPane.showMessageDialog(null, "E-mail encontrado: "+p.getEmail()+"\nCNPJ: "+p.getCnpj()+"\nNome social: "+p.getNomeSocial()+"\nTelefone: "+p.getTelefone());
							v = p;
							resp =  true;
						}
					}
				}
				break;
				
		}
		
		if(num != 0 && num2 != 0) {
			try {
				if(!resp) {
					throw new ObjetoNaoEncontradoException();
				}
			} catch(ObjetoNaoEncontradoException e) {
				JOptionPane.showMessageDialog(null, "O "+tipo+" n�o foi encontrado.");
			}
		}
		
		return v;
	}
	
	public boolean editarPessoaFisica(PessoaFisica locatario) {
		boolean resp = false, validaEmBranco = false, novamente = true;
		int temp = 0;
		
		if(locatario != null) resp = true;
		
		if(resp) {
			
				while(novamente) {
					validaEmBranco = false;
					String escolha = null;
					temp = 0;
					while(!validaEmBranco) {
						escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Nome\n[B] Telefone\n[C] E-mail\n[D] Estado civil\n[E] Endere�o").toUpperCase();
						validaEmBranco = Main.verifica(escolha); 
						temp = Main.valido(escolha, 5);
						if(temp == 0) validaEmBranco = false;
					} validaEmBranco = false;
					
					switch(escolha) {
						case "A":
							String nome = null;
							while(!validaEmBranco) {
								nome = JOptionPane.showInputDialog("Digite o novo nome: ");
								validaEmBranco = Main.verifica(nome);
							} validaEmBranco = false;
							locatario.setNome(nome);
							break;
						case "B":
							String telefone = null;
							while(!validaEmBranco) {
								telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
								validaEmBranco = Main.verifica(telefone);
								validaEmBranco = Main.verificaNumLong(telefone);
							} validaEmBranco = false;
							locatario.setTelefone(telefone);
							break;
						case "C":
							String email = null;
							while(!validaEmBranco) {
								email = JOptionPane.showInputDialog("Digite o novo E-MAIL: ");
								validaEmBranco = Main.verifica(email);
							} validaEmBranco = false;
							locatario.setEmail(email);
							break;
						case "D":
							String estadoCivil = null;
							while(!validaEmBranco) {
								 estadoCivil= JOptionPane.showInputDialog("Estado civil:\n[A] Solteiro\n[B] Casado\n[C] Separado\n[D] Divorciado\n[E] Vi�vo").toUpperCase();
								validaEmBranco = Main.verifica(estadoCivil);
								temp = Main.valido(estadoCivil, 5);
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
							locatario.setEstadoCivil(estadoCivil);
							break;
						case "E":
							while(!validaEmBranco) {
								escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar no endere�o:\n[A] Estado\n[B] Cidade\n[C] Bairro\n[D] Rua\n[E] Numero\n[F] Complemento\n[G] CEP").toUpperCase();
								validaEmBranco = Main.verifica(escolha); 
								temp = Main.valido(escolha, 7);
								if(temp == 0) validaEmBranco = false;
							} validaEmBranco = false;
							
							switch(escolha) {
								case "A":
									String estado = null;
									while(!validaEmBranco) {
										estado = JOptionPane.showInputDialog("Digite o estado: ");
										validaEmBranco = Main.verifica(estado);
									} validaEmBranco = false;
									locatario.getEndereco().setEstado(estado);
									break;
								case "B":
									String cidade = null;
									while(!validaEmBranco) {
										cidade = JOptionPane.showInputDialog("Digite o nome da cidade: ");
										validaEmBranco = Main.verifica(cidade);
									} validaEmBranco = false;
									locatario.getEndereco().setCidade(cidade);
									break;
								case "C":
									String bairro = null;
									while(!validaEmBranco) {
										bairro = JOptionPane.showInputDialog("Digite o nome do bairro: ");
										validaEmBranco = Main.verifica(bairro);
									} validaEmBranco = false;
									locatario.getEndereco().setBairro(bairro);
									break;
								case "D":
									String rua = null;
									while(!validaEmBranco) {
										rua = JOptionPane.showInputDialog("Digite o nome da rua: ");
										validaEmBranco = Main.verifica(rua);
									} validaEmBranco = false;
									locatario.getEndereco().setRua(rua);
									break;
								case "E":
									String numero = null;
									while(!validaEmBranco) {
										numero = JOptionPane.showInputDialog("Digite o numero: ");
										validaEmBranco = Main.verifica(numero);
										validaEmBranco = Main.verificaNum(numero);
									} validaEmBranco = false;
									break;
								case "F":
									String complemento = null;
									complemento = JOptionPane.showInputDialog("Digite o complemento: ");
									locatario.getEndereco().setComplemento(complemento);
									break;
								case "G":
									String cep = null;
									while(!validaEmBranco) {
										cep = JOptionPane.showInputDialog("Digite o CEP: ");
										validaEmBranco = Main.verifica(cep);
										validaEmBranco = Main.verificaNum(cep);
									} 
									locatario.getEndereco().setCep(cep);
									break;		
							}
							break;
		 			}
					temp = JOptionPane.showConfirmDialog(null, "Deseja atualizar outro dado?", "Autoriza��o",JOptionPane.YES_NO_OPTION);	
					if(temp == 1) novamente = false;
				}
		}
		
		return resp;
	}
	
	public boolean editarPessoaJuridica(PessoaJuridica locatario) {
		boolean resp = false, validaEmBranco = false, novamente = true;
		int temp = 0;
		
		if(locatario != null) resp = true;
		
		if(resp) {
			
				while(novamente) {
					validaEmBranco = false;
					String escolha = null;
					temp = 0;
					while(!validaEmBranco) {
						escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar:\n[A] Nome social\n[B] Telefone\n[C] E-mail\n[D] Endere�o\n[E] Cadastrar funcion�rios autorizados").toUpperCase();
						validaEmBranco = Main.verifica(escolha); 
						temp = Main.valido(escolha, 5);
						if(temp == 0) validaEmBranco = false;
					} validaEmBranco = false;
					
					switch(escolha) {
						case "A":
							String nome = null;
							while(!validaEmBranco) {
								nome = JOptionPane.showInputDialog("Digite o novo nome social: ");
								validaEmBranco = Main.verifica(nome);
							} validaEmBranco = false;
							locatario.setNomeSocial(nome);
							break;
						case "B":
							String telefone = null;
							while(!validaEmBranco) {
								telefone = JOptionPane.showInputDialog("Digite o novo telefone: ");
								validaEmBranco = Main.verifica(telefone);
								validaEmBranco = Main.verificaNumLong(telefone);
							} validaEmBranco = false;
							locatario.setTelefone(telefone);
							break;
						case "C":
							String email = null;
							while(!validaEmBranco) {
								email = JOptionPane.showInputDialog("Digite o novo E-MAIL: ");
								validaEmBranco = Main.verifica(email);
							} validaEmBranco = false;
							locatario.setEmail(email);
							break;
						case "D":
							while(!validaEmBranco) {
								escolha = JOptionPane.showInputDialog("O que voc� deseja atualizar no endere�o:\n[A] Estado\n[B] Cidade\n[C] Bairro\n[D] Rua\n[E] Numero\n[F] Complemento\n[G] CEP").toUpperCase();
								validaEmBranco = Main.verifica(escolha); 
								temp = Main.valido(escolha, 7);
								if(temp == 0) validaEmBranco = false;
							} validaEmBranco = false;
							
							switch(escolha) {
								case "A":
									String estado = null;
									while(!validaEmBranco) {
										estado = JOptionPane.showInputDialog("Digite o estado: ");
										validaEmBranco = Main.verifica(estado);
									} validaEmBranco = false;
									locatario.getEndereco().setEstado(estado);
									break;
								case "B":
									String cidade = null;
									while(!validaEmBranco) {
										cidade = JOptionPane.showInputDialog("Digite o nome da cidade: ");
										validaEmBranco = Main.verifica(cidade);
									} validaEmBranco = false;
									locatario.getEndereco().setCidade(cidade);
									break;
								case "C":
									String bairro = null;
									while(!validaEmBranco) {
										bairro = JOptionPane.showInputDialog("Digite o nome do bairro: ");
										validaEmBranco = Main.verifica(bairro);
									} validaEmBranco = false;
									locatario.getEndereco().setBairro(bairro);
									break;
								case "D":
									String rua = null;
									while(!validaEmBranco) {
										rua = JOptionPane.showInputDialog("Digite o nome da rua: ");
										validaEmBranco = Main.verifica(rua);
									} validaEmBranco = false;
									locatario.getEndereco().setRua(rua);
									break;
								case "E":
									String numero = null;
									while(!validaEmBranco) {
										numero = JOptionPane.showInputDialog("Digite o numero: ");
										validaEmBranco = Main.verifica(numero);
										validaEmBranco = Main.verificaNum(numero);
									} validaEmBranco = false;
									break;
								case "F":
									String complemento = null;
									complemento = JOptionPane.showInputDialog("Digite o complemento: ");
									locatario.getEndereco().setComplemento(complemento);
									break;
								case "G":
									String cep = null;
									while(!validaEmBranco) {
										cep = JOptionPane.showInputDialog("Digite o CEP: ");
										validaEmBranco = Main.verifica(cep);
										validaEmBranco = Main.verificaNum(cep);
									}
									locatario.getEndereco().setCep(cep);
									break;		
							}
							break;
						case "E":
							boolean cadastrarAutorizados = true;
							String cpf = null;
							while(cadastrarAutorizados) {
								while(!validaEmBranco) {
									cadastrarAutorizados = false;
									cpf = JOptionPane.showInputDialog("Digite o CPF: ");
									validaEmBranco = Main.verifica(cpf);
									validaEmBranco = Main.verificaNumLong(cpf);
									if(Main.gerenciaLoc.pesquisarLocatario(cpf, 0, "CPF",0) == null) {
										if(validaEmBranco) JOptionPane.showMessageDialog(null, "CPF n�o encontrado no sistema.");
									} else {
										resp = true;
									}
								} validaEmBranco = false;
								if(resp) {
									locatario.cadastrarAutorizados(cpf);
									temp = JOptionPane.showConfirmDialog(null, "Deseja cadastrar outro funcion�rio?", "Cadastro",JOptionPane.YES_NO_OPTION);
									if(temp == 0) cadastrarAutorizados = true;
								} else {
									temp = JOptionPane.showConfirmDialog(null, "Deseja tentar novamente com um CPF existente?", "Cadastro",JOptionPane.YES_NO_OPTION);
									if(temp == 0) cadastrarAutorizados = true;
								}
							}
							break;
							
		 			}
					temp = JOptionPane.showConfirmDialog(null, "Deseja atualizar outro dado?", "Autoriza��o",JOptionPane.YES_NO_OPTION);	
					if(temp == 1) novamente = false;
				}
		}
		
		return resp;
	}
	
	public void mostrarLocatario() {
		
	}
}