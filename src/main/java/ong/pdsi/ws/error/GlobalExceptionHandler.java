package ong.pdsi.ws.error;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import ong.pdsi.ws.error.exception.BadRequestException;
import ong.pdsi.ws.error.exception.DomainException;
import ong.pdsi.ws.error.exception.InternalServerErrorException;
import ong.pdsi.ws.error.exception.NotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * Builds the ErrorResponse response object based on the error encapsulated in the exception thrown.
	 * @param e
	 * @return
	 */
	private ErrorResponse buildErrorResponse(DomainException e) {
		ErrorResponse response = new ErrorResponse();
		if (e != null) {
			if (!CollectionUtils.isEmpty(e.getErrors())) {
				response.setErrors(e.getErrors().stream().map(ErrorItem::new).collect(Collectors.toList()));
			} else {
				response.setError(new ErrorItem(e.getError()));
			}
		} else {
			response.setError(new ErrorItem(MessagesMap.GENERIC_ERROR));
		}
		return response;
	}

	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFoundException(NotFoundException e) {
		return new ResponseEntity<>(buildErrorResponse(e), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleBadRequestException(BadRequestException e) {
		return new ResponseEntity<>(buildErrorResponse(e), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ErrorResponse> handleInternalServerErrorException(InternalServerErrorException e) {
		return new ResponseEntity<>(buildErrorResponse(e), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGenericException(Exception e) {
		return new ResponseEntity<>(new ErrorResponse(new ErrorItem(MessagesMap.GENERIC_ERROR)), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}