package com.example.potato_serve.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.potato_serve.model.RoleDAO;
import com.example.potato_serve.model.RoleMenuRelationDAO;
import com.example.potato_serve.model.RoleUserRelationDAO;
import com.example.potato_serve.vo.req.RoleMenuRelationReqVO;
import com.example.potato_serve.vo.req.RoleReqVO;
import com.example.potato_serve.vo.req.RoleUserRelationReqVO;

import java.util.List;

public interface RoleService {

    IPage<RoleDAO> getList(RoleReqVO vo);

    RoleDAO findOne(String id);

    RoleDAO create(RoleDAO user);

    boolean update(RoleDAO user);

    boolean delete(String id);

    boolean bindMenu(RoleMenuRelationReqVO vo);

    boolean bindUser(RoleUserRelationReqVO vo);

    List<RoleDAO> findUserRole(int appId, String roleId);

    List<RoleUserRelationDAO> findUserRoleRelation(int appId, String userId);

    List<RoleMenuRelationDAO> findRoleMenuRelation(int appId, String roleId);

    List<RoleDAO> getAppRoleByAppId(int appId);
}
