package com.dashboard.Exceptions;

public class ProductNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ProductNotFoundException(Long id) {
    super(String.format("No se encontro un producto correspondiente al ID indicado: %s",id));
  }
}
