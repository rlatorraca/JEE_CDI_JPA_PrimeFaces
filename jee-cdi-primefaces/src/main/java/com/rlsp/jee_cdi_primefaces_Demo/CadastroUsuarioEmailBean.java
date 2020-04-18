package com.rlsp.jee_cdi_primefaces_Demo;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@javax.enterprise.context.RequestScoped
public class CadastroUsuarioEmailBean {

	private String nome;
	private String email;

	public void cadastrar() {
		String msg = "Usuário '" + nome + "' cadastrado!";
		FacesContext.getCurrentInstance().addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, msg, msg));
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
