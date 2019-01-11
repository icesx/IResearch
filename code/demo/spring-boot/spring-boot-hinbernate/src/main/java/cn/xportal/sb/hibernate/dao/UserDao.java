package cn.xportal.sb.hibernate.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cn.xportal.sb.hibernate.entity.UserEntity;


@Repository
public interface UserDao extends CrudRepository<UserEntity, Long> {

}