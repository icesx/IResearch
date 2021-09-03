package cn.i.xportal.jdp.flyweight;

import cn.i.xportal.jdp.flyweight.composite.Flyweight;
import cn.i.xportal.jdp.flyweight.composite.FlyweightFactorySingleton;

public class FlyweightCompositeTest {
	private static FlyweightFactorySingleton factory;

	public static void main(String[] args) {
		factory = FlyweightFactorySingleton.getInstance();

		Flyweight fly = null;

		/*
		 * fly = factory.factory(new Character('a')); fly.operation();
		 * 
		 * fly = factory.factory(new Character('b')); fly.operation();
		 * 
		 * fly = factory.factory(new Character('a')); fly.operation();
		 */

		fly = factory.factory("abc");
		fly.operation("Composite Call");

		// intrinsic Flyweight
		factory.checkFlyweight();
	}
}
