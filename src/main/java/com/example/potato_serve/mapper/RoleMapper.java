package com.example.potato_serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.potato_serve.model.RoleDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoleMapper extends BaseMapper<RoleDAO> {

    @Select({
            "SELECT * FROM sys_role WHERE role_id IN (",
                "SELECT DISTINCT role_id FROM sys_role_user_relation WHERE ",
                "app_id=#{ appId } AND user_id=#{ userId } )",
    })
    List<RoleDAO> findUserRole(int appId, String userId);
}
