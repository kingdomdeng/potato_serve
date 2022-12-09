package com.example.potato_serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.potato_serve.model.MenuDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenuMapper extends BaseMapper<MenuDAO> {

    @Select({
            "SELECT * FROM sys_menu"
    })
    List<MenuDAO> getAllMenu();

    @Select({
            "SELECT * FROM sys_menu WHERE menu_id IN ( ",
                "SELECT DISTINCT menu_id FROM sys_role_menu_relation WHERE role_id IN (",
                    "SELECT DISTINCT role_id FROM sys_role_user_relation WHERE",
                    "app_id=#{ appId } AND user_id=#{ userId } ))",
    })
    List<MenuDAO> findUserMenu(int appId, String userId);

    @Select({
            "<script>",
            "SELECT * FROM sys_menu WHERE menu_id IN ( ",
                "SELECT DISTINCT menu_id FROM sys_role_menu_relation WHERE",
                "<foreach item='roleId' collection='roleIdList' separator='OR'>",
                    "app_id=#{ appId } AND role_id=#{ roleId } ",
                "</foreach>)",
            "</script>"
    })
    List<MenuDAO> findRoleMenu(int appId, List<String> roleIdList);
}
