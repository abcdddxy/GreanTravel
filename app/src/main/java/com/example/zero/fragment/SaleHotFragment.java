package com.example.zero.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.zero.adapter.SaleHotDiscountAdapter;
import com.example.zero.bean.SaleBean;
import com.example.zero.greentravel.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jojo on 2017/9/13.
 */

public class SaleHotFragment extends Fragment {

    private View sale_hot_frag;
    private RecyclerView hot_recv;
    private List<SaleBean> dataList = new ArrayList<>();
    private Context context;
    private String[] sale_hot_name= new String[]{"麦当劳", "海底捞枫蓝店", "肯德基", "肯德基", "肯德基", "肯德基", "肯德基", "肯德基", "肯德基"};
    private String[] sale_hot_price = new String[]{"¥ 30", "¥ 20", "¥ 40", "¥ 40", "¥ 40", "¥ 40", "¥ 40", "¥ 40", "¥ 40"};
    private String[] sale_hot_content = new String[]{"券1", "券2", "券3", "券4", "券5", "券6", "券7", "券8", "券9"};
    private int[] sale_hot_img = new int[]{R.drawable.sale_img2, R.drawable.sale_img1, R.drawable.sale_img3, R.drawable.sale_img3, R.drawable.sale_img3, R.drawable.sale_img3, R.drawable.sale_img3, R.drawable.sale_img3, R.drawable.sale_img3};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sale_hot_frag = inflater.inflate(R.layout.fragment_sale_hot, container, false);
        innitView();
        showHotDiscount();
        context = sale_hot_frag.getContext();
        return sale_hot_frag;
    }

    private void innitView() {
        hot_recv = (RecyclerView) sale_hot_frag.findViewById(R.id.sale_hot_recv);
        hot_recv.setLayoutManager(new LinearLayoutManager(context));
    }

    /**
     * 优惠券内容加载
     */

    private void showHotDiscount() {
        for (int i = 0; i < sale_hot_name.length; i++) {
            SaleBean saleBean = new SaleBean();
            saleBean.setText(sale_hot_name[i], sale_hot_price[i], sale_hot_content[i]);
            saleBean.setImage(sale_hot_img[i]);
            dataList.add(saleBean);
        }

        SaleHotDiscountAdapter adapter = new SaleHotDiscountAdapter(sale_hot_frag.getContext(), dataList);
        hot_recv.setAdapter(adapter);
    }

}
