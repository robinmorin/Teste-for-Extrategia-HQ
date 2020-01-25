package br.com.teste.rest.controllers.exceptions;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uniqueId;
	private String informationCode;
	private String message;
	private List<String> args;

}
