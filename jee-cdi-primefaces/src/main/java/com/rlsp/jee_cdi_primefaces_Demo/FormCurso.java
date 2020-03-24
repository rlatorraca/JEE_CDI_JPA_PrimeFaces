package com.rlsp.jee_cdi_primefaces_Demo;

public class FormCurso {

	 private Integer codigo;
	   private String nome;

	   public FormCurso(Integer cod, String nome){
	       this.codigo = cod;
	       this.nome = nome;
	   }

	    public Integer getCodigo() {
	        return codigo;
	    }

	    public void setCodigo(Integer codigo) {
	        this.codigo = codigo;
	    }

	    public String getNome() {
	        return nome;
	    }

	    public void setNome(String nome) {
	        this.nome = nome;
	    }
}
