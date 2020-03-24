package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;

import javax.enterprise.context.ConversationScoped;
import javax.inject.Named;

@Named
@ConversationScoped
public class FormContrato implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private String razaoSocial;
    private String cnpj;
    private String cidadeContrato;
    private String modalidade;
    private String dataContrato;
    private Integer valorContrato;
    private String metodoPagamento;
    private String formaPagamento;
    private String cursoContratado;
    private String cidades;
    
    public FormContrato(String razaoSocial, String cnpj, String cidadeContrato, String modalidade,
    				String dataContrato, Integer valorContrato, String metodoPagamento, String formaPagamento,
    				String cursoContratado, String cidades) {
    	this.razaoSocial = razaoSocial;
    	this.cnpj = cnpj;
    	this.cidadeContrato = cidadeContrato;
    	this.modalidade = modalidade;
    	this.dataContrato = dataContrato;
    	this.valorContrato = valorContrato;
    	this.metodoPagamento = metodoPagamento;
    	this.formaPagamento = formaPagamento;
    	this.cursoContratado = cursoContratado;
    	this.cidades = cidades;
    	
    }

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getCidadeContrato() {
		return cidadeContrato;
	}

	public void setCidadeContrato(String cidadeContrato) {
		this.cidadeContrato = cidadeContrato;
	}

	public String getModalidade() {
		return modalidade;
	}

	public void setModalidade(String modalidade) {
		this.modalidade = modalidade;
	}

	public String getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(String dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Integer getValorContrato() {
		return valorContrato;
	}

	public void setValorContrato(Integer valorContrato) {
		this.valorContrato = valorContrato;
	}

	public String getMetodoPagamento() {
		return metodoPagamento;
	}

	public void setMetodoPagamento(String metodoPagamento) {
		this.metodoPagamento = metodoPagamento;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getCursoContratado() {
		return cursoContratado;
	}

	public void setCursoContratado(String cursoContratado) {
		this.cursoContratado = cursoContratado;
	}

	public String getCidades() {
		return cidades;
	}

	public void setCidades(String cidades) {
		this.cidades = cidades;
	}
    
}
