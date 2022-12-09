package com.example.potato_serve.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.potato_serve.mapper.MenuMapper;
import com.example.potato_serve.model.MenuDAO;
import com.example.potato_serve.service.MenuService;
import com.example.potato_serve.utils.RedisUtil;
import com.example.potato_serve.vo.req.MenuReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class MenuServiceImpl implements MenuService {

    @Resource
    private MenuMapper menuMapper;

    @Resource
    private RedisUtil redisUtil;

    @PostConstruct
    public void initClass() {
        // @PostConstruct 是在对象构造完成，并且属性赋值完成后，调用 init-method 之前执行的。
        System.out.println("### init");
        System.out.println(redisUtil.name);
    }

    @Override
    public IPage<MenuDAO> getList(MenuReqVO vo) {
        QueryWrapper wrapper = new QueryWrapper();
        Page<MenuDAO> page = new Page<>(vo.getPageCurrent(),vo.getPageSize());
        wrapper.orderByDesc("create_time");

        if (!vo.getKeyword().isEmpty()) {
            wrapper.like("name", vo.getKeyword());
        }

        IPage<MenuDAO> pageData = menuMapper.selectPage(page, wrapper);
        return pageData;
    }

    @Override
    public MenuDAO findOne(String id) {
        return menuMapper.selectById(id);
    }

    @Override
    public MenuDAO create(MenuDAO menu) {
        int num = menuMapper.insert(menu);
        return menuMapper.selectById(menu.getMenuId());
    }

    @Override
    public boolean update(MenuDAO menu) {
        UpdateWrapper wrapper = new UpdateWrapper();

        wrapper.eq("menu_id", menu.getMenuId());
        wrapper.set("app_id", menu.getAppId());
        wrapper.set("parent_id", menu.getParentId());
        wrapper.set("name", menu.getName());
        wrapper.set("remark", menu.getRemark());
        wrapper.set("icon", menu.getIcon());
        wrapper.set("url", menu.getUrl());
        wrapper.set("disabled", menu.getDisabled());

        return menuMapper.update(null, wrapper) > 0;
    }

    @Override
    public boolean delete(String id) {
        return menuMapper.deleteById(id) > 0;
    }

    /**
     * 获取用户所有菜单权限
     *
     * 1.查找用户所有角色
     * 2.查找角色的菜单权限
     * 3.返回用户所有角色菜单
     * @param appId
     * @param userId
     * @return list
     * */
    @Override
    public List<MenuDAO> findUserMenu(int appId, String userId) {
        return menuMapper.findUserMenu(appId, userId);
    }

    /**
     * 获取角色所有菜单权限
     *
     * 1.查找角色与菜单的绑定关系
     * 2.查找所有关系菜单权限
     * 3.返回菜单
     * @param appId
     * @param roleIds
     * @return list
     * */
    @Override
    public List<MenuDAO> findRoleMenu(int appId, String roleIds) {
        List<String> roleIdList = Arrays.asList(roleIds.split(","));
        return menuMapper.findRoleMenu(appId, roleIdList);
    }

    @Override
    public List<MenuDAO> getAppMenuByAppId(int appId) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("app_id", appId);

        return menuMapper.selectList(wrapper);
    }

    @Override
    public void download(HttpServletResponse response) throws IOException {
        String fileName = URLEncoder.encode("菜单权限", "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<MenuDAO> data = menuMapper.getAllMenu();

        EasyExcel.write(response.getOutputStream(), MenuDAO.class).sheet().doWrite(data);
    }

    @Override
    public Boolean redisSet(Map<String, Object> json) {
        return redisUtil.setMap(json.get("key"), (Map<String, Object>) json.get("value"));
    }

    @Override
    public Map<String, Object> redisGet(String key) {
        return redisUtil.geMap(key);
    }
}
