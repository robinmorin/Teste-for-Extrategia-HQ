package br.com.teste.rest.controllers.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.io.Serializable;

@Data
@Builder
public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private HttpStatus httpStatus;
	private String timestamp;
	private String error;
	private String message;
	private String path;
	private ErrorDetails errorDetails;

}
