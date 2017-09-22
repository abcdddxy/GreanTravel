package com.example.zero.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zero.adapter.SaleMyCouponAdapter;
import com.example.zero.bean.SaleBean;
import com.example.zero.greentravel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojo on 2017/9/13.
 */

public class SaleMyFragment extends Fragment {

    private View sale_my_frag;
    private RecyclerView my_recv;
    private List<SaleBean> dataList = new ArrayList<>();
    private Context context;
    private String[] sale_my_name = new String[]{"海底捞枫蓝店", "麦当劳", "肯德基", "麦当劳", "肯德基", "肯德基", "肯德基"};
    private String[] sale_my_price = new String[]{"¥ 20", "¥ 30", "¥ 40", "¥ 50", "¥ 60", "¥ 60", "¥ 60"};
    private String[] sale_my_content = new String[]{"券1", "券2", "券3", "券4", "券5", "券6", "券7"};
    private int[] sale_my_img = new int[]{R.drawable.haidilao, R.drawable.mcdonald, R.drawable.kfc, R.drawable.mcdonald, R.drawable.kfc, R.drawable.kfc, R.drawable.kfc};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sale_my_frag = inflater.inflate(R.layout.fragment_sale_my, container, false);
        innitView();
        showMyDiscount();
        context = sale_my_frag.getContext();
        return sale_my_frag;
    }

    /**
     * 初始化view
     */
    private void innitView() {
        my_recv = (RecyclerView) sale_my_frag.findViewById(R.id.sale_my_recv);
        my_recv.setLayoutManager(new LinearLayoutManager(context));
    }

    /**
     * 优惠券内容加载
     */
    private void showMyDiscount() {
        for (int i = 0; i < sale_my_name.length; i++) {
            SaleBean saleBean = new SaleBean();
            saleBean.setText(sale_my_name[i], sale_my_price[i], sale_my_content[i], sale_my_img[i]);
            dataList.add(saleBean);
        }
        SaleMyCouponAdapter adapter = new SaleMyCouponAdapter(sale_my_frag.getContext(), dataList);
        my_recv.setAdapter(adapter);
    }

}
