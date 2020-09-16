package yangwu.bilibili.mycloudmusic.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;
import yangwu.bilibili.mycloudmusic.MainActivity;
import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.adapter.GuideAdapter;
import yangwu.bilibili.mycloudmusic.fragment.GuideFragment;

public class GuideActivity extends BaseCommonActivity {

    private static final String TAG = "GuideActivity";
    @BindView(R.id.bt_login_or_register)
    Button bt_login_or_register;
    @BindView(R.id.bt_enter)
    Button bt_enter;
    @BindView(R.id.vp)
    ViewPager vp;
    @BindView(R.id.ci)
    CircleIndicator ci;
    private GuideAdapter adapter;
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
    }

    @OnClick(R.id.bt_login_or_register)
    public void onClickLoginOrRegister(){
        startActivityAfterFinishTish(LoginOrRegisterActivity.class);
        setShowGuide();
    }

    @OnClick(R.id.bt_enter)
    public void onClickEnter(){
        startActivityAfterFinishTish(MainActivity.class);
        setShowGuide();
    }

    /**
     * 设置不再显示引导界面
     */
    private void setShowGuide() {
        sp.setShowGuide(false);
    }
}
