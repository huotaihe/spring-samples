package com.github.huotaihe.spring.boot.mybatis;

import com.github.huotaihe.spring.boot.mybatis.entity.User;
import com.github.huotaihe.spring.boot.mybatis.mapper.UserMapper;
import java.io.Serializable;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMybatisApplicationTests implements Serializable {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private UserMapper userMapper;

	@Test
	@Rollback
	public void findByName() throws Exception {
		userMapper.insert("AAA", 20);
		User u = userMapper.findByName("AAA");
		Assert.assertEquals(20, u.getAge().intValue());
	}

	@Test
	@Rollback
	public void updateByName() throws Exception {
		userMapper.update("AAA", 18);
	}

}
