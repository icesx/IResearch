/**
 * Program  : TaskActionDao.java<br/>
 * Author   : i<br/>
 * Create   : 19 May 2020 15:13:42<br/>
 *
 * Copyright 1997-2013 by 12157724@qq.com ltd.,
 * All rights reserved.
 */
package cn.taocheng.activiti.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cn.taocheng.activiti.demo.entity.TaskActionEntity;

@Repository
public interface ITaskActionDao extends JpaRepository<TaskActionEntity, Long> {

}
