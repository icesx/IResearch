package cn.i.xportal.jdp.flyweight;

import cn.i.xportal.jdp.flyweight.simple.Flyweight;
import cn.i.xportal.jdp.flyweight.simple.FlyweightFactorySingleton;

public class FlyweightSampleTest {
	private static FlyweightFactorySingleton factory;

	public static void main(String[] args) {
		factory = FlyweightFactorySingleton.getInstance();

		Flyweight fly = factory.factory(new Character('a'));
		fly.operation("First Call");

		fly = factory.factory(new Character('b'));
		fly.operation("Second Call");

		fly = factory.factory(new Character('a'));
		fly.operation("Third Call");

		// intrinsic Flyweight
		factory.checkFlyweight();
	}
}
