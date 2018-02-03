package cn.i.xporal.jdp.iterator;

import com.javapatterns.iterator.whitebox.Aggregate;
import com.javapatterns.iterator.whitebox.ConcreteAggregate;
import com.javapatterns.iterator.whitebox.Iterator;

public class SampleTest {
	private Iterator it;
	private Aggregate agg = new ConcreteAggregate();

	public void operation() {
		it = agg.createIterator();

		while (!it.isDone()) {
			System.out.println(it.currentItem().toString());
			it.next();
		}
	}

	public static void main(String[] args) {
		SampleTest client = new SampleTest();

		client.operation();
	}
}
