package com.example.potato_serve.model;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_role")
@ApiModel(value = "角色实体", description = "角色相关")
public class RoleDAO {
    @ApiModelProperty(value = "id")
    private int id;

    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "roleId")
    private String roleId;

    @ApiModelProperty(value = "应用id")
    private int appId;

    @ApiModelProperty(value = "名称", required = true, example= "名称")
    private String name;

    @ApiModelProperty(value = "是否禁用", required = true, example= "1")
    private Boolean disabled;

    @ApiModelProperty(value = "备注")
    private String remark;

    @TableLogic
    @JsonIgnore
    private byte deleted;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
