package cn.xportal.sb.hibernate.web.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import cn.xportal.sb.hibernate.dao.UserDao;
import cn.xportal.sb.hibernate.entity.UserEntity;

@Transactional
@Named("h-userservice")
public class UserService implements IUserService {
	@Autowired
	private UserDao userMapper;

	@Override
	public Iterable<UserEntity> getUsers() {
		return userMapper.findAll();
	}

	@Override
	public UserEntity getUser(Long id) {
		return userMapper.findById(id).get();
	}

	@Override
	public void save(UserEntity user) {
		userMapper.save(user);
	}

	@Override
	public void delete(@PathVariable("id") Long id) {
		userMapper.deleteById(id);
	}

}
