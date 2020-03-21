package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class InversaoNomeBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String nomeInvertido;
	private int quantidadePalavras;
	
	public void inverter() {
		this.nomeInvertido = "";
		this.quantidadePalavras = 0;
		
		if (this.nome != null && !this.nome.isEmpty()) {
			this.quantidadePalavras = 1;
		}
		
		for (int i = this.nome.length() - 1; i >= 0; i--) {
			char letra = this.nome.charAt(i);
			this.nomeInvertido += letra;
			
			if (letra == ' ') {
				this.quantidadePalavras++;
			}
		}
		
		System.out.println("Nome invertido: " + this.nomeInvertido);
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeInvertido() {
		return nomeInvertido;
	}

	public int getQuantidadePalavras() {
		return quantidadePalavras;
	}

}
