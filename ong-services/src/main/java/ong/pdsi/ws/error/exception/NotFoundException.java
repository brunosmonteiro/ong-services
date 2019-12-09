package ong.pdsi.ws.error.exception;

import java.util.List;

import ong.pdsi.ws.error.MessagesMap;

@SuppressWarnings("serial")
public class NotFoundException extends DomainException {

	public NotFoundException(MessagesMap error) {
		super(error);
	}
	
	public NotFoundException(List<MessagesMap> errors) {
		super(errors);
	}
}
