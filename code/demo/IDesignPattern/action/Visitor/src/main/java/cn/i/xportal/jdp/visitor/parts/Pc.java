package cn.i.xportal.jdp.visitor.parts;

public class Pc extends Composite {
	public Pc() {
		super.add(new IntegratedBoard());
		super.add(new HardDisk());
		super.add(new Case());

	}
}
