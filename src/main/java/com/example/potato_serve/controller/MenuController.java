package com.example.potato_serve.controller;

import com.example.potato_serve.model.MenuDAO;
import com.example.potato_serve.service.MenuService;
import com.example.potato_serve.utils.DataWrapper;
import com.example.potato_serve.vo.req.MenuReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("menu")
@Api(value = "菜单", tags = "menu 菜单模块")
public class MenuController {

    @Resource
    private MenuService menuService;

    @PostMapping("")
    @ApiOperation(value = "获取菜单列表", notes = "")
    public DataWrapper list(@RequestBody @Validated MenuReqVO vo) {
        DataWrapper result = new DataWrapper();
        result.setPageResult(menuService.getList(vo));
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个菜单详情", notes = "详情")
    public MenuDAO findOne(@PathVariable String id) {
        return menuService.findOne(id);
    }

    @PostMapping("create")
    @ApiOperation(value = "菜单创建", notes = "创建")
    public MenuDAO create(@RequestBody MenuDAO user) {
        return menuService.create(user);
    }

    @PutMapping("update")
    @ApiOperation(value = "菜单更新", notes = "")
    public boolean update(@RequestBody MenuDAO user) {
        return menuService.update(user);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "菜单删除", notes = "")
    public boolean delete(@PathVariable String id) {
        return menuService.delete(id);
    }

    @GetMapping("findUserMenu")
    @ApiOperation(value = "获取用户所有菜单权限", notes = "")
    public List<MenuDAO> findUserMenu(
            @RequestParam(name = "appId") int appId,
            @RequestParam(name = "userId") String userId
    ) {
        return menuService.findUserMenu(appId, userId);
    }

    @GetMapping("findRoleMenu")
    @ApiOperation(value = "获取角色所有菜单权限", notes = "")
    public List<MenuDAO> findRoleMenu(
            @RequestParam(name = "appId") int appId,
            @RequestParam(name = "roleIds") String roleIds
    ) {
        return menuService.findRoleMenu(appId, roleIds);
    }

    @GetMapping("getAppMenuByAppId")
    @ApiOperation(value = "获取应用所有菜单", notes = "")
    public List<MenuDAO> getAppMenuByAppId(
            @RequestParam(name = "appId") int appId
    ) {
        return menuService.getAppMenuByAppId(appId);
    }

    @GetMapping("download")
    @ApiOperation(value = "下载excel", notes = "")
    public void download(HttpServletResponse response) throws IOException {
        menuService.download(response);
    }

    @PostMapping("redis/set")
    @ApiOperation(value = "保存到redis", notes = "")
    public Boolean download(@RequestBody Map<String, Object> json) {
        return menuService.redisSet(json);
    }

    @GetMapping("redis/get")
    @ApiOperation(value = "从redis获取", notes = "")
    public Map<String, Object> download(@RequestParam(name = "key") String key) {
        return menuService.redisGet(key);
    }
}
