package yangwu.bilibili.mycloudmusic.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import yangwu.bilibili.mycloudmusic.fragment.GuideFragment;

public abstract class BaseFragmentPagerAdapter<T> extends FragmentStatePagerAdapter {
    protected final Context context;
    /**
     * 列表数据源
     */
    protected List<T> datum = new ArrayList<>();

    public BaseFragmentPagerAdapter(Context context,FragmentManager fm) {
        super(fm);
        this.context = context.getApplicationContext();
    }


    /**
     * 获取当前位置对应的资源id
     * @param position
     * @return
     */
    protected T getData(int position) {
        return datum.get(position);
    }

    @Override
    public int getCount() {
        return datum.size();
    }

    /**
     * 设置数据
     */
    public void setDatum(List<T> datum){
        if(datum != null && datum.size()>0){
            this.datum.clear();
            this.datum.addAll(datum);
            notifyDataSetChanged();
        }
    }

    /**
     * 添加数据
     */
    protected void addDatum(List<T> datum){
        if(datum != null &&datum.size()>0){
            this.datum.addAll(datum);
            notifyDataSetChanged();
        }
    }
}
