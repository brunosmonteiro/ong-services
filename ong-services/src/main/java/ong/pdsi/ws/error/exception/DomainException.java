package ong.pdsi.ws.error.exception;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import ong.pdsi.ws.error.MessagesMap;

@SuppressWarnings("serial")
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class DomainException extends RuntimeException {

	private MessagesMap error;
	private List<MessagesMap> errors;
	
	public DomainException(MessagesMap error) {
		this.error = error;
	}
	
	public DomainException(List<MessagesMap> errors) {
		this.errors = errors;
	}
	
	public MessagesMap getError() {
		return error;
	}
	
	public List<MessagesMap> getErrors() {
		return errors;
	}
}