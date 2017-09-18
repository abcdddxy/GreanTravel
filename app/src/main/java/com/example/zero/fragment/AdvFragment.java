package com.example.zero.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;


import com.example.zero.greentravel.R;

/**
 * Created by zero on 2017/8/7.
 */

public class AdvFragment extends Fragment {

    private AdvFragmentController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_adv, container, false);
        controller = AdvFragmentController.getInstance(this, R.id.adv_frg_content);
        controller.showFragment(0);
        Button plan = (Button) view.findViewById(R.id.plan);
        Button destination = (Button) view.findViewById(R.id.destination);
        plan.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showFragment(1);
            }
        });
        destination.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                controller.showFragment(0);
            }
        });
        return view;
    }
}
