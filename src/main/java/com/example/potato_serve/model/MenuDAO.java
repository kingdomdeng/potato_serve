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
@TableName("sys_menu")
@ApiModel(value = "菜单实体", description = "菜单相关")
@ColumnWidth(20)
public class MenuDAO {
    @ApiModelProperty(value = "id")
    private int id;

    @TableId(type = IdType.ASSIGN_UUID)
    @ApiModelProperty(value = "menuId")
    @ExcelProperty("menuId")
    private String menuId;

    @ApiModelProperty(value = "应用id")
    @ExcelProperty("应用id")
    private int appId;

    @ApiModelProperty(value = "名称", required = true, example= "名称")
    @ExcelProperty("名称")
    private String name;

    @ApiModelProperty(value = "父级菜单id")
    @ExcelIgnore
    private String parentId = "";

    @ApiModelProperty(value = "图标")
    private String icon;

    @ApiModelProperty(value = "路由", required = true, example= "")
    private String url;

    @ApiModelProperty(value = "是否禁用", required = true, example= "1")
    private Boolean disabled;

    @ApiModelProperty(value = "备注")
    private String remark;

    @TableLogic
    @JsonIgnore
    private byte deleted;

//    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
