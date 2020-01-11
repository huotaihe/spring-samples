package com.github.huotaihe.springboot.learn.swagger2.controller;

import com.battcn.swagger.properties.ApiDataType;
import com.battcn.swagger.properties.ApiParamType;
import com.github.huotaihe.springboot.learn.swagger2.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.apachecommons.CommonsLog;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Api(tags = "1.1", description = "用户管理", value = "用户管理")
@CommonsLog
public class UserController {

  @GetMapping
  @ApiOperation(value = "条件查询（DONE）")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "username", value = "用户名", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
      @ApiImplicitParam(name = "password", value = "密码", dataType = ApiDataType.STRING, paramType = ApiParamType.QUERY),
  })
  public User query(String username, String password) {
    log.info("多个参数用  @ApiImplicitParams");
    return new User(1L, username, password);
  }

  @GetMapping("/{id}")
  @ApiOperation(value = "主键查询（DONE）")
  @ApiImplicitParams({
      @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH),
  })
  public User get(@PathVariable Long id) {
    log.info("单个参数用  @ApiImplicitParam");
    return new User(id, "u1", "p1");
  }

  @DeleteMapping("/{id}")
  @ApiOperation(value = "删除用户（DONE）")
  @ApiImplicitParam(name = "id", value = "用户编号", dataType = ApiDataType.LONG, paramType = ApiParamType.PATH)
  public void delete(@PathVariable Long id) {
    log.info("单个参数用 ApiImplicitParam");
  }

  @PostMapping
  @ApiOperation(value = "添加用户（DONE）")
  public User post(@RequestBody User user) {
    log.info("如果是 POST PUT 这种带 @RequestBody 的可以不用写 @ApiImplicitParam");
    return user;
  }

  @PutMapping("/{id}")
  @ApiOperation(value = "修改用户（DONE）")
  public void put(@PathVariable Long id, @RequestBody User user) {
    log.info("如果你不想写 @ApiImplicitParam 那么 swagger 也会使用默认的参数名作为描述信息 ");
  }
}
