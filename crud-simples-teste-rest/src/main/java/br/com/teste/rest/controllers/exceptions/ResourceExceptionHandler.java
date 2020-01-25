package br.com.teste.rest.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptionClass(Exception ex, WebRequest request) {
		String message;
		HttpStatus status;

		//Tratamento dos erros no caso se for ConstraintViolationException
		if(ex instanceof ConstraintViolationException){
			status = HttpStatus.BAD_REQUEST;
			message = getErrorDetailsException((ConstraintViolationException) ex);
		}else {
			status = HttpStatus.INTERNAL_SERVER_ERROR;
			StackTraceElement stackTraceElement = ex.getStackTrace()[0];
			message = ex.getClass().getSimpleName() + (stackTraceElement == null ? "" : " " + stackTraceElement.toString());
		}

		ErrorDetails details = new ErrorDetails.ErrorDetailsBuilder()
												.uniqueId(String.valueOf(request.hashCode()))
												.message(message)
												.build();

		StandardError result = new StandardError.StandardErrorBuilder()
												.httpStatus(status)
												.timestamp(DateTimeFormatter.ISO_DATE_TIME.format(LocalDateTime.now()))
												.message("Erro no Servidor, tente novamente mais tarde")
												.error(ex.getMessage())
												.path(request.getDescription(false).substring(request.getDescription(false).indexOf("=")+1))
												.errorDetails(details)
												.build();

		return ResponseEntity.status(status).body(result);
	}

	private String getErrorDetailsException(ConstraintViolationException exception){
		StringBuilder message = new StringBuilder();
		exception.getConstraintViolations().stream()
				.forEach(constraint -> message.append("<").append(constraint.getPropertyPath()).append(">: ").append(constraint.getMessage()).append(" | "));
		return message.toString().substring(0,message.toString().length()-2);
	}
}
