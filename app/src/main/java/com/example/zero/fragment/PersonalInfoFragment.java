package com.example.zero.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.zero.activity.MsgActivity;
import com.example.zero.activity.SettingActivity;
import com.example.zero.activity.UserActivity;
import com.example.zero.greentravel.R;

/**
 * Created by jojo on 2017/9/22.
 */

public class PersonalInfoFragment extends Fragment {

    private View person_frag;
    private Context context;
    private TextView setting;
    private LinearLayout msg;
    private LinearLayout user;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container, Bundle savedInstanceState) {
        person_frag = inflater.inflate(R.layout.fragment_personal_info, container, false);
        innitView();
        /**
         *  设置activity监听
         */
        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  UserActivity监听
         */
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), UserActivity.class);
                startActivity(intent);
            }
        });
        /**
         *  我的消息activity监听
         */
        msg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(getActivity(), MsgActivity.class);
                startActivity(intent);
            }
        });
        context = person_frag.getContext();
        return person_frag;
    }

    public void innitView() {
        setting = (TextView) person_frag.findViewById(R.id.setting);
        user = (LinearLayout) person_frag.findViewById(R.id.user_info);
        msg = (LinearLayout) person_frag.findViewById(R.id.msg);
    }

}
