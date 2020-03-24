package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@ConversationScoped
//@SessionScoped
public class PerfilUsuarioBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static final List<Interesse> INTERESSES = new ArrayList<>();
	public static final List<Pais> PAISES = new ArrayList<>();
	
	private List<String> estados = new ArrayList<>();
	private List<String> cidades = new ArrayList<>();
	private List<String> interesses = new ArrayList<>();
	private List<String> paises = new ArrayList<>();
	
	
	static {
		//INTERESSES.add(new Interesse("Selecione", ""));
		INTERESSES.add(new Interesse("Esportes", "esportes"));
		INTERESSES.add(new Interesse("Computação", "computacao"));
		INTERESSES.add(new Interesse("Cinema", "cinema"));
		INTERESSES.add(new Interesse("Leitura", "leitura"));
		
		PAISES.add(new Pais(1, "Alemanha"));
        PAISES.add(new Pais(2, "Argélia"));
        PAISES.add(new Pais(3, "Argentina"));
        PAISES.add(new Pais(4, "Bélgica"));
        PAISES.add(new Pais(5, "Bolívia"));
        PAISES.add(new Pais(6, "Brasil"));
        PAISES.add(new Pais(7, "Bulgaria"));
        PAISES.add(new Pais(8, "Espanha"));
        PAISES.add(new Pais(9, "Estados Unidos"));
	
	}

	private String login;
	private String senha;
	private String nome;
	private String sobre;
	private String profissao;
	private Interesse interesse;
	private String estado;
	private String cidade;
	private String estadoCivil;
	private String sexo;
	private Date dataNascimento;
	private String pais;
	private Pais country;
	private String telefone;
	private String telefoneComercial;
	private String matricula;
	private Boolean aceito;
	
	public PerfilUsuarioBean() {
		estados.add("GO");
		estados.add("MT");
		estados.add("MS");
		estados.add("SP"); 
		paises.add("Alemanha");
        paises.add("Argélia");
        paises.add("Argentina");
        paises.add("Bélgica");
        paises.add("Bolívia");
        paises.add("Brasil");
        paises.add("Bulgaria");
        paises.add("Espanha");
        paises.add("Estados Unidos");
	}
	
	public void carregarCidades() {
		cidades.clear();

		switch (this.estado) {
			case "SP":
				cidades.add("São Paulo");
				cidades.add("Campinas");
				cidades.add("Presidente Prudente");
				cidades.add("Riberão Preto");
				cidades.add("Santos");
				break;
			case "MT":
				cidades.add("Cuiabá");
				cidades.add("Cáceres");
				cidades.add("Rondonopolis");				
				break;	
			case "MS":
				cidades.add("Campo Grande");
				cidades.add("Ponta Porã");
				cidades.add("Três Lagoas");
				break;
			case "GO":
				cidades.add("Goiania");
				cidades.add("Anápolis");
				cidades.add("Aparecida de Goiânia");			
				break;
			default:
				System.out.println("Cidades Não Cadastradas");
				break;
		}
			
	}
	
	 public void atualizarSelectBooleanCheckBox() {
	    	System.out.println("Aceito: " + this.aceito);
	    	
	    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	    }
	
	 public void atualizarInputMask() {
	    	System.out.println("Telefone: " + this.telefone);
	    	System.out.println("Telefone comercial: " + this.telefoneComercial);
	    	System.out.println("Matrícula: " + this.matricula);
	    	
	    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	    }
	
	public List<Pais> sugerirPaisesPojo(String consulta) {
        List<Pais> paisesSugeridos = new ArrayList<>();
        
        for (Pais country : PAISES) {
        	System.out.println("Pais in sugerurPaisesPOJOS: " + country.getNome());
            if (country.getNome().toLowerCase().startsWith(consulta.toLowerCase())) {
                paisesSugeridos.add(country);
            }
        }
        
        return paisesSugeridos;
	}
	
    public void atualizarPaisesPojo() {
    	System.out.println("Atualizar ==> " + getCountry().getNome());
    	if (this.country == null) {
    		adicionarMensagemPaisPojo("Perfil atualizado sem país.");
    	} else {
    		adicionarMensagemPaisPojo("Perfil atualizado com país " + this.country.getNome()
    				+ " (" + this.country.getCodigo() + ").");
    	}
    }
    
    private void adicionarMensagemPaisPojo(String msg) {
    	FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(msg));
    }
	
	public List<String> sugerirPaises(String consulta) {
		List<String> paisesSugeridos = new ArrayList<>();
		
		//this.paises ==> List<String> paises
		for (String pais : this.paises) {
			if (pais.toLowerCase().startsWith(consulta.toLowerCase())) {
				paisesSugeridos.add(pais);
			}
		}
		
		return paisesSugeridos;
	}
	
	public void atualizarPaises() {
		System.out.println("País: " + pais);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	
	public void atualizarInteresses() {
		for (String interesse : interesses) {
			System.out.println("Interesse: " + interesse);
		}
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	public void atualizarSexoEstadoCivil() {
		System.out.println("Sexo: " + this.sexo);
		System.out.println("Estado civil: " + this.estadoCivil);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
	
	public void atualizarEstadoCidade() {
		
		System.out.println("Estado: " + this.estado);
		System.out.println("Cidade: " + this.cidade);
		
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Perfil atualizado!"));
	}
	
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

	public List<String> getEstados() {
		return estados;
	}

	public void setEstados(List<String> estados) {
		this.estados = estados;
	}

	public List<String> getCidades() {
		return cidades;
	}

	public void setCidades(List<String> cidades) {
		this.cidades = cidades;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstadoCivil() {
		return estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public void setInteresses(List<String> interesses) {
		this.interesses = interesses;
	}

	
	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public List<String> getPaises() {
		return paises;
	}

	public void setPaises(List<String> paises) {
		this.paises = paises;
	}

	public Pais getCountry() {
		return country;
	}

	public void setCountry(Pais country) {
		this.country = country;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefoneComercial() {
		return telefoneComercial;
	}

	public void setTelefoneComercial(String telefoneComercial) {
		this.telefoneComercial = telefoneComercial;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Boolean getAceito() {
		return aceito;
	}

	public void setAceito(Boolean aceito) {
		this.aceito = aceito;
	}

	
	
}
