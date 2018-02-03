package cn.i.xportal.jdp.proxy;

import org.apache.log4j.Logger;

public class ProxySubject extends Subject {
	private static Logger logger = Logger.getLogger(ProxySubject.class);
	private RealSubject realSubject;

	public ProxySubject() {
	}

	public void request() {
		preRequest();

		if (realSubject == null) {
			realSubject = new RealSubject();
		}

		realSubject.request();

		postRequest();
	}

	private void preRequest() {
		logger.info("preRequest-->");
	}

	private void postRequest() {
		logger.info("postReqest<--");
	}
}
