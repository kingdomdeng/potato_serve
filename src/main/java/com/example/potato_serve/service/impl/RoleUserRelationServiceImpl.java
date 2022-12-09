package com.example.potato_serve.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.potato_serve.mapper.RoleUserRelationMapper;
import com.example.potato_serve.model.RoleUserRelationDAO;
import com.example.potato_serve.service.RoleUserRelationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoleUserRelationServiceImpl extends ServiceImpl<RoleUserRelationMapper, RoleUserRelationDAO> implements RoleUserRelationService {
}
