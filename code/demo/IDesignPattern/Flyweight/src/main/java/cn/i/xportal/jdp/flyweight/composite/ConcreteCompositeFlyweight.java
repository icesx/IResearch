package cn.i.xportal.jdp.flyweight.composite;

import java.util.HashMap;
import java.util.Map.Entry;

public class ConcreteCompositeFlyweight extends Flyweight {
	private HashMap<Character, Flyweight> flies = new HashMap<>(10);

	public ConcreteCompositeFlyweight() {
	}

	public void add(Character key, Flyweight fly) {
		flies.put(key, fly);
	}

	public void operation(String extrinsicState) {
		for (Entry<Character, Flyweight> entry : flies.entrySet()) {
			Flyweight fly = entry.getValue();

			fly.operation(extrinsicState);
		}
	}
}
