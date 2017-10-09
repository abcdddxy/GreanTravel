package com.example.zero.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zero.greentravel.R;

/**
 * Created by jojo on 2017/9/25.
 */

public class SettingActivity extends AppCompatActivity {
    private LinearLayout accountManage, secret, commonSetting, safety;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        innitView();
        /**
         * 监听器
         */
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        accountManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "accountManage", Toast.LENGTH_SHORT).show();
            }
        });
        secret.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "secret", Toast.LENGTH_SHORT).show();
            }
        });
        commonSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "common", Toast.LENGTH_SHORT).show();
            }
        });
        safety.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SettingActivity.this, "safety", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void innitView() {
        backArrow = (ImageView) findViewById(R.id.setting_back_arrow);
        accountManage = (LinearLayout) findViewById(R.id.account_manage);
        secret = (LinearLayout) findViewById(R.id.secret);
        commonSetting = (LinearLayout) findViewById(R.id.common_setting);
        safety = (LinearLayout) findViewById(R.id.safety);
    }

}
