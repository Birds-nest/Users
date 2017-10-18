package com.dell.yikezhong.view.interfaces;

/**
 * 2017/9/29.
 * 姓名：王有为
 *
 */

public interface NetDataCallBack<T> {
    void success(T t);
    void faild(int positon, String str);
}
