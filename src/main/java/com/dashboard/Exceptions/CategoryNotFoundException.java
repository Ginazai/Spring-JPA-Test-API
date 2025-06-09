package com.dashboard.Exceptions;

public class CategoryNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException(Long id) {
	    super(String.format("No se encontro una categoria correspondiente al ID indicado: %s",id)); 
	}
}
