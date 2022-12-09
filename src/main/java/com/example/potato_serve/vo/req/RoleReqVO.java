package com.example.potato_serve.vo.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "角色请求参数")
public class RoleReqVO {

    //    @NotBlank(message = "请输入pageCurrent")
    @ApiModelProperty(value = "pageCurrent", required = true, example= "1")
    private int pageCurrent = 1;

    //    @NotBlank(message = "请输入pageSize")
    @ApiModelProperty(value = "pageSize", required = true, example= "10")
    private int pageSize = 10;

    //    @NotBlank(message = "请输入keyword")
    @ApiModelProperty(value = "关键字", required = true, example="")
    private String keyword;
}
