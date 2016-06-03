
import com.tcy.sys.entity.SysRole;
import com.tcy.sys.entity.SysUser;
import com.tcy.sys.service.SysRoleService;
import com.tcy.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:context.xml"})
public class Junit_sys {

    @Test
    public void run(){
        this.initData();
    }

    public void initData(){
        SysUser record = new SysUser();
        record.setUsername("admin");
        record.setRealname("admin");
        record.setEnabled(true);
        Set<SysRole> roles = new HashSet<SysRole>();
        SysRole role =new SysRole();
        role.setName("admin");
        role.setKey("SYS_ADMIN");
        role.setEnabled(true);
        role.setSys(true);
        roles.add(role);
        record.setRoles(roles);
        sysUserService.saveOrUpdate(record);

        //sysRoleService.saveOrUpdate(role);
    }

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserService sysUserService;

}
