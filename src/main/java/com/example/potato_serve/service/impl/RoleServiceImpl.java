package com.example.potato_serve.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.potato_serve.mapper.RoleMapper;
import com.example.potato_serve.model.RoleDAO;
import com.example.potato_serve.model.RoleMenuRelationDAO;
import com.example.potato_serve.model.RoleUserRelationDAO;
import com.example.potato_serve.service.RoleMenuRelationService;
import com.example.potato_serve.service.RoleService;
import com.example.potato_serve.service.RoleUserRelationService;
import com.example.potato_serve.vo.req.RoleMenuRelationReqVO;
import com.example.potato_serve.vo.req.RoleReqVO;
import com.example.potato_serve.vo.req.RoleUserRelationReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class RoleServiceImpl implements RoleService  {

    @Resource
    private RoleMapper roleMapper;

    @Autowired
    private RoleMenuRelationService roleMenuRelationService;

    @Autowired
    private RoleUserRelationService roleUserRelationService;

    @Override
    public IPage<RoleDAO> getList(RoleReqVO vo) {
        QueryWrapper wrapper = new QueryWrapper();
        Page<RoleDAO> page = new Page<>(vo.getPageCurrent(),vo.getPageSize());
        wrapper.orderByDesc("create_time");

        if (!vo.getKeyword().isEmpty()) {
            wrapper.like("name", vo.getKeyword());
        }

        IPage<RoleDAO> pageData = roleMapper.selectPage(page, wrapper);
        return pageData;
    }

    @Override
    public RoleDAO findOne(String id) {
        return roleMapper.selectById(id);
    }

    @Override
    public RoleDAO create(RoleDAO role) {
        roleMapper.insert(role);
        return roleMapper.selectById(role.getRoleId());
    }

    @Override
    public boolean update(RoleDAO role) {
        UpdateWrapper wrapper = new UpdateWrapper();

        wrapper.eq("role_id", role.getRoleId());
        wrapper.set("app_id", role.getAppId());
        wrapper.set("name", role.getName());
        wrapper.set("remark", role.getRemark());
        wrapper.set("disabled", role.getDisabled());

        return roleMapper.update(null, wrapper) > 0;
    }

    @Override
    public boolean delete(String id) {
        return roleMapper.deleteById(id) > 0;
    }

    /**
     *  角色绑定菜单关系：1:N
     *  全量更新
     *  1.库没有，则新增
     *  2.库有，参数没有则删除
     *  3.库有，参数有，则不处理
     * @return
     * */
    @Override
    public boolean bindMenu(RoleMenuRelationReqVO vo) {
        int appId = vo.getAppId();
        String roleId = vo.getRoleId();
        List<String> menuIds = vo.getMenuIds();

        // 获取角色所有菜单
        List<RoleMenuRelationDAO> roleMenuList = findRoleMenuRelation(appId, roleId);
        List<String> allMenuIds = roleMenuList
                .stream()
                .map(a -> a.getMenuId())
                .collect(Collectors.toList());

        // 需要删除的菜单
        List<String> deleteList = allMenuIds
                .stream()
                .filter(a -> !menuIds.contains(a))
                .collect(Collectors.toList());

        // 需要新增的菜单
        System.out.print(allMenuIds);
        List<String> insertList = menuIds
                .stream()
                .filter(a -> !allMenuIds.contains(a))
                .collect(Collectors.toList());

        try {
            insertRoleMenu(appId, roleId, insertList);
            deleteRoleMenu(appId, roleId, deleteList);
        } catch(Exception e) {
            log.error(e.getMessage());
            return false;
        }
        
        return true;
    }

    /**
     *  角色绑定用户关系：N:1
     *  全量更新
     *  1.库没有，则新增
     *  2.库有，参数没有则删除
     *  3.库有，参数有，则不处理
     * @return*/
    @Override
    public boolean bindUser(RoleUserRelationReqVO vo) {
        int appId = vo.getAppId();
        String userId = vo.getUserId();
        List<String> roleIds = vo.getRoleIds();

        // 获取用户所有角色
        List<RoleUserRelationDAO> roleUserList = findUserRoleRelation(appId, userId);
        List<String> allRoleIds = roleUserList
                .stream()
                .map(a -> a.getRoleId())
                .collect(Collectors.toList());

        // 需要删除的角色
        List<String> deleteList = allRoleIds
                .stream()
                .filter(a -> !roleIds.contains(a))
                .collect(Collectors.toList());

        // 需要新增的角色
        List<String> insertList = roleIds
                .stream()
                .filter(a -> !allRoleIds.contains(a))
                .collect(Collectors.toList());

        try {
            insertRoleUser(appId, userId, insertList);
            deleteRoleUser(appId, userId, deleteList);
        } catch(Exception e) {
            log.error(e.getMessage());
            return false;
        }

        return true;
    }

    /**
     * 1.查找用户与角色的所有绑定关系表
     * 2.查找角色表数据
     * 3.返回所有角色列表
     * @param appId
     * @param userId
     * @return list
     * */
    @Override
    public List<RoleDAO> findUserRole(int appId, String userId) {
         return roleMapper.findUserRole(appId, userId);
    }

    /**
     * 查找用户所有角色 绑定的关系
     * @param appId
     * @param userId
     * @return List
     * */
    @Override
    public List<RoleUserRelationDAO> findUserRoleRelation(int appId, String userId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("app_id", appId);
        wrapper.eq("user_id", userId);

        return roleUserRelationService.list(wrapper);
    }

    /**
     * 查找角色所有菜单 绑定的关系
     * @param appId
     * @param roleId
     * @return List
     * */
    @Override
    public List<RoleMenuRelationDAO> findRoleMenuRelation(int appId, String roleId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("app_id", appId);
        wrapper.eq("role_id", roleId);

        return roleMenuRelationService.list(wrapper);
    }

    @Override
    public List<RoleDAO> getAppRoleByAppId(int appId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("app_id", appId);

        return roleMapper.selectList(wrapper);
    }

    public boolean insertRoleMenu(int appId, String roleId, List<String> list) {
        if (list.isEmpty()) {
            return false;
        }

        List<RoleMenuRelationDAO> insertList = list
                .stream()
                .map(a -> {
                    RoleMenuRelationDAO relation = new RoleMenuRelationDAO();
                    relation.setAppId(appId);
                    relation.setRoleId(roleId);
                    relation.setMenuId(a);
                    return relation;
                })
                .collect(Collectors.toList());

        return roleMenuRelationService.saveBatch(insertList);
    }

    public boolean deleteRoleMenu(int appId, String roleId, List<String> list) {
         if (list.isEmpty()) {
             return false;
         }

        QueryWrapper wrapper = new QueryWrapper();

        for (String menuId : list) {
            wrapper.eq("app_id", appId);
            wrapper.eq("role_id", roleId);
            wrapper.eq("menu_id", menuId);
            wrapper.or();
        }

        return roleMenuRelationService.remove(wrapper);
    }

    public boolean insertRoleUser(int appId, String userId, List<String> list) {
        if (list.isEmpty()) {
            return false;
        }

        List<RoleUserRelationDAO> insertList = list
                .stream()
                .map(a -> {
                    RoleUserRelationDAO relation = new RoleUserRelationDAO();
                    relation.setAppId(appId);
                    relation.setUserId(userId);
                    relation.setRoleId(a);
                    return relation;
                })
                .collect(Collectors.toList());

        return roleUserRelationService.saveBatch(insertList);
    }

    public boolean deleteRoleUser(int appId, String userId, List<String> list) {
        if (list.isEmpty()) {
            return false;
        }

        QueryWrapper wrapper = new QueryWrapper();

        for (String roleId : list) {
            wrapper.eq("app_id", appId);
            wrapper.eq("user_id", userId);
            wrapper.eq("role_id", roleId);
            wrapper.or();
        }

        return roleUserRelationService.remove(wrapper);
    }
}
