package com.example.zero.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import com.example.zero.fragment.AdvFragment;
import com.example.zero.fragment.MsgFragment;
import com.example.zero.fragment.RouteFragment;
import com.example.zero.fragment.SaleFragment;

import com.example.zero.greentravel.R;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    private LinearLayout bottom_nav_content;//内容区域
    private BottomNavigationBar bottom_navigation_bar_container;//底部导航栏

    private BottomNavigationItem msgItem;
    private BottomNavigationItem adviceItem;
    private BottomNavigationItem routeItem;
    private BottomNavigationItem salesItem;
    private BadgeItem badgeItem;

    private MsgFragment msgFrag;
    private AdvFragment advFrag;
    private RouteFragment routeFrag;
    private SaleFragment saleFrag;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initBottomNavBar();
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.hide();
        Log.d(TAG, "onCreate: success");
    }

    private void initView() {
        bottom_nav_content = (LinearLayout) findViewById(R.id.bottom_nav_content);
        bottom_navigation_bar_container = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar_container);

    }

    /*初始化底部导航栏*/
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
        msgItem = new BottomNavigationItem(R.drawable.msg, "消息");
        msgItem.setBadgeItem(badgeItem);

        bottom_navigation_bar_container.addItem(routeItem).addItem(adviceItem).addItem(salesItem).addItem(msgItem);
        bottom_navigation_bar_container.initialise();
        bottom_navigation_bar_container.setTabSelectedListener(this);
        setDefaultFrag();//显示默认的Frag
    }

    /*设置默认Fragment*/
    private void setDefaultFrag() {
        if (routeFrag == null) {
            routeFrag = new RouteFragment();
        }
        addFrag(routeFrag);
        getSupportFragmentManager().beginTransaction().show(routeFrag).commit();
    }

    /*添加Frag*/
    private void addFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (frag != null && !frag.isAdded()) {
            ft.add(bottom_nav_content.getId(), frag);
        }
        ft.commit();
    }

    /*隐藏所有fragment*/
    private void hideAllFrag() {
        hideFrag(routeFrag);
        hideFrag(advFrag);
        hideFrag(saleFrag);
        hideFrag(msgFrag);
    }

    /*隐藏frag*/
    private void hideFrag(Fragment frag) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (frag != null && frag.isAdded()) {
            ft.hide(frag);
        }
        ft.commit();
    }

    /*底部NaV监听*/
    @Override
    public void onTabSelected(int position) {
        hideAllFrag();//先隐藏所有frag
        switch (position) {
            case 0:
                if (routeFrag == null) {
                    routeFrag = new RouteFragment();
                }
                addFrag(routeFrag);
                getSupportFragmentManager().beginTransaction().show(routeFrag).commit();
                getSupportActionBar().setTitle("路线");
                break;

            case 1:
                if (advFrag == null) {
                    advFrag = new AdvFragment();
                }
                addFrag(advFrag);
                getSupportFragmentManager().beginTransaction().show(advFrag).commit();
                getSupportActionBar().setTitle("建议");
                break;

            case 2:
                if (saleFrag == null) {
                    saleFrag = new SaleFragment();
                }
                addFrag(saleFrag);
                getSupportFragmentManager().beginTransaction().show(saleFrag).commit();
                getSupportActionBar().setTitle("促销");
                break;

            case 3:
                if (msgFrag == null) {
                    msgFrag = new MsgFragment();
                }
                addFrag(msgFrag);
                getSupportFragmentManager().beginTransaction().show(msgFrag).commit();
                getSupportActionBar().setTitle("消息");
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
