package yangwu.bilibili.mycloudmusic.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import yangwu.bilibili.mycloudmusic.R;

public class SplashActivity extends BaseCommonActivity {
    private static final int MSG_NEXT = 100;
    private static final long DEFAULT_DELAY_TIME = 3000;
    private static final String TAG = "splash_activity";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_NEXT:
                    //判断是否显示引导界面
                    if(sp.isShowGuide()){
                        toGuide();
                    }
                    else{
                        startActivityAfterFinishTish(LoginOrRegisterActivity.class);
                    }
                        break;
            }
        }
    };

    private void toGuide() {
        startActivityAfterFinishTish(GuideActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //设置全屏
        fullScreen();
        //延时3秒
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(MSG_NEXT);
            }
        },DEFAULT_DELAY_TIME);
    }

    @Override
    protected void initDatum() {
        super.initDatum();

    }
}
