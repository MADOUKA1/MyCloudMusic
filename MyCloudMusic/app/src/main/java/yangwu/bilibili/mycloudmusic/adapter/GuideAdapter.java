package yangwu.bilibili.mycloudmusic.adapter;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.fragment.GuideFragment;

public class GuideAdapter extends BaseFragmentPagerAdapter<Integer> {

    /**
     *
     * @param context
     * @param fm
     */
    public GuideAdapter(Context context, FragmentManager fm) {
        super(context, fm);
    }

    @Override
    public Fragment getItem(int position) {
        return GuideFragment.newInstance(getData(position));
    }


}
