package ong.pdsi.connector.database.mapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import ong.pdsi.connector.database.entity.UserEntity;
import ong.pdsi.domain.user.User;

@Component
public class UserMapper {

	public UserEntity toUserEntity(User user) {
		if (user == null) {
			return null;
		}
		UserEntity response = new UserEntity();
		response.setId(user.getId());
		response.setName(user.getName());
		response.setUsername(user.getUsername());
		response.setPassword(user.getPassword());
		return response;
	}
	
	public User toUser(UserEntity userEntity) {
		if (userEntity == null) {
			return null;
		}
		User response = new User();
		response.setId(userEntity.getId());
		response.setName(userEntity.getName());
		response.setUsername(userEntity.getUsername());
		response.setPassword(userEntity.getPassword());
		return response;
	}
	
	public List<User> toUserList(List<UserEntity> entities) {
		if (entities == null) {
			return Collections.emptyList();
		}
		List<User> response = new ArrayList<>();
		for (UserEntity entity : entities) {
			response.add(toUser(entity));
		}
		return response;
	}
	
	public List<UserEntity> toUserEntityList(List<User> users) {
		if (users == null) {
			return Collections.emptyList();
		}
		List<UserEntity> response = new ArrayList<>();
		for (User user : users) {
			response.add(toUserEntity(user));
		}
		return response;
	}
}