package yangwu.bilibili.mycloudmusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.fragment.BaseCommonFragment;

/**
 * 登录注册界面
 */
public class LoginOrRegisterActivity extends BaseCommonActivity {
    /**
     * 绑定控件
     */
    @BindView(R.id.bt_login)
    Button bt_login;
    @BindView(R.id.bt_register)
    Button bt_register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_or_register);
    }

    @Override
    protected void initViews() {
        super.initViews();
        //显示亮色状态栏
        lightStatusBar();
    }

    @Override
    protected void initListeners() {
        super.initListeners();
    }

    /**
     * 登录按钮点击
     */
    @OnClick(R.id.bt_login)
    public void onClickLogin(){
        startActivity(LoginActivity.class);
    }

    /**
     * 注册按钮点击
     */
    @OnClick(R.id.bt_register)
    public void onClickRegister(){
        startActivity(RegisterActivity.class);
    }
}
