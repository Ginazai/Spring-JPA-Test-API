package com.dashboard.Exceptions;

public class UserNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(Long id) {
    super(String.format("No se encontro al usuario correspondiente al ID proporcionado: %s",id));
  }
}
