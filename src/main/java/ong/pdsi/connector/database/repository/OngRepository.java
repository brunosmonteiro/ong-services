package ong.pdsi.connector.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ong.pdsi.connector.database.entity.OngEntity;

public interface OngRepository extends JpaRepository<OngEntity, Integer> {

}