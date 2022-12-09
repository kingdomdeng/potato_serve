package com.example.potato_serve.model;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role_user_relation")
public class RoleUserRelationDAO {
    private int id;

    private int appId;

    private String roleId;

    private String userId;

//    @TableLogic
    @JsonIgnore
    private byte deleted;

    private Date createTime;

    private Date updateTime;
}
