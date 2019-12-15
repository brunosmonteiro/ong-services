package ong.pdsi.connector.executor;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ong.pdsi.connector.database.entity.UserEntity;
import ong.pdsi.connector.database.mapper.UserMapper;
import ong.pdsi.connector.database.repository.UserRepository;
import ong.pdsi.domain.user.User;

@Component
public class UserExecutor {

	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private UserRepository userRepository;
	
	public User getUserById(Integer id) {
		Optional<UserEntity> entity = userRepository.findById(id);
		if (entity.isPresent()) {
			return userMapper.toUser(entity.get());
		}
		return null;
	}
}