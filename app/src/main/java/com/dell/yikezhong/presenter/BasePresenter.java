package com.dell.yikezhong.presenter;

import com.dell.yikezhong.modle.net.OkHttpUtils;

/**
 * 姓名：王有为
 * 时间：2017/10/17.
 */

public class BasePresenter<T> {

    public final OkHttpUtils okHttpUtils;
    public BasePresenter(){
        okHttpUtils = new OkHttpUtils();
    }

}
