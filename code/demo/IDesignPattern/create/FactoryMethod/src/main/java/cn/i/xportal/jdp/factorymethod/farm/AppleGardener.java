package cn.i.xportal.jdp.factorymethod.farm;

public class AppleGardener implements FruitGardener {
	public Fruit factory() {
		return new Apple();
	}
}
