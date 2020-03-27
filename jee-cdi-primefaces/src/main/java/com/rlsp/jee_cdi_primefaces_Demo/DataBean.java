package com.rlsp.jee_cdi_primefaces_Demo;

import java.io.Serializable;
import java.util.Date;

import javax.annotation.ManagedBean;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ManagedBean
@ViewScoped
public class DataBean implements Serializable {

	private static final long serialVersionUID = 1L;

	public Date getDataAtual() {
		return new Date();
	}

}
