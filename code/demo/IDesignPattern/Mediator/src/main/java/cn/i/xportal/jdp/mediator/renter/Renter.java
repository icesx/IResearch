/**
 * Program  : Renter.java<br/>
 * Author   : i<br/>
 * Create   : Mar 30, 2017 5:20:11 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.mediator.renter;

public class Renter extends Person {  
	  
    public Renter(String name, Mediator mediator) {  
        super(name, mediator);  
    }  
      
  
    @Override  
    protected void sendMessage(String msg) {  
        mediator.operation(this, msg);  
    }  
  
    @Override  
    protected void getMessage(String msg) {  
        System.out.println("求租者[" + name + "]收到中介发来的消息： " + msg);  
    }  
  
}
