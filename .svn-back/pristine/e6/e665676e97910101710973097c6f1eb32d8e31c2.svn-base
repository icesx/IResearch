package cn.i.xportal.jdp.proxy;

import cn.i.xportal.jdp.proxy.smartproxy.Proxy;
import cn.i.xportal.jdp.proxy.smartproxy.Searcher;

public class SmartProxyTest {
	private static Searcher searcher;

	public static void main(String[] args) {
		searcher = new Proxy();
		String userId = "Admin";
		String searchType = "SEARCH_BY_ACCOUNT_NUMBER";

		String result = searcher.doSearch(userId, searchType);

		System.out.println(result);
	}
}
