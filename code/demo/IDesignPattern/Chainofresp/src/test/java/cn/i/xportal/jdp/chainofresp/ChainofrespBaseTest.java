package cn.i.xportal.jdp.chainofresp;

public class ChainofrespBaseTest {
	private static Handler handler1;
	private static Handler handler2;

	public static void main(String[] args) {
		handler1 = new ConcreteHandler();
		handler2 = new ConcreteHandler();
		handler1.setHandler(handler2);
		handler1.handleNext();
	}
}
