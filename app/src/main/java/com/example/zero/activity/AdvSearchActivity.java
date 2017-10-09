package com.example.zero.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import com.example.zero.adapter.AdvDestinSearchAdapter;
import com.example.zero.bean.AdvDestinSearchBean;
import com.example.zero.greentravel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by kazu_0122 on 2017/9/22.
 */

public class AdvSearchActivity extends AppCompatActivity {
    private TextView textView;
    private RecyclerView adv_recv;
    private List<AdvDestinSearchBean> dataList = new ArrayList<>();

    private Context context;

    private static final String TAG = "AdvSearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adv_search);
        initView();
        showData();
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();

    }

    private void initView() {
        Intent intent = getIntent();
        String pos = intent.getStringExtra("position");
        String keys = intent.getStringExtra("keywords");
        textView = (TextView) this.findViewById(R.id.adv_act);
        textView.setText(pos + "  -  " + keys);
        Log.d(TAG, pos + " " + keys);
        adv_recv = (RecyclerView) this.findViewById(R.id.adv_search_recv);
        adv_recv.setLayoutManager(new LinearLayoutManager(context));

    }

    private void showData() {
        AdvDestinSearchBean searchBean = new AdvDestinSearchBean();
        ArrayList labels = new ArrayList<String>();
        labels.add("快捷");
        labels.add("便宜");
        labels.add("凯德广场");
        labels.add("学生党");
        searchBean.setText("肯德基", 900, 50, "快餐  129米",
                R.drawable.kfc, (float) 4.3, labels);
        for (int i = 0; i < 10; i++) {
            dataList.add(searchBean);
        }
        AdvDestinSearchAdapter adapter = new AdvDestinSearchAdapter(this, dataList);
        adv_recv.setAdapter(adapter);

    }

}
