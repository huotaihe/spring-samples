package com.github.huotaihe.springboot.learn.cache.redis.service;

import com.github.huotaihe.springboot.learn.cache.redis.entity.User;

public interface UserService {

  /**
   * 删除
   *
   * @param user 用户对象
   * @return 操作结果
   */
  User saveOrUpdate(User user);

  /**
   * 添加
   *
   * @param id key值
   * @return 返回结果
   */
  User get(Long id);

  /**
   * 删除
   *
   * @param id key值
   */
  void delete(Long id);
}
