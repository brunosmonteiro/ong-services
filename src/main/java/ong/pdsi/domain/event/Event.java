package ong.pdsi.domain.event;

import java.util.ArrayList;
import java.util.List;

import ong.pdsi.domain.ong.Ong;
import ong.pdsi.domain.user.User;

public class Event {

	private Integer id;
	private String description;
	private String name;
	private Ong responsibleOng;
	private List<User> participants;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Ong getResponsibleOng() {
		return responsibleOng;
	}

	public void setResponsibleOng(Ong responsibleOng) {
		this.responsibleOng = responsibleOng;
	}

	public List<User> getParticipants() {
		return participants;
	}

	public void setParticipants(List<User> participants) {
		this.participants = participants;
	}
	
	public void addParticipant(User user) {
		if (this.participants == null) {
			this.participants = new ArrayList<>();
		}
		this.participants.add(user);
	}
}