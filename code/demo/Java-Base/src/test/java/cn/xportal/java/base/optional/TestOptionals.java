package cn.xportal.java.base.optional;

import org.junit.Test;

import cn.xportal.java.optional.OptionalS;
import cn.xportal.java.optional.UserEntity;

public class TestOptionals {

	@Test
	public void testOptionals() {
		System.out.println(OptionalS.getChampionName(new UserEntity().setUserName("x")));
	}
}
