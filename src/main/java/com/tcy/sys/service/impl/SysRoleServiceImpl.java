package com.tcy.sys.service.impl;

import com.tcy.core.http.result.PageResult;
import com.tcy.sys.entity.SysRole;
import com.tcy.sys.repository.SysRoleRepository;
import com.tcy.sys.service.SysRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Service
public class SysRoleServiceImpl implements SysRoleService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysRoleRepository sysRoleRepository;

    public SysRole saveOrUpdate(SysRole record) {
        logger.info("system role save or update.");
        return sysRoleRepository.save(record);
    }

    public List<SysRole> saveOrUpdate(List<SysRole> records) {
        return sysRoleRepository.save(records);
    }

    public SysRole find(Long id) {
        return sysRoleRepository.findOne(id);
    }

    @Override
    public List<SysRole> find(SysRole sysRole) {
        return null;
    }

    public void delete(Long id) {
        sysRoleRepository.delete(id);
    }

    public void delete(List<SysRole> records) {
        sysRoleRepository.delete(records);
    }

    public List<SysRole> findAll() {
        return sysRoleRepository.findAll();
    }

    @Override
    public PageResult<SysRole> findPage(SysRole record, int pageNum, int pageSize) {
        return null;
    }
}
