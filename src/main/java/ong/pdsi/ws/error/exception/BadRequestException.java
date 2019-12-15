package ong.pdsi.ws.error.exception;

import java.util.List;

import ong.pdsi.ws.error.MessagesMap;

@SuppressWarnings("serial")
public class BadRequestException extends DomainException {

	public BadRequestException(MessagesMap error) {
		super(error);
	}
	
	public BadRequestException(List<MessagesMap> errors) {
		super(errors);
	}
}