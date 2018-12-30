package cn.i.xportal.jdp.visitor.simplified;

import java.util.Enumeration;
import java.util.Vector;

public class ObjectStructure {
	private Vector<Node> nodes;
	private Node node;

	public ObjectStructure() {
		nodes = new Vector<>();
	}

	public void action(Visitor visitor) {
		for (Enumeration<Node> e = nodes.elements(); e.hasMoreElements();) {
			node = e.nextElement();
			node.accept(visitor);
		}
	}

	public void add(Node node) {
		nodes.addElement(node);
	}
}
