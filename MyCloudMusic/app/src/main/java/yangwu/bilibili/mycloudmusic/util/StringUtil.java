package yangwu.bilibili.mycloudmusic.util;

import static yangwu.bilibili.mycloudmusic.util.Constant.REGEX_EMAIL;
import static yangwu.bilibili.mycloudmusic.util.Constant.REGEX_PHONE;

/**
 * 字符串相关工具类
 */
public class StringUtil {
    /**
     * 判断手机号格式
     */
    public static boolean isPhone(String value){
        return value.matches(REGEX_PHONE);
    }

    /**
     * 判断邮箱格式
     */
    public static boolean isEmail(String value){return value.matches(REGEX_EMAIL);}

    public static boolean isPassword(String value) { return value.length()>=6 && value.length()<=15; }
}
