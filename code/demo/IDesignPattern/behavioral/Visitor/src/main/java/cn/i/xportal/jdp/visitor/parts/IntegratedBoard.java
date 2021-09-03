package cn.i.xportal.jdp.visitor.parts;

public class IntegratedBoard extends Composite {
	public IntegratedBoard() {
		super.add(new MainBoard());
		super.add(new Cpu());
	}
}
