package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
//@ManagedBean
//@ViewScoped
@SessionScoped
public class ClienteBean  implements Serializable{

	private static final long serialVersionUID = 1L;

	private List<Cliente> clientes = new ArrayList<>();
	private Cliente novoCliente = new Cliente();
	private Cliente clienteSelecionadoExcluir;



	public void adicionar(){
		clientes.add(novoCliente);
		this.novoCliente = new Cliente();
		
		for (Cliente cliente : clientes) {
			System.out.println(cliente.getNome() );
		}
	}

	public void excluir(){
		this.clientes.remove(clienteSelecionadoExcluir);		
	
		FacesContext context = FacesContext.getCurrentInstance();
	
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cliente excluído com sucesso!!", "Cliente excluído com sucesso");
	
		context.addMessage("sucessoExclusao", msg);
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente getNovoCliente() {
		return novoCliente;
	}

	public void setNovoCliente(Cliente novoCliente) {
		this.novoCliente = novoCliente;
	}

	public Cliente getClienteSelecionadoExcluir() {
		return clienteSelecionadoExcluir;
	}

	public void setClienteSelecionadoExcluir(Cliente clienteSelecionadoExcluir) {
		this.clienteSelecionadoExcluir = clienteSelecionadoExcluir;
	}


	
	
}
