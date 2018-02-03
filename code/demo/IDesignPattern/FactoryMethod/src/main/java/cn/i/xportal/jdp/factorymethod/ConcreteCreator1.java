package cn.i.xportal.jdp.factorymethod;

public class ConcreteCreator1 implements Creator {
	public Product factory() {
		return new ConcreteProduct1();
	}
}
