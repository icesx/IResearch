package cn.xportal.web.service;

import java.util.List;

import cn.xportal.entity.UserEntity;

public interface IUserService {

	List<UserEntity> getUsers();

	void delete(Long id);

	UserEntity getUser(Long id);

	void save(UserEntity user);

	void update(UserEntity user);

}
