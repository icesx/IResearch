package cn.i.xportal.jdp.bridge;

public class RefinedAbstraction extends Abstraction {
	public RefinedAbstraction(Implementor implementor) {
		super(implementor);
	}

	@Override
	public String operation() {
		return imp.operationImp();
	}
}
