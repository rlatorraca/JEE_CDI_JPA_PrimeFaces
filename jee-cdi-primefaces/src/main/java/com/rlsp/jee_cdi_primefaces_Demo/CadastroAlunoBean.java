package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class CadastroAlunoBean implements Serializable{

	private static final long serialVersionUID = 6437555139259136240L;

	private String nome;
	private String email;
	
	public void cadastrarAluno() {
		System.out.println("Nome do Aluno : " + this.nome);
		System.out.println("E-mail do Aluno : " + this.email);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
