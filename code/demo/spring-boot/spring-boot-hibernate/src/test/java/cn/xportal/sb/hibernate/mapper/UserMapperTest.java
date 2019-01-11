package cn.xportal.sb.hibernate.mapper;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import cn.xportal.sb.hibernate.dao.UserDao;
import cn.xportal.sb.hibernate.entity.UserEntity;
import cn.xportal.sb.hibernate.entity.UserSexEnum;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {
	@Autowired
	private UserDao UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserMapper.save(new UserEntity("aa", "a123456", UserSexEnum.MAN));
		UserMapper.save(new UserEntity("bb", "b123456", UserSexEnum.WOMAN));
		UserMapper.save(new UserEntity("cc", "b123456", UserSexEnum.WOMAN));
		Assert.assertEquals(3, UserMapper.findAll());
	}

	@Test
	public void testQuery() throws Exception {
		Iterable<UserEntity> users = UserMapper.findAll();
		System.out.println(users.toString());
	}

	@Test
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.findById(3l).get();
		System.out.println(user.toString());
		user.setNickName("neo");
		UserMapper.save(user);
		Assert.assertTrue(("neo".equals(UserMapper.findById(3l).get().getNickName())));
	}

}