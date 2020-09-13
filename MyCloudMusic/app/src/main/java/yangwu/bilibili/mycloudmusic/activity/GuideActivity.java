package yangwu.bilibili.mycloudmusic.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import yangwu.bilibili.mycloudmusic.MainActivity;
import yangwu.bilibili.mycloudmusic.R;

public class GuideActivity extends BaseCommonActivity implements View.OnClickListener {

    private Button bt_login_or_register;
    private Button bt_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        initViews();
        initListeners();
        initDatum();
    }

    @Override
    protected void initViews() {
        super.initViews();
        //隐藏状态栏
        hideStatusBar();
        //控件绑定
        bt_enter = findViewById(R.id.bt_enter);
        bt_login_or_register = findViewById(R.id.bt_login_or_register);
    }

    @Override
    protected void initListeners() {
        super.initListeners();
        bt_enter.setOnClickListener(this);
        bt_login_or_register.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击登录注册按钮
            case R.id.bt_login_or_register:
                startActivityAfterFinishTish(LoginOrRegisterActivity.class);
                setShowGuide();
                break;
            //点击立即体验按钮
            case R.id.bt_enter:
                startActivityAfterFinishTish(MainActivity.class);
                setShowGuide();
                break;
        }
    }

    /**
     * 设置不再显示引导界面
     */
    private void setShowGuide() {
        sp.setShowGuide(false);
    }
}
