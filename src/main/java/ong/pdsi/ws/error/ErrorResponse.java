package ong.pdsi.ws.error;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

	private ErrorItem error;
	private List<ErrorItem> errors;
	
	public ErrorResponse() {}

	public ErrorResponse(ErrorItem error) {
		this.error = error;
	}

	public ErrorItem getError() {
		return error;
	}

	public void setError(ErrorItem error) {
		this.error = error;
	}

	public List<ErrorItem> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorItem> errors) {
		this.errors = errors;
	}

	public void appendError(ErrorItem errorItem) {
		if (errors == null) {
			errors = new ArrayList<ErrorItem>();
		}
		errors.add(errorItem);
	}
}