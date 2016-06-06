
import com.tcy.app.result.PageResult;
import com.tcy.sys.entity.SysRole;
import com.tcy.sys.entity.SysUser;
import com.tcy.sys.service.SysRoleService;
import com.tcy.sys.service.SysUserService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@ContextConfiguration(locations = {"classpath:context.xml"})
public class Junit_sys extends AbstractJUnit4SpringContextTests{

    PageResult<?> result;
    @Test
    public void run(){
        this.initData();
    }

    public void initData(){
        SysUser record = new SysUser();
        record.setUsername("admin");
        record.setRealname("admin");
       // record.setEnabled(true);
        Set<SysRole> roles = new HashSet<SysRole>();
        SysRole role =new SysRole();
        role.setName("系统管理员");
        role.setKey("SYS_ADMIN");
        role.setEnabled(true);
        role.setSys(true);
        roles.add(role);
        //record.setRoles(roles);
        //sysUserService.saveOrUpdate(record);

        //sysRoleService.saveOrUpdate(role);
        result= sysUserService.findPage(record,0,10);
        System.out.println("");
    }

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserService sysUserService;

}
