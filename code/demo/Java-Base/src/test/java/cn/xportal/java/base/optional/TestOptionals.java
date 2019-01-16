package cn.xportal.java.base.optional;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.Test;

import cn.xportal.java.optional.OptionalS;
import cn.xportal.java.optional.UserEntity;

public class TestOptionals {
	private Logger logger = Logger.getLogger(TestOptionals.class);

	@Test
	public void testOptionals() {
		logger.info(OptionalS.getChampionName(new UserEntity().setUserName("x")));
	}

	@Test
	public void testOptions2() {
		logger.info(Optional.of("S").map(this::min).orElse("x"));
	}

	public String min(String m) {
		return m.toLowerCase();
	}
}
