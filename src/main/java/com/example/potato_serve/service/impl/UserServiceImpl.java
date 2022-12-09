package com.example.potato_serve.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.potato_serve.mapper.UserMapper;
import com.example.potato_serve.model.UserDAO;
import com.example.potato_serve.service.UserService;
import com.example.potato_serve.vo.req.UserReqVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public IPage<UserDAO> getList(UserReqVO vo) {
        QueryWrapper wrapper = new QueryWrapper();
        Page<UserDAO> page = new Page<>(vo.getPageCurrent(),vo.getPageSize());
        wrapper.orderByDesc("create_time");

        if (!vo.getKeyword().isEmpty()) {
            wrapper.like("name", vo.getKeyword());
        }

        IPage<UserDAO> pageData = userMapper.selectPage(page, wrapper);
        return pageData;
    }

    @Override
    public UserDAO findOne(String id) {
        return userMapper.findOne(id);
    }

    @Override
    public UserDAO create(UserDAO user) {
        userMapper.create(user);
        return userMapper.findOne(user.getUserId());
    }

    @Override
    public boolean update(UserDAO user) {
        UserDAO userInfo = new UserDAO();

        userInfo.setAppId(user.getAppId());
        userInfo.setUserId(user.getUserId());
        userInfo.setName(user.getName());
        userInfo.setDisabled(user.getDisabled());
        userInfo.setRemark(user.getRemark());

        return userMapper.update(userInfo);
    }

    @Override
    public boolean delete(String id) {
        return userMapper.delete(id);
    }

    @Override
    public void download(HttpServletResponse response) throws IOException {
        String fileName = URLEncoder.encode("平台用户", "UTF-8");
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        List<UserDAO> data = userMapper.getList();

        EasyExcel.write(response.getOutputStream(), UserDAO.class).sheet().doWrite(data);
    }
}
