package ong.pdsi.domain.event;

import java.util.List;

import ong.pdsi.domain.ong.Ong;

public class EventResponse {

	private Ong responsibleOng;
	private List<Event> events;

	public Ong getResponsibleOng() {
		return responsibleOng;
	}

	public void setResponsibleOng(Ong responsibleOng) {
		this.responsibleOng = responsibleOng;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}
}