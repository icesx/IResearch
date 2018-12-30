package cn.xportal.java.base.proxy;

import java.lang.reflect.Method;

public interface IProxy<T> {

	public void befor(T proxyobj, Method method, Object[] args);

	public void after(T proxyobj, Method method, Object[] args);
}
