package cn.i.xportal.jdp.proxy.smartproxy;

public class AccessValidator {
	public boolean vaidateUser(String userId) {
		if (userId.equals("Admin")) {
			return true;
		} else {
			return false;
		}
	}
}
