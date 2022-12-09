package com.example.potato_serve.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
@ApiModel(value = "用户角色绑定请求参数")
public class RoleUserRelationReqVO {

    @NotNull(message = "请输入appId")
    @ApiModelProperty(value = "appId", required = true, example= "1")
    private int appId;

    @NotNull(message = "请输入roleIds")
    @ApiModelProperty(value = "roleIds", required = true, example= "[1,2,3]")
    private List<String> roleIds;

    @NotBlank(message = "userId不能为空")
    @ApiModelProperty(value = "菜单id数组", required = true, example="1")
    private String userId;
}
