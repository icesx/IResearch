package cn.xportal.sb.hibernate.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.xportal.sb.hibernate.entity.UserEntity;


@Repository
public interface UserDao extends JpaRepository<UserEntity, Long> {

}