package com.github.huotaihe.springboot.learn.groovy;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {

	@Autowired
	@Qualifier("FooImpl")
	private Foo foo;

	@Autowired
	@Qualifier("Foo2Impl")
	private Foo foo2;

	@Test
	public void contextLoads() {
	}

	@Test
	public void test() throws InterruptedException {
//		Assert.assertNull(foo);
		log.info(foo.execute());
		Thread.sleep(1000 * 10);
		log.info(foo.execute());
	}

	@Test
	public void test2() throws InterruptedException{
		log.info(foo2.execute());
	}

}
