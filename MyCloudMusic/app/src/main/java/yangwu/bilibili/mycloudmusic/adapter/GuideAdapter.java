package yangwu.bilibili.mycloudmusic.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.fragment.GuideFragment;

public class GuideAdapter extends FragmentPagerAdapter {
    public GuideAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return GuideFragment.newInstance(R.drawable.guide2);
    }

    @Override
    public int getCount() {
        return 10;
    }
}
