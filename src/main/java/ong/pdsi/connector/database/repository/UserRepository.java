package ong.pdsi.connector.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ong.pdsi.connector.database.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}