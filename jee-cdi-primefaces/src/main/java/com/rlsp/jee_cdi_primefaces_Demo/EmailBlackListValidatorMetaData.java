package com.rlsp.jee_cdi_primefaces_Demo;


import java.util.HashMap;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import org.primefaces.validate.ClientValidator;

@FacesValidator(EmailBlackListValidatorMetaData.VALIDATOR_ID)
public class EmailBlackListValidatorMetaData implements Validator<Object>, ClientValidator {

	public static final String VALIDATOR_ID = "com.rlsp.EmailBlacklistMetadata";

	private String dominios;
	
	@Override
	public void validate(FacesContext context, UIComponent component,
			Object value) throws ValidatorException {
		if (value == null) {
			return;
		}

		String email = value.toString();
		String[] dominios = getDominios().split(",");

		for (String dominio : dominios) {
			if (email.endsWith("@" + dominio.trim())) {
				throw new ValidatorException(new FacesMessage(
						FacesMessage.SEVERITY_ERROR, "E-mail inválido", value
								+ " está na lista negra"));
			}
		}
	}

	@Override
	public Map<String, Object> getMetadata() {
		Map<String, Object> data = new HashMap<String, Object>();
		
		if (getDominios() != null) {
			data.put("data-dominios", getDominios());
		}
		
		return data;
	}

	@Override
	public String getValidatorId() {
		return VALIDATOR_ID;
	}

	public String getDominios() {
		return dominios;
	}

	public void setDominios(String dominios) {
		this.dominios = dominios;
	}

}