package yangwu.bilibili.mycloudmusic.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator;
import yangwu.bilibili.mycloudmusic.MainActivity;
import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.adapter.GuideAdapter;
import yangwu.bilibili.mycloudmusic.fragment.GuideFragment;

public class GuideActivity extends BaseCommonActivity implements View.OnClickListener {

    private static final String TAG = "GuideActivity";
    private Button bt_login_or_register;
    private Button bt_enter;
    private ViewPager vp;
    private GuideAdapter adapter;
    private CircleIndicator ci;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
    }

    @Override
    protected void initViews() {
        super.initViews();
        //隐藏状态栏
        hideStatusBar();
        //控件绑定
        bt_enter = findViewById(R.id.bt_enter);
        bt_login_or_register = findViewById(R.id.bt_login_or_register);
        vp = findViewById(R.id.vp);
        //指示器
        ci = findViewById(R.id.ci);
    }

    @Override
    protected void initDatum() {
        super.initDatum();
        //准备数据
        List<Integer> datum = new ArrayList<>();
        datum.add(R.drawable.guide1);
        datum.add(R.drawable.guide2);
        datum.add(R.drawable.guide3);
        datum.add(R.drawable.guide4);
        datum.add(R.drawable.guide5);
        //创建适配器
        adapter = new GuideAdapter(getMainActivity(),getSupportFragmentManager());
        //设置适配器
        adapter.setDatum(datum);
        vp.setAdapter(adapter);

        //指示器配合控件工作
        ci.setViewPager(vp);

        //注册数据源观察者
        adapter.registerDataSetObserver(ci.getDataSetObserver());
    }

    @Override
    protected void initListeners() {
        Log.d(TAG, "initListeners: " + bt_enter);
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
