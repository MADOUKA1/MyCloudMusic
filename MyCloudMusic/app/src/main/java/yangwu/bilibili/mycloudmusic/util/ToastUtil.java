package yangwu.bilibili.mycloudmusic.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import es.dmoral.toasty.Toasty;
import yangwu.bilibili.mycloudmusic.activity.BaseCommonActivity;


public class ToastUtil {
    /**
     * 初始化方法
     */
    private static Context context;
    public static void init(Context context) {
        ToastUtil.context = context;
    }

    /**
     * 显示短消息
     * @param id
     */
    public static void errorShortToast( @StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_SHORT).show();
    }
    public static void successShortToast( @StringRes int id) {
        Toasty.success(context,id,Toasty.LENGTH_SHORT).show();
    }
    /**
     * 传递长消息
     * @param id
     */
    public static void errorLongToast( @StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_LONG).show();
    }
    public static void successLongToast( @StringRes int id) {
        Toasty.success(context,id,Toasty.LENGTH_LONG).show();
    }


}
