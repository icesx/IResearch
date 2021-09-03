package cn.i.xportal.jdp.visitor;

import cn.i.xportal.jdp.visitor.simplified.NodeA;
import cn.i.xportal.jdp.visitor.simplified.NodeB;
import cn.i.xportal.jdp.visitor.simplified.ObjectStructure;
import cn.i.xportal.jdp.visitor.simplified.Visitor;

public class VisitorSampleTest {
	private static ObjectStructure aObjects;
	private static Visitor visitor;

	public static void main(String[] args) {
		aObjects = new ObjectStructure();
		aObjects.add(new NodeA());
		aObjects.add(new NodeB());
		visitor = new Visitor();
		aObjects.action(visitor);

	}
}
