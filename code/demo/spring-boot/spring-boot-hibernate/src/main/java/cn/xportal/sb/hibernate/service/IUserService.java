package cn.xportal.sb.hibernate.service;

import cn.xportal.sb.hibernate.entity.UserEntity;

public interface IUserService {

	Iterable<UserEntity> getUsers();

	void delete(Long id);

	UserEntity getUser(Long id);

	void save(UserEntity user);

	void update(UserEntity user);

}
