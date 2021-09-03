package cn.i.xportal.jdp.command;

public class BaseCommandTest {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		Invoker invoker = new Invoker(command);

		invoker.action();
	}
}
