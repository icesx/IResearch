package cn.taocheng.base.optional;

import java.util.Optional;

import org.apache.log4j.Logger;
import org.junit.Test;

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
