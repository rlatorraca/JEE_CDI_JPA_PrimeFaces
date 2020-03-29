package com.rlsp.jee_cdi_primefaces_Demo.controller;


import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.rlsp.jee_cdi_primefaces_Demo.service.CalculadoraPreco;

/**
 * ESCOPO JSF (javax.faces.*)
 * ESCOPO CDI (javax.enterprise.contex)
 *  - Padrao : @Dependent
 *  
 *  @Dependent ==> instancia e morre na mesma hora (muito curto), e ao mesmo tempo, mostra que o Bean e DEPENDENTE do Bean que o chama (INJETA o Componente)
 *  @RequestScoped ==> tempo de vida é o tempo de vida da REQUISICAO (uma requisicao HTTP)
 *  	- reiniciado a cada requisicao
 *  @SessionScoped ==> tempo de vida é o tempo de vida da SESSAO do usuario
 *  	- precisa usar "implements Serializable"
 *  @ApplicationScoped ==> tempo de vida da APLICACAO
 *  @ConversationScopped ==> para um um escopde de sessao (@SessionScoped) mas vc consegue controlar o INICIO e o FIM do tempo de vida (controle do Ciclo de vida)
 *
 *  NAO EXISTE UM @ViewScoped em CDI
 * 
 * 
 * Scope	                                        Annotation	                                              Duration
 * Request                                        @RequestScoped                     A user's interaction with a web application in a single HTTP request.
 * Session                                        @SessionScoped                     A user's interaction with a web application across multiple HTTP requests.
 *Application                                   @ApplicationScoped                  Shared state across all users' interactions with a web application.
 * Dependent                                        @Dependent               The default scope if none is specified; it means that an object exists to serve exactly one client (bean)
 *                                                                                             and has the same lifecycle as that client (bean).
 * Conversation                                   @ConversationScoped                 A user's interaction with a servlet, including JavaServer Faces applications. 
 *                                                                                   The conversation scope exists within developer-controlled boundaries that extend it across 
 *                                                                                   multiple requests for long-running conversations. All long-running conversations are scoped to 
 *                                                                                   a particular HTTP servlet session and may not cross session boundaries.
 *
 */

@Named("meuBean")
@SessionScoped

//@RequestScoped
//@Dependent
//@ManagedBean
//@ViewScoped
public class PrecoProdutoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1776577787465977402L;
	
	/**
	 * INJECT
	 * 	- Injeta um Componente / Objeto CDI (beans) dentro de outra Bean
	 *  - Nao precisa se preocupar com instanciacao das classes
	 */
	@Inject
	private CalculadoraPreco calculadora;
	
	/**
	 * Sera executado sempre que o Bean (PrecoProduoBean) for instanciado
	 * @PostConstruct ==> faz com o metodo init() rode apenas APOS a instanciacao dos objetos da classe a a INJECAO dos Componentes.
	 *  - Difernte do Constructor, pois o constructor, ainda nao tem os valores do Componentes INJETAVEIS (@INJECT)
	 *  - No constructor nao deve ser usado para calculos / processametos que exijam recurso da maquina, o ideal eh o usar o @PostConstruct
	 */
	@PostConstruct
	public void init() {
		System.out.println("init() = PrecoProdutoBean");
	}
	
	public double getPreco() {
		System.out.println(calculadora.getClass());
		return calculadora.calcularPreco(12, 100);
	}
	
}
