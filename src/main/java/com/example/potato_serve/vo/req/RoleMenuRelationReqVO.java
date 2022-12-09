package com.example.potato_serve.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "菜单角色绑定请求参数")
public class RoleMenuRelationReqVO {

    @NotNull(message = "请输入appId")
    @ApiModelProperty(value = "appId", required = true, example= "1")
    private int appId;

    @NotBlank(message = "请输入roleId")
    @ApiModelProperty(value = "roleId", required = true, example= "1")
    private String roleId;

    @NotNull(message = "menuIds不能为空")
    @ApiModelProperty(value = "菜单id数组", required = true, example="[123,24]")
    private List<String> menuIds;
}
