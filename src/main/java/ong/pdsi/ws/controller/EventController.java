package ong.pdsi.ws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ong.pdsi.business.service.EventService;
import ong.pdsi.domain.event.Event;

@RestController
@RequestMapping("/api")
public class EventController {
	
	@Autowired
	private EventService eventService;

	@GetMapping("/ongs/{ongId}/events")
	public List<Event> getAllOngEvents(@PathVariable("ongId") Integer ongId) {
		return eventService.getAllEventsFromOng(ongId);
	}
	
	@PostMapping("/ongs/{ongId}/events/{eventId}/participants/{userId}")
	public Event joinEvent(@PathVariable("ongId") Integer ongId, @PathVariable("eventId") Integer eventId,
			@PathVariable("userId") Integer userId) {
		return eventService.joinEvent(ongId, eventId, userId);
	}
}