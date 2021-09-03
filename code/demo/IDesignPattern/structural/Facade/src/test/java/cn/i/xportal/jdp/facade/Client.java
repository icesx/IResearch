package cn.i.xportal.jdp.facade;

public class Client {
	private static SecurityFacade security=new SecurityFacade();

	public static void main(String[] args) {
		security.activate();
	}
}
