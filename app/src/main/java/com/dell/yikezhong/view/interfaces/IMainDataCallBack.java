package com.dell.yikezhong.view.interfaces;

import com.dell.yikezhong.modle.bean.Bean;

/**
 * 姓名：王有为
 * 时间：2017/10/17.
 */

public interface IMainDataCallBack<Bean> {
    void onSuccess(Bean t);
    void onError();
}
