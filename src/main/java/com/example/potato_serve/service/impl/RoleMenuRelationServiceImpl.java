package com.example.potato_serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.potato_serve.mapper.RoleMenuRelationMapper;
import com.example.potato_serve.model.RoleMenuRelationDAO;
import com.example.potato_serve.service.RoleMenuRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleMenuRelationServiceImpl extends ServiceImpl<RoleMenuRelationMapper, RoleMenuRelationDAO> implements RoleMenuRelationService {
}
