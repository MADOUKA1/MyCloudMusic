package yangwu.bilibili.mycloudmusic.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import butterknife.ButterKnife;
import yangwu.bilibili.mycloudmusic.util.PreferenceUtils;

public class BaseCommonActivity extends BaseActivity {
    //初始化偏好设置
    protected PreferenceUtils sp;

    @Override
    protected void initViews() {
        super.initViews();
        if(isBindView()){bindView();}
    }

    protected void bindView() {
        ButterKnife.bind(this);
    }

    /**
     * 是否绑定View
     * @return
     */
    protected boolean isBindView() {
        return true;
    }

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
     * 文字显示白色
     * 内容显示到状态栏上面
     */
    protected void lightStatusBar() {
        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            //获取Window
            Window window = getWindow();

            //设置状态栏颜色为透明
            window.setStatusBarColor(Color.TRANSPARENT);

            //去除半透明效果（如果有）
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);

            //SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN：让内容显示到状态栏
            //SYSTEM_UI_FLAG_LAYOUT_STABLE：状态栏文字显示白色
            //SYSTEM_UI_FLAG_LIGHT_STATUS_BAR：状态栏文字显示黑色
            window.getDecorView().setSystemUiVisibility(
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                            |View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            );
        }
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
