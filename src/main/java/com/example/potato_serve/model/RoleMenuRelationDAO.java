package com.example.potato_serve.model;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role_menu_relation")
public class RoleMenuRelationDAO {
    @TableId
    private int id;

    private int appId;

    private String roleId;

    private String menuId;

//    @TableLogic
    @JsonIgnore
    private byte deleted;

    private Date createTime;

    private Date updateTime;
}
