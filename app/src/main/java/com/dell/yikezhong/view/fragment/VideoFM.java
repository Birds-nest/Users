package com.dell.yikezhong.view.fragment;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dell.yikezhong.R;

/**
 * 姓名：王有为
 * 时间：2017/10/18.
 *
 * 视频模块
 */

public class VideoFM extends Fragment {
    private ViewPager pager;
    private TabLayout layout;
    private View view;
    final String name[]={"热门","附近"};
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.videofm,container,false);
        initview();
        getPager();
        return view;
    }

    private void getPager() {
        pager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                Fragment fragment=null;
                if (position==0){
                    fragment=new Video_hotFM();
                }else if(position==1){
                    fragment = new Video_nearFM();
                }
                return fragment;
            }

            @Override
            public int getCount() {
                return name.length;
            }
            @Override
            public CharSequence getPageTitle(int position) {
                return  name[position];
            }

        });
        layout.setupWithViewPager(pager);
    }

    private void initview() {
        pager=(ViewPager)view.findViewById(R.id.pager);
        layout=(TabLayout)view.findViewById(R.id.tablayout);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
