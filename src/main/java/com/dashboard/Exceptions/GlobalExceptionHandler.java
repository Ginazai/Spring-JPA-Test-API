package com.dashboard.Exceptions;

import org.json.JSONObject;
import org.springframework.beans.TypeMismatchException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.InvalidDataAccessApiUsageException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {	
	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> CategoryNotFoundHandler(CategoryNotFoundException e) {
		JSONObject json_output = new JSONObject();
    	json_output.put("error: ", e.getMessage());
        return ResponseEntity
        		 .badRequest()
        		 .body(json_output.toString());
	}
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<String> productNotFoundHandler(ProductNotFoundException e) {
		JSONObject json_output = new JSONObject();
    	json_output.put("error: ", e.getMessage());
        return ResponseEntity
        		 .badRequest()
        		 .body(json_output.toString());
	}
    @ExceptionHandler(TypeMismatchException.class)
    public ResponseEntity<String> handleTypeMismatch(TypeMismatchException ex) {
    	JSONObject json_output = new JSONObject();
    	json_output.put("error", "Ha ocurrido un error: Tipo de dato incorrecto.");
        return ResponseEntity
        		 .badRequest()
        		 .body(json_output.toString());
    } 
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public ResponseEntity<String> handleException(BindException e) 
    {
    	JSONObject json_output = new JSONObject();
	    json_output.put("error", "Ha ocurrido un error: Verifica tu solicitud e intenta nuevamente.");
	    return ResponseEntity
	    		.status(HttpStatus.BAD_REQUEST)
	    		.body(json_output.toString());

    }
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    @ResponseBody
    public ResponseEntity<String> handleMethodException(HttpRequestMethodNotSupportedException e) {
        JSONObject json_output = new JSONObject();
        json_output.put("error", e.getMessage());
        return ResponseEntity
                .status(HttpStatus.METHOD_NOT_ALLOWED)
                .body(json_output.toString());
    }
    @ExceptionHandler(InvalidDataAccessApiUsageException.class)
    @ResponseBody
    public ResponseEntity<String> handleApiException(InvalidDataAccessApiUsageException e) 
    {
    	JSONObject json_output = new JSONObject();
	    json_output.put("error", "Ha ocurrido un error: Parece que el metodo de solicitud no es correcto.");
	    return ResponseEntity
	    		.badRequest()
	    		.body(json_output.toString());

    } 
    @ExceptionHandler(DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseEntity<String> handleDataException(DataIntegrityViolationException e) 
    {   	
    	JSONObject json_output = new JSONObject();
	    json_output.put("error", e.getRootCause().toString());
	    return ResponseEntity
	    		.badRequest()
	    		.body(json_output.toString());
    } 
}