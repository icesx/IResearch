package cn.i.xportal.jdp.visitor.simplified;

public class NodeA extends Node {
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}

	public String operationA() {
		return "NodeA is visited";
	}
}
