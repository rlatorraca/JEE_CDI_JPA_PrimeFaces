package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@SessionScoped
public class CadastroUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String login;
	private String nome;

	public void verificarDisponibilidadeLogin() {
		FacesMessage msg = null;
		System.out.println("Verificando disponibilidade: " + this.login);
		
		//simula a demora no processamento
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e ) {
			e.getStackTrace();
		}
		
		
		if ("joao".equalsIgnoreCase(this.login)) {
			System.out.println("Eh JOAO");
			//msg = new FacesMessage("Login já está em uso.");
			//msg.setSeverity(FacesMessage.SEVERITY_WARN);
			FacesContext.getCurrentInstance().addMessage("frm", new FacesMessage(FacesMessage.SEVERITY_WARN,"Login esta em uso.",null));
		} else {
			System.out.println("Else JOAO");
			//msg = new FacesMessage("Login disponível.");
			FacesContext.getCurrentInstance().addMessage("frm", new FacesMessage("Login disponível."));
		}
		
		//FacesContext.getCurrentInstance().addMessage("frm", new FacesMessage("Login disponível."));
	}
	
	public void cadastrar() {
		
		//simula a demora no processamento
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e ) {
			e.getStackTrace();
		}
		
		System.out.println("Login: " + this.login);
		System.out.println("Nome: " + this.nome);
		
		FacesContext.getCurrentInstance().addMessage("frm", new FacesMessage("Cadastro efetuado!"));
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
