package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;



@Named
@ManagedBean
@ViewScoped
public class ProdutosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> produtos = new ArrayList<>();
	private String nomeProduto;
	private String produtoSelecionado;

	public void incluirProduto() {
		produtos.add(nomeProduto);
		nomeProduto = null;
	}
	
	public ProdutosBean() {
		produtos.add("Arroz");
		produtos.add("Feijão");
		produtos.add("Queijo");
		produtos.add("Notebook");
	}
	
	public void excluirProduto() {
		produtos.remove(produtoSelecionado);
	}

	public List<String> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<String> produtos) {
		this.produtos = produtos;
	}

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}

	public String getProdutoSelecionado() {
		return produtoSelecionado;
	}

	public void setProdutoSelecionado(String produtoSelecionado) {
		this.produtoSelecionado = produtoSelecionado;
	}
	
	

}