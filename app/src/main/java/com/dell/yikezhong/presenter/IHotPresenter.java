package com.dell.yikezhong.presenter;

import com.dell.yikezhong.modle.bean.Bean;
import com.dell.yikezhong.modle.bean.IHotBean;
import com.dell.yikezhong.view.interfaces.IHotDataCallBack;
import com.dell.yikezhong.view.interfaces.IMainDataCallBack;
import com.dell.yikezhong.view.interfaces.NetDataCallBack;

/**
 * 姓名：王有为
 * 时间：2017/10/19.
 */

public class IHotPresenter extends BasePresenter implements NetDataCallBack<IHotBean> {
    private String url ="http://c.3g.163.com/recommend/getChanListNews?channel=T1456112189138&size=20&passport=&devId=1uuFYbybIU2oqSRGyFrjCw%3D%3D&lat=%2F%2FOm%2B%2F8ScD%2B9fX1D8bxYWg%3D%3D&lon=LY2l8sFCNzaGzqWEPPgmUw%3D%3D&version=9.0&net=wifi&ts=1464769308&sign=bOVsnQQ6gJamli6%2BfINh6fC%2Fi9ydsM5XXPKOGRto5G948ErR02zJ6%2FKXOnxX046I&encryption=1&canal=meizu_store2014_news&mac=sSduRYcChdp%2BBL1a9Xa%2F9TC0ruPUyXM4Jwce4E9oM30%3D";
    private static IHotDataCallBack iHotDataCallBack;
    public IHotPresenter() {
        okHttpUtils.getdata(url,this, IHotBean.class);
    }
    public static void setCallBack(IHotDataCallBack callBack) {
        iHotDataCallBack = callBack;
    }
    @Override
    public void success(IHotBean iHotBean) {
        iHotDataCallBack.onSuccess(iHotBean);
    }

    @Override
    public void faild(int positon, String str) {

    }
}
