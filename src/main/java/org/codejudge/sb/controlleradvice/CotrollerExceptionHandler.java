package org.codejudge.sb.controlleradvice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@SuppressWarnings({ "unchecked", "rawtypes" })
@ControllerAdvice
public class CotrollerExceptionHandler {
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		String status=ex.getLocalizedMessage();
		if(status.isEmpty())
		{
			status="error occured while processing";
		}
		ErrorResponse error = new ErrorResponse("Server Error", ex.getLocalizedMessage());
		return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
	}
}
