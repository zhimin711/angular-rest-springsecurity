package junit;

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
import java.util.List;
import java.util.Set;

/**
 * Created by 80002023 on 2016/6/3.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml", "classpath:applicationContext-security.xml"})
public class SysTest extends AbstractJUnit4SpringContextTests {

    PageResult<?> result;

    @Test
    public void run() {
        this.testUser(1);
        this.testRole(10);
    }

    private void testRole(int i) {
        SysRole record = new SysRole();
        switch (i) {
            case 1:
                record.setName("系统管理员");
                record.setKey("SYS_ADMIN");

                sysRoleService.saveOrUpdate(record);
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public void testUser(int i) {
        SysUser record = new SysUser();
        switch (i) {
            case 1:
                record.setId(39L);
//                record.setUsername("admin3");
//                record.setName("系统管理员3");
//                record.setEnabled(true);
                record.setPassword("123456");
                sysUserService.saveOrUpdate(record);
                break;
            case 2:
                record.setId(30L);
                List<SysRole> roleList = sysRoleService.findAll();
                Set<SysRole> roles = new HashSet<SysRole>(roleList);
                //roles.add(roles);
                record.setRoles(roles);

                sysUserService.saveOrUpdate(record);
                break;
            case 3:
                result = sysUserService.findPage(record, 0, 10);
                System.out.println("");
                break;
            case 4:
                break;
        }
    }

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysUserService sysUserService;

}
