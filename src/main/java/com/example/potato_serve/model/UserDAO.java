package com.example.potato_serve.model;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
@TableName("sys_user")
@ApiModel(value = "用户实体", description = "用户相关")
@ColumnWidth(20)
public class UserDAO {
    @ApiModelProperty(value = "id")
    @ExcelIgnore
    private int id;

    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "userId")
    @ExcelProperty("userId")
    private String userId;

    @ApiModelProperty(value = "应用id")
    @ExcelProperty("应用id")
    private int appId;

    @ApiModelProperty(value = "名称", required = true, example= "名称")
    @ExcelProperty("名称")
    private String name;

    @ApiModelProperty(value = "是否禁用", required = true, example= "1")
    @ExcelProperty("是否禁用")
    private Boolean disabled;

    @ApiModelProperty(value = "备注")
    @ExcelProperty("备注")
    private String remark;

//    @TableField(exist = false)
//    private String remark2 = "122345";

    @TableLogic
    @JsonIgnore
    @ExcelIgnore
    private byte deleted;

    @ApiModelProperty(value = "创建时间")
    @ExcelProperty("创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    @ExcelProperty("更新时间")
    private Date updateTime;
}
