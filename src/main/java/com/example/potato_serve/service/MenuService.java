package com.example.potato_serve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.potato_serve.model.MenuDAO;
import com.example.potato_serve.vo.req.MenuReqVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface MenuService {

    IPage<MenuDAO> getList(MenuReqVO vo);

    MenuDAO findOne(String id);

    MenuDAO create(MenuDAO user);

    boolean update(MenuDAO user);

    boolean delete(String id);

    List<MenuDAO> findUserMenu(int appId, String userId);

    List<MenuDAO> findRoleMenu(int appId, String roleIds);

    List<MenuDAO> getAppMenuByAppId(int appId);

    void download(HttpServletResponse response) throws IOException;

    Boolean redisSet(Map<String, Object> json);

    Map<String, Object> redisGet(String key);
}
