package yangwu.bilibili.mycloudmusic.activity;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 所有Activity的父类
 */
public class BaseActivity extends AppCompatActivity {
    /**
     * 找控件
     */
    protected void initViews(){}

    /**
     * 设置数据
     */
    protected void initDatum(){}

    /**
     * 设置监听
     */
    protected void initListeners(){}

    protected BaseActivity getMainActivity(){return this;}
    /**
     * 在onCreate方法后调用,页面初始化
     * @param savedInstanceState
     */
    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        initViews();
        initDatum();
        initListeners();
    }
}
