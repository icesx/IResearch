package cn.i.xportal.jdp.abstractfactory.exercise;

public class PcProducer extends ComputerProducer {
	public Cpu createCpu() {
		return new PcCpu();
	}

	public Ram createRam() {
		return new PcRam();
	}
}
