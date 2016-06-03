package com.tcy.sys.service.impl;

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
        return sysRoleRepository.save(record);
    }

    public List<SysRole> saveOrUpdate(List<SysRole> records) {
        return sysRoleRepository.save(records);
    }

    public SysRole find(Long id) {
        return sysRoleRepository.findOne(id);
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
}
