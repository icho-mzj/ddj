package ddj;

import com.ddj.entity.auth.SysUser;
import com.ddj.entity.logic.DataInfo;
import com.ddj.mapper.auth.SysUserMapper;
import com.ddj.mapper.logic.DataInfoMapper;
import javafx.application.Application;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @Author: icho
 * @Date: 2024/10/9 22:02
 * @Describe:
 */
@SpringBootTest(classes = Application.class)
public class MapperTest {


    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private DataInfoMapper dataInfoMapper;

    @Test
    public void test01() {
        Long userId = 1L;
        SysUser s = sysUserMapper.selectUserById(userId);
        System.out.println("s = " + s);
    }

    @Test
    public void test02() {
        List<DataInfo> s = dataInfoMapper.getInfo("202408", "dabaoyao", "", "");
        System.out.println("s = " + s);
    }
}
