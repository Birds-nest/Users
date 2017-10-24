package com.dell.yikezhong.view.interfaces;

/**
 * Created by pc on 2017/10/20.
 */

public interface ICrossTalkPresenter<CrossTalkInfoBean> {
    void onSuccess(CrossTalkInfoBean t);
    void onError();
}
