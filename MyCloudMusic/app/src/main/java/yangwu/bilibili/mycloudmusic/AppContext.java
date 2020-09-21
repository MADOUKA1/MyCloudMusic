package yangwu.bilibili.mycloudmusic;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

import es.dmoral.toasty.Toasty;
import yangwu.bilibili.mycloudmusic.util.ToastUtil;

/**
 * 全局Application
 */
public class AppContext extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化第三方Toast，App启动时启动一次
        Toasty.Config.getInstance().apply();
        //初始化Toast的Context
        ToastUtil.init(getApplicationContext());

    }
}
