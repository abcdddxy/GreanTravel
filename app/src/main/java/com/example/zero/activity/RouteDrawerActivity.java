package com.example.zero.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.SlidingDrawer;
import android.widget.TextView;

import com.example.zero.greentravel.R;

public class RouteDrawerActivity extends ActionBarActivity {
    private ImageView img;
    private SlidingDrawer slidingDrawer;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_drawer);
//        img=(ImageView)findViewById(R.id.route_drawer_handle);
//        slidingDrawer= (SlidingDrawer) findViewById(R.id.slidingDrawer);
//        textView=(TextView)findViewById(R.id.route_drawer_txt);
//
//        //完全打开
//        slidingDrawer.setOnDrawerOpenListener(new SlidingDrawer.OnDrawerOpenListener() {
//            @Override
//            public void onDrawerOpened() {
//                img.setImageResource(R.drawable.haidilao);
//            }
//        });
//
//        //完全关闭
//        slidingDrawer.setOnDrawerCloseListener(new SlidingDrawer.OnDrawerCloseListener() {
//            @Override
//            public void onDrawerClosed() {
//                img.setImageResource(R.drawable.zara);
//            }
//        });
//        slidingDrawer.setOnDrawerScrollListener(new SlidingDrawer.OnDrawerScrollListener() {
//            //开始滚动时的操作
//            @Override
//            public void onScrollStarted() {
//                textView.setText("SlidingDrawerStarted");
//            }
//            //结束滚动时的操作
//            @Override
//            public void onScrollEnded() {
//                textView.setText("SlidingDrawerEnded");
//            }
//        });
    }
}
