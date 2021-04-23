package cn.taocheng.base.proxy;

import java.lang.reflect.Method;

import org.junit.Test;

public class TestProxy {
	@Test
	public void testProxy() {
		IProxy<IBeenProxy> iproxy = new IProxy<IBeenProxy>() {

			public void befor(IBeenProxy proxyobj, Method method, Object[] args) {
				System.out.println("befor");
			}

			public void after(IBeenProxy proxyobj, Method method, Object[] args) {
				System.out.println("after");
			}
		};
		IBeenProxy beenProxy = ProxyFactory.<IBeenProxy>proxy(new BeenProxy(), iproxy);
		beenProxy.name();
	}
}
