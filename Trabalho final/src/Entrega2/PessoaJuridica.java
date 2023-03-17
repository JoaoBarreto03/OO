package Entrega2;

import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;

public class PessoaJuridica extends Locatario{
	
	private String nomeSocial, cnpj;
	private List<PessoaFisica> funcionarios =  new LinkedList<>();
	
	
	public PessoaJuridica() {
		
	}

	public PessoaJuridica(Endereco endereco, String email, String telefone, String nomeSocial, String cnpj, List<PessoaFisica> funcionarios) {
		super(endereco, email, telefone);
		this.nomeSocial = nomeSocial;
		this.cnpj = cnpj;
		this.funcionarios = funcionarios;
	}

	public boolean cadastrarAutorizados(String cpf) {
		boolean resp = false;
		PessoaFisica p = null;
		
		p = (PessoaFisica) Main.gerenciaLoc.pesquisarLocatario(cpf, 1, "CPF",1);
		
		if(p != null) {
			resp = true;
			if(p.isJaEstaContratada()) {
				if(funcionarios.contains(p)) {
					JOptionPane.showMessageDialog(null, "Funcion�rio j� est� cadastrado nessa empresa.");
				} else {
					JOptionPane.showMessageDialog(null, "Funcion�rio j� est� cadastrado em outra empresa.");
				}
			} else {
				funcionarios.add(p);
				p.setJaEstaContratada(true);
				JOptionPane.showMessageDialog(null, "Funcion�rio foi cadastrado com sucesso.");
			}
		}
		
		return resp;
	}
	
	public boolean verificaAutorizacao(PessoaFisica p) {	
		boolean resp = false;
		if(funcionarios.contains(p)) {
			resp = true;
		}		
		return resp;
	}

	public String getNomeSocial() {
		return nomeSocial;
	}


	public void setNomeSocial(String nomeSocial) {
		this.nomeSocial = nomeSocial;
	}


	public String getCnpj() {
		return cnpj;
	}


	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}


	public List<PessoaFisica> getFuncionarios() {
		return funcionarios;
	}


	public void setFuncionarios(List<PessoaFisica> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
}