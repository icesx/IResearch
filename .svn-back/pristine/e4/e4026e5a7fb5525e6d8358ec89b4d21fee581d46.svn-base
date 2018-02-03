/**
 * Program  : Mediator.java<br/>
 * Author   : i<br/>
 * Create   : Mar 30, 2017 5:21:14 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.mediator.renter;

import java.util.ArrayList;
import java.util.List;

public abstract class Mediator {  
    // 用于添加储存 "房东"角色  
    protected List<Person> landlordList = new ArrayList<Person>();  
      
    // 用于添加储存 "求租者"角色  
    protected List<Person> renterList = new ArrayList<Person>();  
      
    /** 
     * 中介者注册房东信息 
     * @param landlord 房东实体 
     */  
    public void registerLandlord(Person landlord){  
        landlordList.add(landlord);  
    }  
      
    /** 
     * 中介者注册 求租者信息 
     * @param landlord 房东实体 
     */  
    public void registerRenter(Person landlord){  
        renterList.add(landlord);  
    }  
      
      
    /** 
     * 声明抽象方法 由具体中介者子类实现 消息的中转和协调 
     */  
    public abstract void operation(Person person, String message);  
  
} 
