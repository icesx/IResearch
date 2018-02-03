/**
 * Program  : HouseMediator.java<br/>
 * Author   : i<br/>
 * Create   : Mar 30, 2017 5:21:47 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.mediator.renter;

public class HouseMediator extends Mediator {  
	  
    @Override  
    public void operation(Person person, String message) {  
        if(person instanceof Renter){  
            // 将租屋的需求消息传递给 注册了的房东们  
            for(Person landlord: landlordList){  
                landlord.getMessage(message);  
            }  
        } else if(person instanceof Landlord){  
            // 将房东的出租房消息传递给 注册了的 房屋求租者们  
            for(Person renter : renterList){  
                renter.getMessage(message);  
            }  
        }  
          
    }  
  
} 