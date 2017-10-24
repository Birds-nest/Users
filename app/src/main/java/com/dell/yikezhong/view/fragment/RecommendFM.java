package com.dell.yikezhong.view.fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dell.yikezhong.R;

import java.util.ArrayList;

/**
 * 姓名：王有为
 * 时间：2017/10/18.
 *
 * 推荐模块
 */

public class RecommendFM extends Fragment {
    private ViewPager pager;
    private View view;
    final String name[]={"热门","关注"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recommendfm,container,false);

        return view;
    }
}
