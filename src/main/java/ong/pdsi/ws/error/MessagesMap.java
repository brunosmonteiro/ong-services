package ong.pdsi.ws.error;

import org.apache.commons.lang3.StringUtils;

public enum MessagesMap {

	GENERIC_ERROR("generic.error", "Erro inesperado. Por favor, tente novamente mais tarde."),
	
	// ONG
	ONG_NULL("ong.null"),
	ONG_ID_NULL("ong.id.null"),
	ONG_INEXISTENT_ID("ong.id.inexistent"),
	
	// EVENT
	EVENT_DOES_NOT_BELONG_TO_ONG("event.doesnt.belong"),
	EVENT_INEXISTENT_ID("event.id.inexistent"),
	
	// USER
	USER_INEXISTENT_ID("user.id.inexistent"),
	
	// FORM
	EMPTY_NAME("name.empty", "Nome da ONG nulo ou vazio!"),
	EMPTY_DESCRIPTION("description.empty", "Descricao nula ou vazia!"),
	EMPTY_CNPJ("cnpj.empty", "CNPJ nulo ou vazio!"),
	INVALID_CNPJ("description.empty", "CNPJ inválido!");
	
	private String code;
	private String message;
	
	private MessagesMap(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	private MessagesMap(String code) {
		this.code = code;
	}
	
	public String getCode() {
		return code;
	}

	public String getMessage() {
		if (StringUtils.isBlank(message)) {
			return GENERIC_ERROR.getMessage();
		}
		return message;
	}
}