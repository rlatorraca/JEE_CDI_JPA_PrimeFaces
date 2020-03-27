package com.rlsp.jee_cdi_primefaces_Demo;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;


@Named
@RequestScoped
public class MessageBean {

	public void adicionarMensagemErro() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, 
				"Resumo da mensagem de erro", "Mensagem de erro completa");
		
		context.addMessage("destinoErro", msg);
	}
	
	public void adicionarAvisoFlutuante() {
		FacesContext context = FacesContext.getCurrentInstance();
		
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, 
				"Resumo do aviso flutuante", "Aviso flutuante completo");
		
		context.addMessage("destinoAviso", msg);
	}
	
}