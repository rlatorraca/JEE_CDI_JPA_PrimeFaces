package com.rlsp.jee_cdi_primefaces_Demo.controller;

import java.text.DateFormat;
import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rlsp.jee_cdi_primefaces_Demo.service.Brasil;

/**
 * Metodos Produtores
 *  - Propicia a INJECAO de Classes que NAO sao BEANS CDI, dentro de Classes que sao BEANS CDI
 *  - Ela produzem / instanciar p:
 *  	a) Classes que nao sao BEANS 
 *  	b) Para objetos que valores podemm variar durante o tempo de vida da aplicacao
 *      c) Para objetos que precisa de INICIALIZACAO customizado (passando paramentro) 
 *
 */

@Named
@RequestScoped
public class FormatacaoBean {

	@Inject //@Brasil
	private DateFormat formatadorData;	
	
	private Date dataInformada;
	private String dataFormatada;
	
	public void enviar() {
		dataFormatada = formatadorData.format(dataInformada);
	}

	public Date getDataInformada() {
		return dataInformada;
	}

	public void setDataInformada(Date dataInformada) {
		this.dataInformada = dataInformada;
	}

	public String getDataFormatada() {
		return dataFormatada;
	}
	
}
