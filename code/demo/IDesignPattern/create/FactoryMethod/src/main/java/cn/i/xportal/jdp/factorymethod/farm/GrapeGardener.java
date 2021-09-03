package cn.i.xportal.jdp.factorymethod.farm;

public class GrapeGardener implements FruitGardener {
	public Fruit factory() {
		return new Apple();
	}
}
