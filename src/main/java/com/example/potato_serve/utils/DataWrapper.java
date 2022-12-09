package com.example.potato_serve.utils;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.potato_serve.config.ResCodeEnum;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class DataWrapper<T> {
    private int code = 0;

    private String message;

    private T data;

    public DataWrapper() {
        this.code = ResCodeEnum.SUCCESS.getCode();
        this.message = ResCodeEnum.SUCCESS.getMsg();
    }

    public void setError(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setWarning(int code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public void setPageResult(IPage<T> pageResult) {
        Map<String, Object> result = new HashMap<>();
        Map<String, Long> page = new HashMap<>();

        page.put("pageCurrent", pageResult.getCurrent());
        page.put("pageSize", pageResult.getSize());
        page.put("total", pageResult.getTotal());

        result.put("page", page);
        result.put("list", pageResult.getRecords());

        this.code = ResCodeEnum.SUCCESS.getCode();
        this.message = ResCodeEnum.SUCCESS.getMsg();

        this.data = (T) result;
    }
}
