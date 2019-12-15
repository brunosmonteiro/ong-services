package ong.pdsi.connector.executor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ong.pdsi.connector.database.entity.OngEntity;
import ong.pdsi.connector.database.mapper.OngMapper;
import ong.pdsi.connector.database.repository.OngRepository;
import ong.pdsi.domain.ong.Ong;

@Component
public class OngExecutor {

	@Autowired
	private OngRepository ongRepository;
	
	@Autowired
	private OngMapper ongMapper;
	
	public List<Ong> getAll() {
		return ongMapper.toOngList(ongRepository.findAll());
	}
	
	public Ong createOng(Ong ong) {
		return ongMapper.toOng(ongRepository.save(ongMapper.toOngEntity(ong)));
	}
	
	public Ong updateOng(Ong ong) {
		return ongMapper.toOng(ongRepository.save(ongMapper.toOngEntity(ong)));
	}
	
	public Ong getOngById(Integer id) {
		Optional<OngEntity> ongEntity = ongRepository.findById(id);
		if (ongEntity.isPresent()) {
			return ongMapper.toOng(ongEntity.get());
		}
		return null;
	}
	
	public void deleteOngById(Integer id) {
		ongRepository.deleteById(id);
	}
}