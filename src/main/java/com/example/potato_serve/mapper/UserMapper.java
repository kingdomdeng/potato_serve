package com.example.potato_serve.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.potato_serve.model.UserDAO;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<UserDAO> {

    @Select("SELECT * FROM sys_user")
    /*@Results({
        @Result(property = "id", column = "id"),
        @Result(property = "name", column = "name"),
        @Result(property = "disabled", column = "disabled"),
        @Result(property = "remark", column = "remark"),
    })*/
    List<UserDAO> getList();

    @Select("SELECT * FROM sys_user WHERE user_id = #{id}")
    UserDAO findOne(String id);

    @Insert({
            "INSERT INTO sys_user",
            "(app_id, user_id, name, disabled, remark) VALUES ",
            "(#{appId}, #{userId}, #{name}, #{disabled}, #{remark})"
    })
    @Options(keyProperty = "id", useGeneratedKeys = true)
    void create(UserDAO user);

    @Insert({
            "UPDATE sys_user SET",
            "app_id = #{appId},",
            "name = #{name},",
            "disabled = #{disabled},",
            "remark = #{remark}",
            "WHERE user_id = #{userId}"
    })
    boolean update(UserDAO user);

    @Insert("DELETE FROM sys_user WHERE user_id = #{id}")
    boolean delete(String id);
}
