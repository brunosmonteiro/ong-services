package ong.pdsi.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ong.pdsi.connector.executor.OngExecutor;
import ong.pdsi.domain.ong.Ong;
import ong.pdsi.ws.error.MessagesMap;
import ong.pdsi.ws.error.exception.BadRequestException;

@Service
public class OngService {

	@Autowired
	private OngExecutor ongExecutor;
	
	public List<Ong> getAll() {
		return ongExecutor.getAll();
	}
	
	public Ong createOng(Ong ong) {
		return ongExecutor.createOng(ong);
	}
	
	public Ong updateOng(Ong ong) {
		if (ong.getId() == null) {
			throw new BadRequestException(MessagesMap.ONG_ID_NULL);
		}
		if (ongExecutor.getOngById(ong.getId()) == null) {
			throw new BadRequestException(MessagesMap.ONG_INEXISTENT_ID);
		}
		return ongExecutor.updateOng(ong);
	}
	
	public void deleteOng(Integer ongId) {
		if (ongId == null) {
			throw new BadRequestException(MessagesMap.ONG_ID_NULL);
		}
		if (ongExecutor.getOngById(ongId) == null) {
			throw new BadRequestException(MessagesMap.ONG_INEXISTENT_ID);
		}
		ongExecutor.deleteOngById(ongId);
	}
	
	public Ong getOngById(Integer ongId) {
		if (ongId == null) {
			throw new BadRequestException(MessagesMap.ONG_ID_NULL);
		}
		return ongExecutor.getOngById(ongId);
	}
}