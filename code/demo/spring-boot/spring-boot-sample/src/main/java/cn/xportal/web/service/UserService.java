package cn.xportal.web.service;

import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import cn.xportal.entity.UserEntity;
import cn.xportal.mapper.UserMapper;

@Transactional
@Named
public class UserService implements IUserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<UserEntity> getUsers() {
		List<UserEntity> users = userMapper.getAll();
		return users;
	}

	@Override
	public UserEntity getUser(Long id) {
		UserEntity user = userMapper.getOne(id);
		return user;
	}

	@Override
	public void save(UserEntity user) {
		userMapper.insert(user);
	}

	@Override
	public void update(UserEntity user) {
		userMapper.update(user);
	}

	@Override
	public void delete(@PathVariable("id") Long id) {
		userMapper.delete(id);
	}

}
