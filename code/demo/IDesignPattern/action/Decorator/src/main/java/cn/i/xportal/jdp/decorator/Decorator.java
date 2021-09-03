package cn.i.xportal.jdp.decorator;

public class Decorator implements Component {
	private Component component;

	public Decorator(Component component) {
		this.component = component;
	}

	public Decorator() {
	}

	public void sampleOperation() {
		component.sampleOperation();
	}

}
