package com.rlsp.jee_cdi_primefaces_Demo.controller;


import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rlsp.jee_cdi_primefaces_Demo.service.Mensageiro;
import com.rlsp.jee_cdi_primefaces_Demo.service.Urgente;


@Named
@RequestScoped
public class EnvioMensagemBean {

	/**
	 * Para Pode usar @Urgente deve ser feito EXPRESSAMENTE
	 * Se existir APENAS o @Inject sera chamado o qualificado @Default
	 */
	@Inject @Urgente //@Default
	private Mensageiro mensageiro;
	
	private String texto;
	
	public void enviarMensagem() {
		mensageiro.enviarMensagem(texto);
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
