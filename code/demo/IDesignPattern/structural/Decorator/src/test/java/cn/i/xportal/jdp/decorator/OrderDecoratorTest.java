package cn.i.xportal.jdp.decorator;

import java.util.Date;

import cn.i.xportal.jdp.decorator.printinvoice.FooterDecorator;
import cn.i.xportal.jdp.decorator.printinvoice.HeaderDecorator;
import cn.i.xportal.jdp.decorator.printinvoice.Order;
import cn.i.xportal.jdp.decorator.printinvoice.OrderLine;
import cn.i.xportal.jdp.decorator.printinvoice.SalesOrder;

public class OrderDecoratorTest {
	private static Order order;

	public static void main(String[] args) {
		order = new SalesOrder();
		order.setSalesDate(new Date());
		order.setCustomerName("XYZ Repair Shop");

		OrderLine line1 = new OrderLine();

		line1.setItemName("FireWheel Tire");
		line1.setUnitPrice(154.23);
		line1.setUnits(4);

		order.addItem(line1);

		OrderLine line2 = new OrderLine();

		line2.setItemName("Front Fender");
		line2.setUnitPrice(300.45);
		line2.setUnits(1);

		order.addItem(line2);

		order = new HeaderDecorator(new FooterDecorator(order));

		order.print();
	}
}
