package com.dell.yikezhong.presenter;

import android.util.Log;

import com.dell.yikezhong.modle.bean.CrossTalkInfoBean;
import com.dell.yikezhong.modle.net.Api;
import com.dell.yikezhong.view.interfaces.ICrossTalkPresenter;
import com.dell.yikezhong.view.interfaces.NetDataCallBack;

/**
 * Created by pc on 2017/10/20.
 */

public class CrossTalkPresenter extends BasePresenter implements NetDataCallBack<CrossTalkInfoBean> {

    private static ICrossTalkPresenter iCrossTalkPresenter;
    public CrossTalkPresenter(){
        okHttpUtils.getdata(Api.CROSSTALK_INFO,this, CrossTalkInfoBean.class);
    }
    public static void setCallBack(ICrossTalkPresenter iCrossTalkPresenter2) {
        iCrossTalkPresenter = iCrossTalkPresenter2;
    }

    @Override
    public void success(CrossTalkInfoBean crossTalkInfoBean) {
        Log.e("zzzzzzzzz", crossTalkInfoBean.toString() );
        iCrossTalkPresenter.onSuccess(crossTalkInfoBean);
    }

    @Override
    public void faild(int positon, String str) {

    }
}
