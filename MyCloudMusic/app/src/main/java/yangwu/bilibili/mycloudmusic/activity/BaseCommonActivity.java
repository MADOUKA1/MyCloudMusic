package yangwu.bilibili.mycloudmusic.activity;

import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import yangwu.bilibili.mycloudmusic.util.PreferenceUtils;

public class BaseCommonActivity extends BaseActivity {
    //初始化偏好设置
    protected PreferenceUtils sp;

    @Override
    protected void initDatum() {
        super.initDatum();
        sp = PreferenceUtils.getInstance(getMainActivity());
    }

    /**
     * 界面全屏
     */
    protected void fullScreen(){
        //设置界面全屏
        View decorView = getWindow().getDecorView();
        //判断版本
        if(Build.VERSION.SDK_INT>=19){
            //SYSTEM_UI_FLAG_HIDE_NAVIGATION:隐藏导航栏
            //SYSTEM_UI_FLAG_IMMERSIVE_STICKY:从状态栏下拉会半透明悬浮显示一会儿状态栏和导航栏
            //SYSTEM_UI_FLAG_FULLSCREEN:全屏
            int options = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |
                    View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY |
                    View.SYSTEM_UI_FLAG_FULLSCREEN;

            //设置到控件
            decorView.setSystemUiVisibility(options);
        }
    }

    /**
     * 隐藏状态栏
     */
    protected void hideStatusBar(){
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
    }

    /**
     * Activity跳转到下一个Activity
     * @param clazz
     */
    protected void startActivity(Class<?> clazz){
        Intent intent = new Intent(getMainActivity(), clazz);
        startActivity(intent);
    }

    /**
     * 跳转后关闭Activity
     * @param clazz
     */
    protected void startActivityAfterFinishTish(Class<?> clazz){
        Intent intent = new Intent(getMainActivity(), clazz);
        startActivity(intent);
        //关闭当前界面
        finish();
    }

    /**
     * 获取当前Activity
     * @return
     */
    protected BaseCommonActivity getMainActivity(){
        return this;
    }

}
