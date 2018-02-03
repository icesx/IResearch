package cn.i.xportal.jdp.factorymethod.farm;

public class StrawberryGardener implements FruitGardener {
	public Fruit factory() {
		return new Apple();
	}
}
