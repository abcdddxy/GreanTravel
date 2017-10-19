package com.example.zero.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.baidu.mapapi.SDKInitializer;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.example.zero.fragment.FragmentController;

import com.example.zero.greentravel.R;
import com.example.zero.view.TitleLayout;
import com.example.zero.view.TitleRouteLayout;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    /**
     * 内容区域
     */
    private LinearLayout bottom_nav_content;
    /**
     * 底部导航栏
     */
    private BottomNavigationBar bottom_navigation_bar_container;

    private BottomNavigationItem personItem;
    private BottomNavigationItem adviceItem;
    private BottomNavigationItem routeItem;
    private BottomNavigationItem salesItem;
    private BadgeItem badgeItem;

    /**
     * 标题栏
     */
    private TitleLayout titleLayout;
    private TitleRouteLayout titleRouteLayout;

    /**
     * Fragment控制类
     */
    private FragmentController fragmentController;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_main);
        initView();
        initBottomNavBar();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        Log.d(TAG, "onCreate: success");
    }

    /**
     * 初始化视图
     */
    private void initView() {
        bottom_nav_content = (LinearLayout) findViewById(R.id.bottom_nav_content);
        bottom_navigation_bar_container = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_container);

        titleLayout = (TitleLayout) findViewById(R.id.main_title);
        titleRouteLayout = (TitleRouteLayout) findViewById(R.id.route_title);

    }

    /**
     * 初始化底部导航栏
     */
    private void initBottomNavBar() {
        bottom_navigation_bar_container.setAutoHideEnabled(true);//自动隐藏

        bottom_navigation_bar_container.setMode(BottomNavigationBar.MODE_FIXED);
        bottom_navigation_bar_container.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);

        bottom_navigation_bar_container.setBarBackgroundColor(R.color.white);//背景颜色
        bottom_navigation_bar_container.setInActiveColor(R.color.nav_gray);//未选中时的颜色
        bottom_navigation_bar_container.setActiveColor(R.color.colorPrimaryDark);//选中时的颜色

        badgeItem = new BadgeItem().setBackgroundColor(Color.RED).setText("99").setHideOnSelect(true);//角标

        routeItem = new BottomNavigationItem(R.drawable.route, "路线");
        adviceItem = new BottomNavigationItem(R.drawable.advice, "建议");
        salesItem = new BottomNavigationItem(R.drawable.sale, "促销");
        personItem = new BottomNavigationItem(R.drawable.person, "个人");
        personItem.setBadgeItem(badgeItem);

        bottom_navigation_bar_container.addItem(routeItem).addItem(adviceItem).addItem(salesItem).addItem(personItem);
        bottom_navigation_bar_container.initialise();
        bottom_navigation_bar_container.setTabSelectedListener(this);

        fragmentController = FragmentController.getInstance(this, R.id.bottom_nav_content);
        fragmentController.showFragment(0);
    }

    /**
     * 底部NaV监听
     *
     * @param position Fragment位置
     */
    @Override
    public void onTabSelected(int position) {
        fragmentController.hideFragments();//先隐藏所有frag
        switch (position) {
            case 0:
                fragmentController.showFragment(0);
                getSupportActionBar().setTitle("路线");
                titleLayout.setVisibility(View.GONE);
                titleRouteLayout.setVisibility(View.VISIBLE);
                break;

            case 1:
                fragmentController.showFragment(1);
                getSupportActionBar().setTitle("建议");
                titleLayout.setVisibility(View.VISIBLE);
                titleRouteLayout.setVisibility(View.GONE);
                break;

            case 2:
                fragmentController.showFragment(2);
                getSupportActionBar().setTitle("促销");
                titleLayout.setVisibility(View.VISIBLE);
                titleRouteLayout.setVisibility(View.GONE);
                break;

            case 3:
                fragmentController.showFragment(3);
                getSupportActionBar().setTitle("个人");
                break;
        }
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}
