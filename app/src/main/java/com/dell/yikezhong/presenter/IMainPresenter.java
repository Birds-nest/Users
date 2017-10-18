package com.dell.yikezhong.presenter;


import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;

import com.dell.yikezhong.modle.bean.Bean;
import com.dell.yikezhong.view.interfaces.IHomeView;
import com.dell.yikezhong.view.interfaces.IMainDataCallBack;
import com.dell.yikezhong.view.interfaces.NetDataCallBack;

import javax.security.auth.callback.Callback;


/**
 * 姓名：王有为
 * 时间：2017/10/17.
 *MainPresenter
 */

public class IMainPresenter extends BasePresenter implements NetDataCallBack<Bean> {
    private String url = "http://api.kkmh.com/v1/daily/comic_lists/0?since=0&gender=0&sa_event=eyJwcm9qZWN0Ijoia3VhaWthbl9hcHAiLCJ0aW1lIjoxNDg3ODI4ODU4NjAwLCJwcm9wZXJ0aWVzIjp7IkhvbWVwYWdlVGFiTmFtZSI6IueDremXqCIsIlZDb21tdW5pdHlUYWJOYW1lIjoi54Ot6ZeoIiwiJG9zX3ZlcnNpb24iOiI0LjIuMiIsIkdlbmRlclR5cGUiOiLlpbPniYgiLCJGcm9tSG9tZXBhZ2VUYWJOYW1lIjoi54Ot6ZeoIiwiJGxpYl92ZXJzaW9uIjoiMS42LjM0IiwiJG5ldHdvcmtfdHlwZSI6IldJRkkiLCIkd2lmaSI6dHJ1ZSwiJG1hbnVmYWN0dXJlciI6InNhbXN1bmciLCJGcm9tSG9tZXBhZ2VVcGRhdGVEYXRlIjowLCIkc2NyZWVuX2hlaWdodCI6NTc2LCJIb21lcGFnZVVwZGF0ZURhdGUiOjAsIlByb3BlcnR5RXZlbnQiOiJSZWFkSG9tZVBhZ2UiLCJGaW5kVGFiTmFtZSI6IuaOqOiNkCIsImFidGVzdF9ncm91cCI6NDYsIiRzY3JlZW5fd2lkdGgiOjEwMjQsIiRvcyI6IkFuZHJvaWQiLCJUcmlnZ2VyUGFnZSI6IkhvbWVQYWdlIiwiJGNhcnJpZXIiOiJDTUNDIiwiJG1vZGVsIjoiR1QtUDUyMTAiLCIkYXBwX3ZlcnNpb24iOiIzLjguMSJ9LCJ0eXBlIjoidHJhY2siLCJkaXN0aW5jdF9pZCI6IkE6OTA1MTA0Mjc2Mzc1NTEwOSIsIm9yaWdpbmFsX2lkIjoiQTo5MDUxMDQyNzYzNzU1MTA5IiwiZXZlbnQiOiJSZWFkSG9tZVBhZ2UifQ%3D%3D";
    private static IMainDataCallBack iMainDataCallBack;
    private Bean bean;
    public IMainPresenter(){
        //继承BasePresenter
        okHttpUtils.getdata(url,this, Bean.class);
//        iMainDataCallBack.onSuccess(bean);
    }
    public static void setCallBack(IMainDataCallBack callBack) {
        iMainDataCallBack = callBack;
    }
    //实现NetDataCallBack接口实现的两个方法
    @Override
    public void success(Bean o) {
        Log.e("Bean","Bean"+o.getData().getSince());
        //把presenter成功接收的数据传入到view层
        iMainDataCallBack.onSuccess(o);
    }

    @Override
    public void faild(int positon, String str) {

    }
}
