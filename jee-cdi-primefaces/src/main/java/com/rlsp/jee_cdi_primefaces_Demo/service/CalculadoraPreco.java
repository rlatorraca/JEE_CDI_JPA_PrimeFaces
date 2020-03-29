package com.rlsp.jee_cdi_primefaces_Demo.service;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

@RequestScoped
public class CalculadoraPreco implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PostConstruct
	public void init() {
		System.out.println("init() = CalculadoraPreco");
	}

	public double calcularPreco(int quantidade, double precoUnitario) {
		return quantidade * precoUnitario;
	}
	
}