package yangwu.bilibili.mycloudmusic.util;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.StringRes;

import es.dmoral.toasty.Toasty;
import yangwu.bilibili.mycloudmusic.activity.BaseCommonActivity;


public class ToastUtil {
    /**
     * 显示短消息
     * @param context
     * @param id
     */
    public static void errorShortToast(@NonNull Context context, @StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_SHORT).show();
    }
    public static void successShortToast(@NonNull Context context, @StringRes int id) {
        Toasty.success(context,id,Toasty.LENGTH_SHORT).show();
    }
    /**
     * 传递长消息
     * @param context
     * @param id
     */
    public static void errorLongToast(@NonNull Context context, @StringRes int id) {
        Toasty.error(context,id,Toasty.LENGTH_LONG).show();
    }
    public static void successLongToast(@NonNull Context context, @StringRes int id) {
        Toasty.success(context,id,Toasty.LENGTH_LONG).show();
    }

}
