package com.tcy.sys.service.impl;

import com.tcy.core.http.result.PageResult;
import com.tcy.core.utils.CommonUtils;
import com.tcy.sys.entity.SysRole;
import com.tcy.sys.entity.SysUser;
import com.tcy.sys.repository.SysUserRepository;
import com.tcy.sys.service.SysUserService;
import com.tcy.core.utils.PasswordUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

    public SysUser saveOrUpdate(SysUser record) {
        Assert.notNull(record);
        if (CommonUtils.isNotEmpty(record.getId())) {
            SysUser user = this.find(record.getId());
            if (user != null) {
                if (CommonUtils.isNotEmpty(record.getPassword())) {
                    user.setPassword(PasswordUtils.encryptPassword(record.getPassword()));
                }
                if (CommonUtils.isNotEmpty(record.getName())) {
                    user.setName(record.getName());
                }
                if (CommonUtils.isNotEmpty(record.getExpires())) {
                    user.setExpires(record.getExpires());
                }
                if (CommonUtils.isNotEmpty(record.getEnabled())) {
                    user.setEnabled(record.getEnabled());
                }
                if (CommonUtils.isNotEmpty(record.getRoles())) {
                    user.setRoles(record.getRoles());
                }
                if (CommonUtils.isNotEmpty(record.getUpdator())) {
                    user.setUpdator(record.getUpdator());
                }
                if (CommonUtils.isNotEmpty(record.getUpdateAt())) {
                    user.setUpdateAt(record.getUpdateAt());
                }

                record = user;
            }
        } else {
            if (record.getPassword() == null) {
                record.setPassword(PasswordUtils.encryptPassword(PasswordUtils.generate()));
            }
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

    @Override
    public List<SysUser> find(SysUser sysUser) {
        return null;
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
    public PageResult<SysUser> findPage(SysUser record, int pageNum, int pageSize) {
        if (record == null) {
            record = new SysUser();
        }
        Example<SysUser> example = Example.of(record);
        Pageable pageable = new PageRequest(pageNum, pageSize);
        Page<SysUser> page = sysUserRepository.findAll(example, pageable);

        PageResult<SysUser> result = new PageResult<SysUser>(page, pageNum, pageSize);
        return result;
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
