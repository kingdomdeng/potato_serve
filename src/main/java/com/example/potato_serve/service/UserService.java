package com.example.potato_serve.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.potato_serve.model.UserDAO;
import com.example.potato_serve.vo.req.UserReqVO;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public interface UserService {

    IPage<UserDAO> getList(UserReqVO vo);

    UserDAO findOne(String id);

    UserDAO create(UserDAO user);

    boolean update(UserDAO user);

    boolean delete(String id);

    void download(HttpServletResponse response) throws IOException;
}
