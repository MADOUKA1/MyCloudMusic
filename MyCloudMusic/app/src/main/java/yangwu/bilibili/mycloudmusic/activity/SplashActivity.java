package yangwu.bilibili.mycloudmusic.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;

import yangwu.bilibili.mycloudmusic.R;

public class SplashActivity extends AppCompatActivity {
    private static final int MSG_NEXT = 100;
    private static final long DEFAULT_DELAY_TIME = 3000;
    private static final String TAG = "splash_activity";
    private Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case MSG_NEXT:
                    toGuide();
            }
        }
    };

    private void toGuide() {
        Log.d(TAG,"next");
        startActivityAfterFinishTish(GuideActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

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

        //延时3秒
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(MSG_NEXT);
            }
        },DEFAULT_DELAY_TIME);
    }
    private void startActivity(Class<?> clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
    }
    private void startActivityAfterFinishTish(Class<?> clazz){
        Intent intent = new Intent(this, clazz);
        startActivity(intent);
        //关闭当前界面
        finish();
    }
}
