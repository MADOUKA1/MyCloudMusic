package yangwu.bilibili.mycloudmusic.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import yangwu.bilibili.mycloudmusic.R;

public class GuideActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_login_or_register;
    private Button bt_enter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //控件绑定
        bt_enter = findViewById(R.id.bt_enter);
        bt_login_or_register = findViewById(R.id.bt_login_or_register);
        bt_enter.setOnClickListener(this);
        bt_login_or_register.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            //点击登录注册按钮
            case R.id.bt_login_or_register:
                break;
            //点击立即体验按钮
            case R.id.bt_enter:
                break;
        }
    }
}
