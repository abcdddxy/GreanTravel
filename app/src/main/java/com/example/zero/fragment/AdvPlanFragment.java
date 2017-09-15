package com.example.zero.fragment;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.TimePicker;


import com.example.zero.greentravel.R;

import java.util.Calendar;

/**
 * Created by shuwan122 on 2017/9/7.
 * 出行规划fragment
 */

public class AdvPlanFragment extends Fragment {

    private TextView textView;
    private boolean seted;
    private int hour1;
    private int minute1;
    private int hour2;
    private int minute2;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        seted = false;
        View view = inflater.inflate(R.layout.fragment_adv_plan, container, false);
        textView = (TextView)view.findViewById(R.id.plan_search_time);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar mCalendar=Calendar.getInstance();
                showTimeDialog();
            }
        });
        return view;
    }




    private void showTimeDialog(){

        final AlertDialog.Builder timeDialog = new AlertDialog.Builder(this.getContext());
        LayoutInflater inflater = LayoutInflater.from(getActivity());
        final View dialogView = inflater.inflate(R.layout.fragment_adv_time_dialog, null);
        final TimePicker timePicker1 = (TimePicker) dialogView.findViewById(R.id.timePicker1);
        timePicker1.setIs24HourView(true);
        final TimePicker timePicker2 = (TimePicker) dialogView.findViewById(R.id.timePicker2);
        timePicker2.setIs24HourView(true);
        if(seted) {
            timePicker1.setHour(hour1);
            timePicker1.setMinute(minute1);
            timePicker2.setHour(hour2);
            timePicker2.setMinute(minute2);
        }
        timeDialog.setTitle("请选择出行时间段");
        timeDialog.setView(dialogView);
        timeDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        hour1 = timePicker1.getHour();
                        hour2 =timePicker2.getHour();
                        minute1 = timePicker1.getMinute();
                        minute2 = timePicker2.getMinute();
                        String s = "";
                        s += timePicker1.getHour() + ":";
                        s += timePicker1.getMinute() + " - ";
                        s += timePicker2.getHour() + ":";
                        s += timePicker2.getMinute();
                        textView.setText(s);
                        seted = true;
                    }
                });
        timeDialog.setNegativeButton("关闭",null);
        // 显示
        timeDialog.show();
    }




}
