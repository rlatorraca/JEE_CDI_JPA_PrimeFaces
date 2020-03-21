package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ConversationScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final List<Interesse> INTERESSES = new ArrayList<>();
	
	static {
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
	}

	private String login;
	private String senha;
	private String nome;
	private String sobre;
	private String profissao;
	private Interesse interesse;
	
	private Date dataNascimento;
	
	public void atualizarInteresse() {
		System.out.println("Profissão: " + this.profissao);
		System.out.println("Interesse: " + this.interesse.getDescricao());
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}

	public void atualizarDataNascimento() {
		System.out.println("Data nascimento: " + this.dataNascimento);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	public Date getDataHoje() {
		return new Date();
	}

	public void atualizar() {
		System.out.println("Senha: " + this.senha);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	public void atualizarSobre() {
		System.out.println("Sobre: " + this.sobre);

		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}	
	
	public void atualizarProfissao() {
		System.out.println("Profissão: " + this.profissao);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	public List<String> completarTexto(String consulta) {
		List<String> resultados = new ArrayList<String>();
		
		if (consulta.startsWith("Desenv")) {
			resultados.add("Desenvolvoder");
			resultados.add("Desenvolvoder C");
			resultados.add("Desenvolvoder C++");
			resultados.add("Desenvolvoder JAVA");
			resultados.add("Desenvolvoder PHP");			
		}
		
		if (consulta.startsWith("Cons")) {
			resultados.add("Consultor");
			resultados.add("Consultor CCNA");
			resultados.add("Consultor SAP");
						
		}
		
		return resultados;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public Interesse getInteresse() {
		return interesse;
	}

	public void setInteresse(Interesse interesse) {
		this.interesse = interesse;
	}

	public List<Interesse> getInteresses() {
		return INTERESSES;
	}
	
	

}
