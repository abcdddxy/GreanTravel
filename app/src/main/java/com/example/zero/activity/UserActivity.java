package com.example.zero.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zero.greentravel.R;

/**
 * Created by jojo on 2017/9/27.
 */

public class UserActivity extends AppCompatActivity {
    private LinearLayout user_img;
    private ImageView backArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        innitView();
        /**
         *  监听器
         */
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        user_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserActivity.this, "img", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void innitView() {
        user_img = (LinearLayout) findViewById(R.id.user_img_change);
    }
}
