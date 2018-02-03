package cn.i.xportal.jdp.observer.variation;

import java.util.Enumeration;
import java.util.Vector;

public abstract class Subject {
	private Vector<Observer> observersVector = new Vector<>();

	public void attach(Observer observer) {
		observersVector.addElement(observer);
		System.out.println("Attached an observer.");
	}

	public void detach(Observer observer) {
		observersVector.removeElement(observer);
	}

	public void notifyObservers(String state) {
		Enumeration<Observer> enumeration = observers();
		while (enumeration.hasMoreElements()) {
			System.out.println("Before notifying");
			enumeration.nextElement().update(state);
		}
	}

	public Enumeration<Observer> observers() {
		return observersVector.elements();
	}

}
