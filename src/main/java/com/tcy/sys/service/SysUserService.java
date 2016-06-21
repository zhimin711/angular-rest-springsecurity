package com.tcy.sys.service;

import com.tcy.core.support.IHService;
import com.tcy.sys.entity.SysUser;

/**
 * Created by 80002023 on 2016/6/3.
 */
public interface SysUserService extends IHService<Long, SysUser> {
    SysUser findByUsername(String username);
}
