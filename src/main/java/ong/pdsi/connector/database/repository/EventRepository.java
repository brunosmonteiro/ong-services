package ong.pdsi.connector.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ong.pdsi.connector.database.entity.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

	@Query(value = "SELECT * FROM tb_evento AS E "
			+ "INNER JOIN tb_ong AS O "
			+ "ON E.id_ong = O.id_ong "
			+ "WHERE O.id_ong = ?1", nativeQuery = true)
	List<EventEntity> findByOngId(Integer ongId);
}