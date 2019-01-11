package cn.xportal.sb.hibernate.service;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import cn.xportal.sb.hibernate.dao.UserDao;
import cn.xportal.sb.hibernate.entity.UserEntity;

@Transactional
@Named
public class UserService implements IUserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Iterable<UserEntity> getUsers() {
		return userDao.findAll();
	}

	@Override
	public UserEntity getUser(Long id) {
		UserEntity user = userDao.findById(id).get();
		return user;
	}

	@Override
	public void save(UserEntity user) {
		userDao.save(user);
	}

	@Override
	public void update(UserEntity user) {
		userDao.save(user);
	}

	@Override
	public void delete(@PathVariable("id") Long id) {
		userDao.deleteById(id);
	}

}
