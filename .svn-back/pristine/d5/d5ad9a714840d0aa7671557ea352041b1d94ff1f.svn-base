package cn.i.xportal.jdp.flyweight.composite;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FlyweightFactorySingleton {
	private static FlyweightFactorySingleton myself = new FlyweightFactorySingleton();

	private HashMap flies = new HashMap();
	private Flyweight aFlyweight = null;

	private FlyweightFactorySingleton() {
	}

	public static FlyweightFactorySingleton getInstance() {
		return new FlyweightFactorySingleton();
	}

	public synchronized Flyweight factory(String complexState) {
		ConcreteCompositeFlyweight complexFly = new ConcreteCompositeFlyweight();

		int length = complexState.length();
		Character state = null;

		for (int i = 0; i < length; i++) {
			state = new Character(complexState.charAt(i));
			System.out.println("factory(" + state + ")");
			complexFly.add(state, this.factory(state));
		}
		return complexFly;
	}

	public Flyweight factory(Character state) {
		if (flies.containsKey(state)) {
			return (Flyweight) flies.get(state);
		} else {
			Flyweight fly = new ConcreteFlyweight(state);
			flies.put(state, fly);
			return fly;
		}
	}

	public void checkFlyweight() {
		Flyweight fly = null;
		int i = 0;

		System.out.println("\n==========checkFlyweight()=============");
		for (Iterator it = flies.entrySet().iterator(); it.hasNext();) {
			Map.Entry e = (Map.Entry) it.next();
			System.out.println("Item " + (++i) + " : " + e.getKey());
		}
		System.out.println("\n==========checkFlyweight()=============");
	}

}
