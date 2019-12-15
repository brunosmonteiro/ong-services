package ong.pdsi.connector.database.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import ong.pdsi.connector.database.entity.OngEntity;
import ong.pdsi.domain.ong.Ong;

@Component
public class OngMapper {

	public Ong toOng(OngEntity ongEntity) {
		if (ongEntity == null) {
			return null;
		}
		Ong response = new Ong();
		response.setCnpj(ongEntity.getCnpj());
		response.setDescription(ongEntity.getDescription());
		response.setId(ongEntity.getId());
		response.setName(ongEntity.getName());
		response.setType(ongEntity.getType());
		return response;
	}
	
	public List<Ong> toOngList(List<OngEntity> ongEntities) {
		if (CollectionUtils.isEmpty(ongEntities)) {
			return Collections.emptyList();
		}
		List<Ong> response = new ArrayList<>();
		for (OngEntity ongEntity : ongEntities) {
			response.add(toOng(ongEntity));
		}
		return response;
	}
	
	public OngEntity toOngEntity(Ong ong) {
		if (ong == null) {
			return null;
		}
		OngEntity response = new OngEntity();
		response.setCnpj(ong.getCnpj());
		response.setDescription(ong.getDescription());
		response.setId(ong.getId());
		response.setName(ong.getName());
		response.setType(ong.getType());
		return response;
	}
}