package cn.i.xportal.jdp.command.book;

public class Invoker {
	private Command command;

	public Invoker(Command cmd) {
		command = cmd;
	}

	public void invoke() {
		if (command != null) {
			command.execute();
		}
	}
}
