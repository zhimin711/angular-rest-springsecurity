package junit;

import com.tcy.core.http.result.PageResult;
import org.junit.Test;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Created by 80002023 on 2016/6/3.
 */
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class RestTest extends AbstractJUnit4SpringContextTests {

    PageResult<?> result;

    @Test
    public void run() {
    }


}
