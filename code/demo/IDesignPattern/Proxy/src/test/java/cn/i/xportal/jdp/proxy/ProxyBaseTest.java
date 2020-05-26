package cn.i.xportal.jdp.proxy;

public class ProxyBaseTest {
	private static Subject subject;

	public static void main(String[] args) {
		subject = new ProxySubject();
		subject.request();
		subject.request();
	}
}
