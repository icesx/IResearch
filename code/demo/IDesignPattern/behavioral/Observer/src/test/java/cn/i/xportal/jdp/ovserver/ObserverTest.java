package cn.i.xportal.jdp.ovserver;

import cn.i.xportal.jdp.observer.variation.ConcreteObserver;
import cn.i.xportal.jdp.observer.variation.ConcreteSubject;
import cn.i.xportal.jdp.observer.variation.Observer;

public class ObserverTest {
	private static ConcreteSubject subject;
	private static Observer observer;
	public static void main(String[] args) {
		subject = new ConcreteSubject();
		observer = new ConcreteObserver();
		subject.attach(observer);
		subject.change("new state");
	}
}
