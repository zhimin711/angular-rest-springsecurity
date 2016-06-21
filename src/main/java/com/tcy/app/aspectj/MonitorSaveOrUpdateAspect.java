package com.tcy.app.aspectj;

import com.tcy.core.base.BaseEntity;
import com.tcy.core.base.LongPKEntity;
import com.tcy.core.base.StringPKEntity;
import com.tcy.core.utils.CommonUtils;
import com.tcy.core.utils.DateUtils;
import com.tcy.security.SecurityUtils;
import com.tcy.sys.entity.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by 80002023 on 2016/6/21.
 */
@Aspect
public class MonitorSaveOrUpdateAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Before("execution(* com.tcy..service..save*(..))")
    public void doBefore(JoinPoint joinPoint) throws Exception {
        logger.info("save or update record aspect");
        SysUser user = SecurityUtils.currentUser();
        if (user == null) {
            user = new SysUser();
            user.setId(-1L);
        }
        Object[] objects = joinPoint.getArgs();
        if (objects[0] instanceof LongPKEntity) {
            logger.info("save LongPKEntity");
            if (CommonUtils.isNotEmpty(((LongPKEntity) objects[0]).getId())) {
                ((LongPKEntity) objects[0]).setUpdator(user.getId());
                ((LongPKEntity) objects[0]).setUpdateAt(DateUtils.currentTime());
            } else {
                ((LongPKEntity) objects[0]).setCreator(user.getId());
//            ((LongPKEntity) objects[0]).setCreateAt(DateUtils.currentTime());
            }
        } else if (objects[0] instanceof StringPKEntity) {
            logger.info("save StringPKEntity");
            if (CommonUtils.isNotEmpty(((StringPKEntity) objects[0]).getId())) {
                ((StringPKEntity) objects[0]).setUpdator(user.getId());
                ((StringPKEntity) objects[0]).setUpdateAt(DateUtils.currentTime());
            } else {
                ((StringPKEntity) objects[0]).setCreator(user.getId());
//            ((StringPKEntity) objects[0]).setCreateAt(DateUtils.currentTime());
            }
        } else if (objects[0] instanceof BaseEntity) {
            logger.info("save BaseEntity");
            ((BaseEntity) objects[0]).setCreator(user.getCreator());
        }
    }
}
