package com.example.potato_serve.controller;

import com.example.potato_serve.model.RoleDAO;
import com.example.potato_serve.service.RoleService;
import com.example.potato_serve.utils.DataWrapper;
import com.example.potato_serve.vo.req.RoleMenuRelationReqVO;
import com.example.potato_serve.vo.req.RoleReqVO;
import com.example.potato_serve.vo.req.RoleUserRelationReqVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("role")
@Api(value = "角色", tags = "role 角色模块")
public class RoleController {

    @Resource
    private RoleService roleService;

    @PostMapping("")
    @ApiOperation(value = "获取角色列表", notes = "")
    public DataWrapper list(@RequestBody @Validated RoleReqVO vo) {
        DataWrapper result = new DataWrapper();
        result.setPageResult(roleService.getList(vo));
        return result;
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取单个角色详情", notes = "详情")
    public RoleDAO findOne(@PathVariable String id) {
        return roleService.findOne(id);
    }

    @PostMapping("create")
    @ApiOperation(value = "角色创建", notes = "创建")
    public RoleDAO create(@RequestBody RoleDAO user) {
        return roleService.create(user);
    }

    @PutMapping("update")
    @ApiOperation(value = "角色更新", notes = "")
    public boolean update(@RequestBody RoleDAO user) {
        return roleService.update(user);
    }

    @DeleteMapping("delete/{id}")
    @ApiOperation(value = "角色删除", notes = "")
    public boolean delete(@PathVariable String id) {
        return roleService.delete(id);
    }

    @PostMapping("bindMenu")
    @ApiOperation(value = "角色绑定菜单关系", notes = "")
    public void bindMenu(@RequestBody RoleMenuRelationReqVO vo) {
        roleService.bindMenu(vo);
    }

    @PostMapping("bindUser")
    @ApiOperation(value = "角色绑定用户关系", notes = "")
    public void bindMenu(@RequestBody RoleUserRelationReqVO vo) {
        roleService.bindUser(vo);
    }

    @GetMapping("findUserRole")
    @ApiOperation(value = "根据用户id查找用户所有角色", notes = "")
    public List<RoleDAO> findUserMenu(
            @RequestParam(name = "appId") int appId,
            @RequestParam(name = "userId") String userId
    ) {
        return roleService.findUserRole(appId, userId);
    }

    @GetMapping("getAppRoleByAppId")
    @ApiOperation(value = "查找应用id所有角色", notes = "")
    public List<RoleDAO> getAppRoleByAppId(
            @RequestParam(name = "appId") int appId
    ) {
        return roleService.getAppRoleByAppId(appId);
    }
}
