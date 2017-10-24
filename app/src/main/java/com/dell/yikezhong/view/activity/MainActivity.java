package com.dell.yikezhong.view.activity;

import android.content.Intent;
import android.content.res.ObbInfo;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.dell.yikezhong.R;
import com.dell.yikezhong.modle.bean.Bean;
import com.dell.yikezhong.presenter.IMainPresenter;
import com.dell.yikezhong.view.fragment.NewsFM;
import com.dell.yikezhong.view.fragment.PictureFM;
import com.dell.yikezhong.view.fragment.RecommendFM;
import com.dell.yikezhong.view.fragment.VideoFM;
import com.dell.yikezhong.view.interfaces.IMainDataCallBack;
import com.hjm.bottomtabbar.BottomTabBar;
import com.hjm.bottomtabbar.custom.CustomFragmentTabHost;
import com.jeremyfeinstein.slidingmenu.lib.SlidingMenu;
/**
 * mainactivity
 * */
public class MainActivity extends BaseActivity implements IMainDataCallBack<Bean>{
    private BottomTabBar tabBar;
    private IMainPresenter iMainPresenter;
    private SlidingMenu menu;
    private Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getTabBar();
        getSliding();
        Intent intent = getIntent();
        int aad = intent.getIntExtra("aad", 0);
        if (aad == 1) {
            LinearLayout ll = (LinearLayout) tabBar.getChildAt(0);
            for (int i = 0; i < ll.getChildCount(); i++) {
                View child = ll.getChildAt(i);
                if (child instanceof CustomFragmentTabHost) {
                    CustomFragmentTabHost tabHost = (CustomFragmentTabHost) ll.getChildAt(i);
                    tabHost.setCurrentTab(2);
                }
            }
        }else{
            return;
        }
    }

    private void getSliding() {
        menu.setMode(SlidingMenu.LEFT);
        menu.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
        menu.setShadowWidth(160);
        menu.setBehindWidth(530);
        menu.setFadeDegree(0.35f);
        menu.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
        menu.setMenu(R.layout.sliding);
    }

    private void getTabBar() {
        tabBar= (BottomTabBar) findViewById(R.id.bottom_tab_bar);
        //这个init ( getSupportFragmentManager() )方法一定要第一个调用，没有//这个初始化，后边什么也做不了。
        tabBar.init(getSupportFragmentManager())
                .addTabItem("推荐",R.drawable.raw_1500085367,R.drawable.raw_1500083878,  RecommendFM.class)
                .addTabItem("段子",R.drawable.raw_1500085899, R.drawable.raw_1500085327,NewsFM.class)
                .addTabItem("视频",R.drawable.raw_1500086067,R.drawable.raw_1500083686,  VideoFM.class);
        float a =70;
        tabBar.setDividerHeight(a);
    }

    //继承BaseActivity实现的两个方法
    protected void initData() {
        iMainPresenter = new IMainPresenter();
        iMainPresenter.setCallBack(this);
        menu=new SlidingMenu(MainActivity.this);

    }

    protected void initView() {
        toolbar=(Toolbar)findViewById(R.id.toolbar);
    }
    //实现IMainDataCallBack接口后的两个方法
    @Override
    public void onSuccess(Bean bean) {

    }

    @Override
    public void onError() {

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            Intent intent = new Intent();
            intent.getStringExtra(data.getStringExtra("text"));
            startActivity(intent);
        }
    }
}
