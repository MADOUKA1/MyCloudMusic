package yangwu.bilibili.mycloudmusic.util;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 偏好设置工具类
 * 是否登录，是否显示引导界面，用户ID
 */
public class PreferenceUtils {
    //showGuide Key
    private static final String SHOW_GUIDE = "SHOW_GUIDE";
    private static PreferenceUtils instance;
    private final Context context;
    private static final String NAME = "yw_myCloud_Music";
    private final SharedPreferences preferences;

    public PreferenceUtils(Context context) {
        //防止单例内存泄漏
        this.context = context.getApplicationContext();
        //获取偏好设置
        preferences = this.context.getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }

    /**
     * 判断是否显示引导界面
     * @return
     */
    public boolean isShowGuide(){
        return preferences.getBoolean(SHOW_GUIDE,true);
    }

    /**
     * 设置是否显示引导界面
     * @param value
     */
    public void setShowGuide(boolean value){
        preferences.edit().putBoolean(SHOW_GUIDE,value).commit();
    }

    /**
     * 设置工具类为单例模式
     * @param context
     * @return
     */
    public static PreferenceUtils getInstance(Context context) {
        if(instance == null){
            instance = new PreferenceUtils(context);
        }
        return instance;
    }
}
