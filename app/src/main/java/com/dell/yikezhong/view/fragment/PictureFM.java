package com.dell.yikezhong.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dell.yikezhong.R;

/**
 * 姓名：王有为
 * 时间：2017/10/18.
 *
 * 趣图模块
 */

public class PictureFM extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.picturefm,container,false);
        return view;

    }
}
