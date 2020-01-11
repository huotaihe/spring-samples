package com.github.huotaihe.springboot.learn.cache.redis.service.impl;

import com.github.huotaihe.springboot.learn.cache.redis.entity.User;
import com.github.huotaihe.springboot.learn.cache.redis.service.UserService;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

  private static final Map<Long, User> DATABASES = new HashMap<>();

  static {
    DATABASES.put(1L, new User(1L, "u1", "p1"));
    DATABASES.put(2L, new User(2L, "u2", "p2"));
    DATABASES.put(3L, new User(3L, "u3", "p3"));
  }



  @Cacheable(value = "user", key = "#id")
  @Override
  public User get(Long id) {
    // TODO 我们就假设它是从数据库读取出来的
    log.info("进入 get 方法");
    return DATABASES.get(id);
  }

  @CachePut(value = "user", key = "#user.id")
  @Override
  public User saveOrUpdate(User user) {
    DATABASES.put(user.getId(), user);
    log.info("进入 saveOrUpdate 方法");
    return user;
  }

  @CacheEvict(value = "user", key = "#id")
  @Override
  public void delete(Long id) {
    DATABASES.remove(id);
    log.info("进入 delete 方法");
  }
}
