package cn.i.xportal.jdp.observer.variation;

public class ConcreteSubject extends Subject {
	private String state;

	public void change(String newState) {
		state = newState;
		this.notifyObservers(state);
	}
}
