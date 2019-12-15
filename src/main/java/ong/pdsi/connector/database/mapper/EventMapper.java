package ong.pdsi.connector.database.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ong.pdsi.connector.database.entity.EventEntity;
import ong.pdsi.domain.event.Event;

@Component
public class EventMapper {
	
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private OngMapper ongMapper;

	public List<Event> toEventList(List<EventEntity> entities) {
		if (entities == null) {
			return Collections.emptyList();
		}
		List<Event> response = new ArrayList<>();
		for (EventEntity entity : entities) {
			response.add(toEvent(entity));
		}
		return response;
	}
	
	public Event toEvent(EventEntity eventEntity) {
		if (eventEntity == null) {
			return null;
		}
		Event response = new Event();
		response.setDescription(eventEntity.getDescription());
		response.setId(eventEntity.getId());
		response.setName(eventEntity.getName());
		response.setResponsibleOng(ongMapper.toOng(eventEntity.getResponsibleOng()));
		response.setParticipants(userMapper.toUserList(eventEntity.getParticipants()));
		return response;
	}
	
	public EventEntity toEventEntity(Event event) {
		if (event == null) {
			return null;
		}
		EventEntity response = new EventEntity();
		response.setDescription(event.getDescription());
		response.setId(event.getId());
		response.setName(event.getName());
		response.setResponsibleOng(ongMapper.toOngEntity(event.getResponsibleOng()));
		response.setParticipants(userMapper.toUserEntityList(event.getParticipants()));
		return response;
	}
}