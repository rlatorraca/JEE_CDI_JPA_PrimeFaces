package com.rlsp.jee_cdi_primefaces_Demo.service;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

/**
 * ANNOTATION (tipo da classe 
 *
 */

/**
 * @Qualifier
 * 	- Anotacao do CDI
 * 
 * @Retention(RetentionPolicy.RUNTIME)
 *  - 
 *  
 * @Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
 *  -  Onde vai ser usada a ANOTACAO
 *  -  TYPE: pode ser usado em uma CLASSE
 *  -  METHOD: pode ser usado em METODOS
 *  -  FIELD: pode ser usado em ATRIBUTOS
 *  -  PARAMETER : pode ser usado em ATRIBUTOS 
 */


@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE, ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface Urgente {
}
