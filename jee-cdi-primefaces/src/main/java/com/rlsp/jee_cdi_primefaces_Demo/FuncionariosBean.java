package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ManagedBean
@ViewScoped
public class FuncionariosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String[] nomes = { "João", "Maria", "José", "Eduardo", "Sebastião", "Mariana", "Francisco", "Márcio", "Marta", "Cristina","Fábio", "Fabrícia", "Ana",
		"Manoel", "Fernanda", "Gabriela", "Mário", "Marcos", "Rodrigo", "Mateus", "Gabriel", "Jonas", "Timóteo", "Júlia", "Patrícia", "Josimar", "Lúcia", "Leda", "Norma",
		"Cristiano", "Higidio", "Igor", "Vanessa", "Samara", "Cilbene", "Mirtes", "Beatrice", "Kathrina", "Ivan", "Matias", "César", "Marcello", "Ronaldo", "Lícidio"};
	
	private static final String[] sobrenomes = { "Souza", "Pires", "Nazareo", "Cuiabano", "dos Santo", "Silva", "da Silva", "Andrade", "Machado", "Júnior", "Albuquerque",
		"Alencar", "Assis", "Batista", "Camargo", "Coelho", "Costa", "Dias", "Rosa", "Leal", "Lima", "Leite", "Bonnaventura", "Arsenault", "Zyang", "Hiroshi", "Machida", "Ribeiro",
		"Batista", "Albuquerque", "Barcelos", "Harris", "Dickinson", "Gears", "Murray", "McBrain", "McDonalds", "Burns"};
	
	private List<Funcionario> funcionarios;

	public FuncionariosBean() throws ParseException {
		funcionarios = new ArrayList<>();
		
		for (int i = 0; i < 350; i++) {
			adicionarFuncionario();
		}
	}
	
	private void adicionarFuncionario() {
		String nomeCompleto = getNomeAleatorio() + " " + getSobrenomeAleatorio() + " " + getSobrenomeAleatorio();
		funcionarios.add(new Funcionario(getMatriculaAleatoria(), nomeCompleto, getDataAleatoria(), 
				getSalarioAleatorio()));
	}
	
	private BigDecimal getSalarioAleatorio() {
		return new BigDecimal(1000 + (Math.random() * 29000));
	}
	
	private Long getMatriculaAleatoria() {
		return (long) (Math.random() * 10000);
	}
	
	private Date getDataAleatoria() {
		long dezAnosEmMillis = 24 * 60 * 60 * 1000;
		long periodoSorteadoEmMillis = ((long) (Math.random() * 10 * 365)) * dezAnosEmMillis;
		return new Date(System.currentTimeMillis() - periodoSorteadoEmMillis);
	}
	
	private String getSobrenomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (sobrenomes.length - 1));
		return sobrenomes[posicao];
	}
	
	private String getNomeAleatorio() {
		int posicao = (int) Math.round(Math.random() * (nomes.length - 1));
		return nomes[posicao];
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
}
