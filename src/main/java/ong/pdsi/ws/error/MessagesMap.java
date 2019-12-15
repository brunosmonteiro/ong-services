package ong.pdsi.ws.error;

import org.apache.commons.lang3.StringUtils;

public enum MessagesMap {

	GENERIC_ERROR("error.generic", "Erro inesperado. Por favor, tente novamente mais tarde."),
	
	// ONG
	ONG_NULL("error.ong.null"),
	ONG_ID_NULL("error.ong.id.null"),
	ONG_INEXISTENT_ID("error.ong.id.inexistent"),
	
	// EVENT
	EVENT_DOES_NOT_BELONG_TO_ONG("error.event.doesnt.belong"),
	EVENT_INEXISTENT_ID("error.event.id.inexistente"),
	
	// USER
	USER_INEXISTENT_ID("error.user.id.inexistent"),
	
	// FORM
	EMPTY_NAME("error.ong.name.empty", "Nome da ONG nulo ou vazio!"),
	EMPTY_DESCRIPTION("error.ong.description.empty", "Descricao nula ou vazia!"),
	EMPTY_CNPJ("error.ong.cnpj.empty", "CNPJ nulo ou vazio!"),
	INVALID_CNPJ("error.ong.description.empty", "CNPJ inválido!");
	
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