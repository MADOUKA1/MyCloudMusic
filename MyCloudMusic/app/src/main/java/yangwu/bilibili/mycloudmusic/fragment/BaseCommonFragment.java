package yangwu.bilibili.mycloudmusic.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import yangwu.bilibili.mycloudmusic.activity.BaseCommonActivity;
import yangwu.bilibili.mycloudmusic.util.PreferenceUtils;

public abstract class BaseCommonFragment extends BaseFragment {

    protected PreferenceUtils sp;

    @Override
    protected void initDatum() {
        super.initDatum();
        //初始化偏好
        sp = PreferenceUtils.getInstance(getMainActivity());
    }

    /**
     * Activity跳转到下一个Activity
     * @param clazz
     */
    protected void startActivity(Class<?> clazz){
        Intent intent = new Intent(getMainActivity(), clazz);
        startActivity(intent);
    }

    /**
     * 跳转后关闭Activity
     * @param clazz
     */
    protected void startActivityAfterFinishTish(Class<?> clazz){
        Intent intent = new Intent(getMainActivity(), clazz);
        startActivity(intent);
        //关闭当前界面
        getMainActivity().finish();
    }

    /**
     * 获取当前Activity
     * @return
     */
    protected BaseCommonActivity getMainActivity(){
        return (BaseCommonActivity) getActivity();
    }
}
