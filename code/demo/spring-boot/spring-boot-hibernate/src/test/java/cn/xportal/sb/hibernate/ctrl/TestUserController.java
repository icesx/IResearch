package cn.xportal.sb.hibernate.ctrl;

import java.util.ArrayList;
import java.util.Map;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xportal.sb.hibernate.entity.UserEntity;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestUserController {
	private static final Logger logger = LoggerFactory.getLogger(TestUserController.class);

	@Inject
	private TestRestTemplate restTemplate;

	@SuppressWarnings("unchecked")
	@Test
	public void testUsers() {
		ArrayList<Map<String, Object>> user = restTemplate.getForObject("/getUsers", ArrayList.class);
		for (Map<String, Object> map : user) {
			logger.info(map.toString());
		}
	}

	@Test
	public void testUser() {
		UserEntity user = restTemplate.getForObject("/getUser/30", UserEntity.class);
		logger.info(user.toString());
	}
}
