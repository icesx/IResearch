package cn.taocheng.activiti.driver.sample.service;

import java.util.List;

import cn.taocheng.activiti.driver.sample.entity.UserEntity;

public interface IUserService {

	List<UserEntity> getUsers();

	void delete(Long id);

	UserEntity getUser(Long id);

	void save(UserEntity user);

	void update(UserEntity user);

}
