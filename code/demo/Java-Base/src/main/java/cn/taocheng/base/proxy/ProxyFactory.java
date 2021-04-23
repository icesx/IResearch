package cn.taocheng.base.proxy;

import java.lang.reflect.Proxy;

public class ProxyFactory {

	@SuppressWarnings("unchecked")
	public static <T> T proxy(T t,IProxy<T> proxy) {
		return (T) Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(), t.getClass().getInterfaces(),
				new AbsIvocation<T>(t,proxy));

	}

}
