package com.rlsp.conversation.scoped;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;



public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String telefone;
	
	@NotBlank @Email
	private String email;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
