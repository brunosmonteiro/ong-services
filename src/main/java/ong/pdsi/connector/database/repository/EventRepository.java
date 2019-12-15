package ong.pdsi.connector.database.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ong.pdsi.connector.database.entity.EventEntity;

@Repository
public interface EventRepository extends JpaRepository<EventEntity, Integer> {

	@Query("SELECT e FROM EventEntity e WHERE e.responsibleOng.ongId = ?1")
	List<EventEntity> findByOngId(Integer ongId);
}