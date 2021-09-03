package cn.i.xportal.jdp.mediator;

public class Client {
	public static void main(String args[]) {
		ConcreteMediator mediator = new ConcreteMediator();
		mediator.createConcreteMediator();

		Colleague c1 = new Colleague1(mediator);
		Colleague c2 = new Colleague2(mediator);

		mediator.colleagueChanged(c1);
		c1.change();
		c2.change();
	}
}
