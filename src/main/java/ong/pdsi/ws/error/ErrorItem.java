package ong.pdsi.ws.error;

public class ErrorItem {

	private String key;
	private String description;
	
	public ErrorItem(String key, String description) {
		this.key = key;
		this.description = description;
	}
	
	public ErrorItem(MessagesMap errorItem) {
		if (errorItem != null) {
			this.key = errorItem.getCode();
			this.description = errorItem.getMessage();
		}
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}