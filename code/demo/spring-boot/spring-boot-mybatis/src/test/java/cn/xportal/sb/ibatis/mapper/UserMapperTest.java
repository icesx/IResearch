package cn.xportal.sb.ibatis.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xportal.sb.ibatis.entity.UserEntity;
import cn.xportal.sb.ibatis.enums.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	private static final Logger logger = LoggerFactory.getLogger(UserMapperTest.class);

	@Autowired
	private UserMapper UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.insert(new UserEntity(1, "aa", "a123456", UserSexEnum.MAN));
		UserMapper.insert(new UserEntity(2, "bb", "b123456", UserSexEnum.WOMAN));
		UserMapper.insert(new UserEntity(3, "cc", "b123456", UserSexEnum.WOMAN));
		Assert.assertEquals(3, UserMapper.getAll().size());
	}

	@Test
	public void testQuery() throws Exception {
		UserMapper.getAll().forEach(u -> logger.info(u.toString()));
	}

	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.getOne(3l);
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.update(user);
		Assert.assertTrue(("neo".equals(UserMapper.getOne(3l).getNickName())));
	}

}