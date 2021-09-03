/**
 * Program  : Person.java<br/>
 * Author   : i<br/>
 * Create   : Mar 30, 2017 5:19:01 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.mediator.renter;

public abstract class Person {  
    // 维持一个抽象中介者的引用  
    protected Mediator mediator;  
      
    protected String name;  
      
    public Person(String name, Mediator mediator){  
        this.mediator = mediator;  
        this.name = name;  
        mediator.registerLandlord(this);
    }  
      
    /** 
     * 设置中介者对象 
     * @param mediator 
     */  
    public void setMediator(Mediator mediator){  
        this.mediator = mediator;  
    }  
  
    /** 
     * 向中介 发送消息 
     */  
    protected abstract void sendMessage(String msg);  
      
    /** 
     * 从中介 获取消息 
     */  
    protected abstract void getMessage(String msg);  
}  
