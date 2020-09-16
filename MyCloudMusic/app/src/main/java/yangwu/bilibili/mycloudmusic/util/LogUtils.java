package yangwu.bilibili.mycloudmusic.util;

import android.util.Log;

import yangwu.bilibili.mycloudmusic.BuildConfig;

public class LogUtils {
    /**
     * 是否是调试状态
     */
    public static final boolean isDebug = BuildConfig.DEBUG;

    /**
     *
     * @param tag
     * @param value
     */
    public static void d(String tag, String value) {
        if (isDebug) {
            Log.d(tag, value);
        }
    }

    public static void w(String tag, String value) {
        if (isDebug) {
            Log.w(tag, value);
        }
    }
}
