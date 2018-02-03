/**
 * Program  : Client.java<br/>
 * Author   : i<br/>
 * Create   : Mar 30, 2017 5:22:08 PM<br/>
 *
 * Copyright 1997-2013 by III.cn ltd.,
 * All rights reserved.
 */
package cn.i.xportal.jdp.mediator.renter;

public class Client {

	public static void main(String[] args) {
		Mediator mediator = new HouseMediator();
		Person landlordA, renter;
		landlordA = new Landlord("房东李", mediator);
		new Landlord("房东黎", mediator);
		renter = new Renter("小吕", mediator);
		mediator.registerRenter(renter);
		renter.sendMessage("在天河公园附近租套房子，价格1000元左右一个月");
		System.out.println("--------------------------");
		landlordA.sendMessage("天河公园学院站三巷27号四楼有一房一厅出租  1200/月  光线好 近公交站");
	}

}
