package cn.i.xportal.jdp.decorator.printinvoice;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Vector;

public abstract class Order {
	protected String customerName;
	protected Date salesDate;
	protected Vector<OrderLine> items = new Vector<>(10);

	public void print() {
		for (int i = 0; i < items.size(); i++) {
			OrderLine item = (OrderLine) items.get(i);
			item.printLine();
		}
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public Date getSalesDate() {
		return salesDate;
	}

	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}

	public void addItem(OrderLine item) {
		items.add(item);
	}

	public void remoteItem(OrderLine item) {
		items.remove(item);
	}

	public double getGrandTotal() {
		double amnt = 0.0D;

		for (int i = 0; i < items.size(); i++) {
			OrderLine item = (OrderLine) items.get(i);
			amnt += item.getSubtotal();
		}

		return amnt;
	}

	protected String formatCurrency(double amnt) {
		return NumberFormat.getCurrencyInstance().format(amnt);
	}

}
