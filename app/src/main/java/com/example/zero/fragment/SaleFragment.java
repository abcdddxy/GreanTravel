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

public class SaleFragment extends Fragment{

    private RadioGroup saleGroup;
    private SaleFragmentController controller;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sale, container, false);
        controller = SaleFragmentController.getInstance(this, R.id.sale_frag_content);
        controller.showFragment(0);
        saleGroup = (RadioGroup) view.findViewById(R.id.sale_frag_rg);
        saleGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sale_hot:
                        controller.showFragment(0);
                        break;
                    case R.id.sale_my:
                        controller.showFragment(1);
                    default:
                        break;
                }
            }
        });
        return view;
    }
}
