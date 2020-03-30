package com.rlsp.jee_cdi_primefaces_Demo.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;

/**
 * METODOS PRODUTORES
 * - Propicia a INJECAO de Classes que NAO sao BEANS CDI, dentro de Classes que sao BEANS CDI
 *  - Ela produzem / instanciar p:
 *  	a) Classes que nao sao BEANS 
 *  	b) Para objetos que valores podemm variar durante o tempo de vida da aplicacao
 *      c) Para objetos que precisa de INICIALIZACAO customizado (passando paramentro) 
 *
 *
 */
public class FormatadorData {

	/**
	 * Para @Produces ==> produz um BEAN "DateFormat"
	 *  - @Brasil é um qualificador
	 */
	@Produces @Brasil
	public DateFormat getFormatadorDataBrasil() {
		return new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("pt", "BR"));
	}
	
	@Produces @Default
	public DateFormat getFormatadorDataCanadaFrench() {
		return new SimpleDateFormat("MMMM dd, yyyy", Locale.CANADA_FRENCH);
	}
	
}