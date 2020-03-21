package com.rlsp.jee_cdi_primefaces_Demo;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter("interesseConversor")
public class InteresseConverter implements Converter<Object> {

	/**
	 * Chamado no momento que clickar no BOTAO (Atualizar) e sera enviado para BEAN (PerfilUsuarioBean.java)
	 */
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null) {
			for (Interesse interesse : PerfilUsuarioBean.INTERESSES) {
				if (value.equals(interesse.getNomeIcone())) {
					return interesse;
				}
			}
		}
		return null;
	}

	/**
	 * Chamado na hora de renderizar(gera o HTML) o ListBox na tela ( = itemValue) ${interesse} em PerfilUsuario4.xhtml
	 */
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value != null) {
			Interesse interesse = (Interesse) value;
			return interesse.getNomeIcone();
		}
		return null;
	}

	

}
