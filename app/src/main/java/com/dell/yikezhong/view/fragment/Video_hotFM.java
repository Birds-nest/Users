package com.dell.yikezhong.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.dell.yikezhong.R;
import com.dell.yikezhong.modle.bean.IHotBean;
import com.dell.yikezhong.presenter.IHotPresenter;
import com.dell.yikezhong.view.adapter.SpacesItemDecoration;
import com.dell.yikezhong.view.adapter.MasonryAdapter;
import com.dell.yikezhong.view.interfaces.IHotDataCallBack;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：王有为
 * 时间：2017/10/18.
 */

public class Video_hotFM extends Fragment implements IHotDataCallBack{
    IHotPresenter iHotPresenter;
    private RecyclerView mRecyclerView;
    private MasonryAdapter mAdapter;
    private List<IHotBean> listAll;
    private List<IHotBean.美女Bean> list;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.hot_layout,container,false);
        initData();
        return view;
    }

    private void initData() {
        mRecyclerView=(RecyclerView) view.findViewById(R.id.recycler);
        iHotPresenter = new IHotPresenter();
        iHotPresenter.setCallBack(this);
    }

    @Override
    public void onSuccess(IHotBean t) {

        listAll = new ArrayList<>();
        list= new ArrayList<>();
        Log.e("IHotBean","IHotBean"+t.get美女().get(0).getTitle());
        list.addAll(t.get美女());
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.addItemDecoration(new SpacesItemDecoration(8));//设置分割线
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));//设置RecyclerView布局管理器为2列垂直排布
        mAdapter=new MasonryAdapter(getActivity(),list);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnClickListener(new MasonryAdapter.OnItemClickListener() {
            @Override
            public void ItemClickListener(View view, int postion) {
                Toast.makeText(getActivity(),"点击了："+postion,Toast.LENGTH_SHORT).show();
            }
            @Override
            public void ItemLongClickListener(View view, int postion) {

            }
        });
    }

    @Override
    public void onError() {

    }
}
