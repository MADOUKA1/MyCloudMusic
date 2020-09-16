package yangwu.bilibili.mycloudmusic.activity;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import yangwu.bilibili.mycloudmusic.R;

public class BaseTitleActivity extends BaseCommonActivity{
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @Override
    protected void initViews() {
        super.initViews();
        //初始化ToolBar
        setSupportActionBar(toolbar);

        //显示返回按钮
        if(isShowBackMenu()){
            showBackMenu();
        }
    }

    /**
     * 显示返回按钮
     */
    protected void showBackMenu() {
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    /**
     * 是否显示返回按钮
     * @return
     */
    protected boolean isShowBackMenu() {
        return true;
    }
    /**
     * 按钮点击回调
     */
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            //toolBar返回按钮点击
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
