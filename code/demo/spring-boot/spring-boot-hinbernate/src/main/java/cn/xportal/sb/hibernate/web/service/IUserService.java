package cn.xportal.sb.hibernate.web.service;

import cn.xportal.sb.hibernate.entity.UserEntity;

public interface IUserService {

	void delete(Long id);

	UserEntity getUser(Long id);

	void save(UserEntity user);

	Iterable<UserEntity> getUsers();

}
