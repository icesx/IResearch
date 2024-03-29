享元模式
=====
避免创建大量对象，通过hashmap存储key的方式

1. 享元模式以共享的方式高效地支持大量的细粒度对象。享元对象能做到共享的关键是区分内蕴状态（Internal State）和外蕴状态（External State）。内蕴状态是存储在享元对象内部并且不会随环境改变而改变。因此内蕴状态并可以共享。

2. 外蕴状态是随环境改变而改变的、不可以共享的状态。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后，在需要使用的时候再传入到享元对象内部。外蕴状态与内蕴状态是相互独立的。

3. 抽象享元(Flyweight)角色：此角色是所有的具体享元类的超类，为这些类规定出需要实现的公共接口。那些需要外蕴状态(External State)的操作可以通过调用商业方法以参数形式传入。

4. 具体享元(ConcreteFlyweight)角色：实现抽象享元角色所规定的接口。如果有内蕴状态的话，必须负责为内蕴状态提供存储空间。享元对象的内蕴状态必须与对象所处的周围环境无关，从而使得享元对象可以在系统内共享的。

5. 享元工厂(FlyweightFactory)角色：本角色负责创建和管理享元角色。本角色必须保证享元对象可以被系统适当地共享。当一个客户端对象调用一个享元对象的时候，享元工厂角色会检查系统中是否已经有一个复合要求的享元对象。如果已经有了，享元工厂角色就应当提供这个已有的享元对象；如果系统中没有一个适当的享元对象的话，享元工厂角色就应当创建一个合适的享元对象。

6. 客户端(Client)角色：本角色需要维护一个对所有享元对象的引用。本角色需要自行存储所有享元对象的外蕴状态。

### 关键代码

```java
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
```

