package ong.pdsi.connector.executor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ong.pdsi.connector.database.entity.EventEntity;
import ong.pdsi.connector.database.mapper.EventMapper;
import ong.pdsi.connector.database.repository.EventRepository;
import ong.pdsi.domain.event.Event;

@Component
public class EventExecutor {

	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventMapper eventMapper;
	
	public List<Event> getAll() {
		return eventMapper.toEventList(eventRepository.findAll());
	}
	
	public List<Event> getByOngId(Integer ongId) {
		return eventMapper.toEventList(eventRepository.findByOngId(ongId));
	}
	
	public Event getEventById(Integer id) {
		Optional<EventEntity> entity = eventRepository.findById(id);
		if (entity.isPresent()) {
			return eventMapper.toEvent(entity.get());
		}
		return null;
	}
	
	public Event createEvent(Event event) {
		return eventMapper.toEvent(eventRepository.save(eventMapper.toEventEntity(event)));
	}
	
	public Event updateEvent(Event event) {
		return eventMapper.toEvent(eventRepository.save(eventMapper.toEventEntity(event)));
	}
}