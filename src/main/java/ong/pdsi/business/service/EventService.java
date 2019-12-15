package ong.pdsi.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ong.pdsi.connector.executor.EventExecutor;
import ong.pdsi.connector.executor.OngExecutor;
import ong.pdsi.connector.executor.UserExecutor;
import ong.pdsi.domain.event.Event;
import ong.pdsi.domain.user.User;
import ong.pdsi.ws.error.MessagesMap;
import ong.pdsi.ws.error.exception.BadRequestException;

@Service
public class EventService {

	@Autowired
	private EventExecutor eventExecutor;
	
	@Autowired
	private OngExecutor ongExecutor;
	
	@Autowired
	private UserExecutor userExecutor;
	
	public List<Event> getAllEventsFromOng(Integer ongId) {
		if (ongExecutor.getOngById(ongId) == null) {
			throw new BadRequestException(MessagesMap.ONG_INEXISTENT_ID);
		}
		return eventExecutor.getByOngId(ongId);
	}
	
	public Event joinEvent(Integer ongId, Integer eventId, Integer userId) {
		if (ongExecutor.getOngById(ongId) == null) {
			throw new BadRequestException(MessagesMap.ONG_INEXISTENT_ID);
		}
		Event event = eventExecutor.getEventById(eventId);
		if (event == null) {
			throw new BadRequestException(MessagesMap.EVENT_INEXISTENT_ID);
		}
		if (event.getResponsibleOng() == null || !ongId.equals(event.getResponsibleOng().getId())) {
			throw new BadRequestException(MessagesMap.EVENT_DOES_NOT_BELONG_TO_ONG);
		}
		User user = userExecutor.getUserById(userId);
		if (user == null) {
			throw new BadRequestException(MessagesMap.USER_INEXISTENT_ID);
		}
		event.addParticipant(user);
		return eventExecutor.updateEvent(event);
	}
}