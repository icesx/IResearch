package cn.i.xportal.jdp.visitor.simplified;

import org.apache.log4j.Logger;

public class Visitor {
	private static Logger logger = Logger.getLogger(Visitor.class);

	public void visit(NodeA nodeA) {
		logger.info(nodeA.operationA());
	}

	public void visit(NodeB nodeB) {
		logger.info(nodeB.operationB());
	}
}
