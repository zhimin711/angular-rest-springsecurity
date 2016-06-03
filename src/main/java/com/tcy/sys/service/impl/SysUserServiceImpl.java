package com.tcy.sys.service.impl;

import com.tcy.sys.entity.SysRole;
import com.tcy.sys.entity.SysUser;
import com.tcy.sys.repository.SysUserRepository;
import com.tcy.sys.service.SysUserService;
import com.tcy.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private SysUserRepository sysUserRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public SysUser saveOrUpdate(SysUser record) {
        Assert.notNull(record);
        if (record.getId() == null) {
            if (record.getPassword() == null) {
                record.setPassword(PasswordUtils.generator());
            }
            record.setPassword(passwordEncoder.encode(record.getPassword()));
        } else {
            record.setPassword(null);
        }
        logger.info("user save or update password: {}", record.getPassword());
        return sysUserRepository.save(record);
    }

    public List<SysUser> saveOrUpdate(List<SysUser> records) {
        return sysUserRepository.save(records);
    }

    public SysUser find(Long id) {
        return sysUserRepository.findOne(id);
    }

    public void delete(Long id) {
        sysUserRepository.delete(id);
    }

    public void delete(List<SysUser> records) {
        sysUserRepository.delete(records);
    }

    public List<SysUser> findAll() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser findByUsername(String username) {
        SysUser record = sysUserRepository.findByUsername(username);
        if (record != null) {
            Set<SysRole> roleList = record.getRoles();
            record.setRoles(roleList);
            return record;
        }
        return null;
    }
}
