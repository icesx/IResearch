package cn.i.xportal.jdp.composite;

import java.util.Enumeration;
import java.util.Vector;

public class Composite implements Component {
	public Composite getComposite() {
		return this;
	}

	public void sampleOperation() {
		Enumeration<Component> enumeration = components();
		while (enumeration.hasMoreElements()) {
			enumeration.nextElement().sampleOperation();
		}
	}

	public void add(Component component) {
		componentVector.addElement(component);
	}

	public void remove(Component component) {
		componentVector.removeElement(component);
	}

	public Enumeration<Component> components() {
		return componentVector.elements();
	}

	private Vector<Component> componentVector = new Vector<Component>();
}
