package yangwu.bilibili.mycloudmusic;

import android.app.Application;

import es.dmoral.toasty.Toasty;

/**
 * 全局Application
 */
public class AppContext extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化吐丝，App启动时启动一次
        Toasty.Config.getInstance().apply();

    }
}
