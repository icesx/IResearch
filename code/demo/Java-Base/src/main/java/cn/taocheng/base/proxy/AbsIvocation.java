package cn.taocheng.base.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class AbsIvocation<T> implements InvocationHandler {

	private T proxyobj;
	private IProxy<T> proxyOperat;

	public AbsIvocation(T t, IProxy<T> proxyOpreat) {
		proxyobj = t;
		this.proxyOperat = proxyOpreat;
	}

	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		proxyOperat.befor(proxyobj, method, args);
		Object o = method.invoke(proxyobj, args);
		proxyOperat.after(proxyobj, method, args);
		return o;
	}

}
