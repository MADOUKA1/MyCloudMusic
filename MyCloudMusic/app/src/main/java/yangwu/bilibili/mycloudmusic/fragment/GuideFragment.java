package yangwu.bilibili.mycloudmusic.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import yangwu.bilibili.mycloudmusic.R;
import yangwu.bilibili.mycloudmusic.util.Constant;

/**
 * 引导界面fragment
 */
public class GuideFragment extends Fragment {

    private ImageView iv;

    //构造方法
    public GuideFragment() {
        // Required empty public constructor
    }

    /**
     * 创建fragment
     */
    public static GuideFragment newInstance(int id) {
        GuideFragment fragment = new GuideFragment();
        //创建Bundle传递数据
        Bundle args = new Bundle();
        args.putInt(Constant.ID,id);
        //将Bundle设置到Fragment中
        fragment.setArguments(args);
        return fragment;
    }

    /**
     * 返回要显示的View
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_guide, container, false);
    }

    /**
     * View创建后取数据
     */
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //找控件
        iv = getView().findViewById(R.id.iv);

        //取出Bundle中的数据
        int id = getArguments().getInt(Constant.ID,-1);
        if(id == -1){
            getActivity().finish();
            return;
        }

        //设置图片
        iv.setImageResource(id);
    }
}
