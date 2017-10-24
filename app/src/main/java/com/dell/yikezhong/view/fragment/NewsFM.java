package com.dell.yikezhong.view.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.dell.yikezhong.R;
import com.dell.yikezhong.modle.bean.CrossTalkInfoBean;
import com.dell.yikezhong.presenter.CrossTalkPresenter;
import com.dell.yikezhong.view.adapter.CrossTalkAdapter;
import com.dell.yikezhong.view.interfaces.ICrossTalkPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * 姓名：程茁燕
 * 时间：2017/10/18.
 * <p>
 * 段子模块
 */

public class NewsFM extends Fragment implements ICrossTalkPresenter<CrossTalkInfoBean> {
    //段子的listview大布局
    private ListView litview_crosstalk;
    private CrossTalkPresenter crossTalkPresenter;
    private List<CrossTalkInfoBean.CharacterBean> list_crosstalk = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.newsfm, container, false);
        litview_crosstalk = view.findViewById(R.id.litview_crosstalk);
        getNetData();//okhttp获取数据
        return view;
    }

    private void getNetData() {
        crossTalkPresenter = new CrossTalkPresenter();
        crossTalkPresenter.setCallBack(this);
    }

    @Override
    public void onSuccess(CrossTalkInfoBean t) {
        Log.e("zzzzzzzzz", "ghjgjhgjh" + t.getCode());
        list_crosstalk.addAll(t.getCharacter());
        litview_crosstalk.setAdapter(new CrossTalkAdapter(list_crosstalk, getActivity()));
    }
    @Override
    public void onError() {
    }
}
