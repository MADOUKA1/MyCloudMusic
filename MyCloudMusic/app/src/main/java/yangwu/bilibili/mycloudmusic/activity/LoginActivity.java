package yangwu.bilibili.mycloudmusic.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import org.apache.commons.lang3.StringUtils;

import butterknife.BindView;
import butterknife.OnClick;
import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.util.LogUtils;
import yangwu.bilibili.mycloudmusic.util.StringUtil;
import yangwu.bilibili.mycloudmusic.util.ToastUtil;

public class LoginActivity extends BaseTitleActivity {
    private static final String TAG = "LoginActivity";
    @BindView(R.id.bt_login)
    Button bt_login;
    @BindView(R.id.bt_forget_password)
    Button bt_forget_password;
    @BindView(R.id.et_username)
    EditText et_username;
    @BindView(R.id.et_password)
    EditText et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
    /**
     * 登录按钮点击事件
     */
    @OnClick(R.id.bt_login)
    public void onLoginClick(){
        //获取用户名
        String username = et_username.getText().toString().trim();
        if(StringUtils.isBlank(username)){
            LogUtils.w(TAG,"onLoginClick user empty");
            ToastUtil.errorShortToast(R.string.enter_username);
            //Toasty.error(getMainActivity(),R.string.enter_username,Toasty.LENGTH_SHORT).show();
            //Toast.makeText(getMainActivity(), "user empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!(StringUtil.isPhone(username) || (StringUtil.isEmail(username)))){
            ToastUtil.errorShortToast(R.string.error_username_format);
            return;
        }
        //获取密码
        String password = et_password.getText().toString().trim();
        if(StringUtils.isBlank(password)){
            LogUtils.w(TAG,"onLoginClick password empty");
            ToastUtil.errorShortToast(R.string.enter_password);
            //Toast.makeText(getMainActivity(), "password empty", Toast.LENGTH_SHORT).show();
            return;
        }
        if(!StringUtil.isPassword(password)){
            ToastUtil.errorShortToast(R.string.error_password_format);
            return;
        }

        //调用登录方法
        ToastUtil.successShortToast(R.string.login_sucess);
    }
    /**
     * 忘记密码点击
     */
    @OnClick(R.id.bt_forget_password)
    public void onForgetPasswordClick(){}

}
