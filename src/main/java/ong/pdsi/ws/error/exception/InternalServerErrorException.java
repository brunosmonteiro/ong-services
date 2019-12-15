package ong.pdsi.ws.error.exception;

import java.util.List;

import ong.pdsi.ws.error.MessagesMap;

@SuppressWarnings("serial")
public class InternalServerErrorException extends DomainException {

	public InternalServerErrorException(MessagesMap error) {
		super(error);
	}
	
	public InternalServerErrorException(List<MessagesMap> errors) {
		super(errors);
	}
}