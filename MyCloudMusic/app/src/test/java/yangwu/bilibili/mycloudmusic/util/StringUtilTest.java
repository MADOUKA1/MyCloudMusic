package yangwu.bilibili.mycloudmusic.util;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
/**
 * 字符串工具类测试
 */
public class StringUtilTest {
    @Test
    public void testIsPhone(){
        //正确的手机号
        assertTrue(StringUtil.isPhone("18925971257"));
        assertFalse(StringUtil.isPhone("dfdf"));

    }
}
