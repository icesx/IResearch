package cn.i.xportal.jdp.command.book;

public class Receiver {
	private int identification;

	public Receiver(int id) {
		identification = id;
	}

	public void action() {
		System.out.println(" Action is binded by the Receiver: " + identification);
	}
}
