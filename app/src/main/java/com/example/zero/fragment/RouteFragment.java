package com.example.zero.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.example.zero.greentravel.R;

/**
 * Created by zero on 2017/8/7.
 */

public class RouteFragment extends Fragment {

    private RadioGroup rGroup;
    private RouteFragmentController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_route, container, false);
        controller = RouteFragmentController.getInstance(this, R.id.route_frg_content);
        controller.showFragment(0);
        rGroup = (RadioGroup) view.findViewById(R.id.route_rg);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.route_rb_1:
                        controller.showFragment(0);
                        break;
                    case R.id.route_rb_2:
                        controller.showFragment(1);
                    default:
                        break;
                }
            }
        });
        return view;
    }
}

