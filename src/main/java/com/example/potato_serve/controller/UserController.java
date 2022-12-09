package com.example.potato_serve.controller;

import com.example.potato_serve.model.UserDAO;
import com.example.potato_serve.utils.DataWrapper;
import com.example.potato_serve.service.UserService;
import com.example.potato_serve.vo.req.UserReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
@RestController
@RequestMapping("user")
@Api(value = "用户", tags = "user 用户模块")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping("")
    @ApiOperation(value = "获取用户列表", notes = "")
    public DataWrapper list(@RequestBody @Validated UserReqVO vo) {
        DataWrapper result = new DataWrapper();
        result.setPageResult(userService.getList(vo));
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个用户详情", notes = "详情")
    public UserDAO findOne(@PathVariable String id) {
        return userService.findOne(id);
    }

    @PostMapping("create")
    @ApiOperation(value = "用户创建", notes = "创建")
    public UserDAO create(@RequestBody UserDAO user) {
        return userService.create(user);
    }

    @PutMapping("update")
    @ApiOperation(value = "用户更新", notes = "")
    public boolean update(@RequestBody UserDAO user) {
        return userService.update(user);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "用户删除", notes = "")
    public boolean delete(@PathVariable String id) {
        return userService.delete(id);
    }

    @GetMapping("download")
    @ApiOperation(value = "下载excel", notes = "")
    public void download(HttpServletResponse response) throws IOException {
        userService.download(response);
    }
}
