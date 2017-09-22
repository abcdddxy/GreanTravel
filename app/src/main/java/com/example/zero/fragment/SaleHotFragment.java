package com.example.zero.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.zero.adapter.SaleHotCouponAdapter;
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
    private String[] sale_hot_food_name = new String[]{"麦当劳", "海底捞", "肯德基", "肯德基", "肯德基", "肯德基", "肯德基", "肯德基", "肯德基"};
    private String[] sale_hot_food_price = new String[]{"¥ 30", "¥ 20", "¥ 40", "¥ 40", "¥ 40", "¥ 40", "¥ 40", "¥ 40", "¥ 40"};
    private String[] sale_hot_food_content = new String[]{"券1", "券2", "券3", "券4", "券5", "券6", "券7", "券8", "券9"};
    private int[] sale_hot_food_img = new int[]{R.drawable.mcdonald, R.drawable.haidilao, R.drawable.kfc, R.drawable.kfc, R.drawable.kfc, R.drawable.kfc, R.drawable.kfc, R.drawable.kfc, R.drawable.kfc};

    private String[] sale_hot_ent_name = new String[]{"海底捞", "麦当劳", "肯德基"};
    private String[] sale_hot_ent_price = new String[]{"¥ 20", "¥ 30", "¥ 40"};
    private String[] sale_hot_ent_content = new String[]{"券1", "券2", "券3"};
    private int[] sale_hot_ent_img = new int[]{R.drawable.haidilao, R.drawable.mcdonald, R.drawable.kfc};

    private String[] sale_hot_sp_name = new String[]{"肯德基", "海底捞", "麦当劳"};
    private String[] sale_hot_sp_price = new String[]{"¥ 40", "¥ 20", "¥ 30"};
    private String[] sale_hot_sp_content = new String[]{"券1", "券2", "券3"};
    private int[] sale_hot_sp_img = new int[]{R.drawable.ktv, R.drawable.cinema, R.drawable.zara};

    private String[] sale_hot_tra_name = new String[]{"麦当劳", "海底捞", "肯德基"};
    private String[] sale_hot_tra_price = new String[]{"¥ 30", "¥ 20", "¥ 40"};
    private String[] sale_hot_tra_content = new String[]{"券1", "券2", "券3"};
    private int[] sale_hot_tra_img = new int[]{R.drawable.zara, R.drawable.cinema, R.drawable.ktv};

    private RadioGroup saleHotGroup;
    private RadioButton saleHotFood, saleHotEntertainment, saleHotShopping, saleHotTravel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        sale_hot_frag = inflater.inflate(R.layout.fragment_sale_hot, container, false);
        innitView();
        saleHotFood.setCompoundDrawablesWithIntrinsicBounds(R.drawable.food_checked, 0, 0, 0);
        saleHotEntertainment.setCompoundDrawablesWithIntrinsicBounds(R.drawable.entertainment, 0, 0, 0);
        saleHotShopping.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopping, 0, 0, 0);
        saleHotTravel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.travel, 0, 0, 0);
        showHotCoupon(0);
        context = sale_hot_frag.getContext();
        saleHotGroup = (RadioGroup) sale_hot_frag.findViewById(R.id.sale_hot_rg);
        saleHotGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.sale_hot_food:
                        saleHotFood.setCompoundDrawablesWithIntrinsicBounds(R.drawable.food_checked, 0, 0, 0);//选中时为红色
                        saleHotEntertainment.setCompoundDrawablesWithIntrinsicBounds(R.drawable.entertainment, 0, 0, 0);//未选中的为灰色
                        saleHotShopping.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopping, 0, 0, 0);
                        saleHotTravel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.travel, 0, 0, 0);
                        showHotCoupon(0);
                        break;
                    case R.id.sale_hot_entertainment:
                        saleHotFood.setCompoundDrawablesWithIntrinsicBounds(R.drawable.food, 0, 0, 0);
                        saleHotEntertainment.setCompoundDrawablesWithIntrinsicBounds(R.drawable.entertainment_checked, 0, 0, 0);
                        saleHotShopping.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopping, 0, 0, 0);
                        saleHotTravel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.travel, 0, 0, 0);
                        showHotCoupon(1);
                        break;
                    case R.id.sale_hot_shopping:
                        saleHotFood.setCompoundDrawablesWithIntrinsicBounds(R.drawable.food, 0, 0, 0);
                        saleHotEntertainment.setCompoundDrawablesWithIntrinsicBounds(R.drawable.entertainment, 0, 0, 0);
                        saleHotShopping.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopping_checked, 0, 0, 0);
                        saleHotTravel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.travel, 0, 0, 0);
                        showHotCoupon(2);
                        break;
                    case R.id.sale_hot_travel:
                        saleHotFood.setCompoundDrawablesWithIntrinsicBounds(R.drawable.food, 0, 0, 0);
                        saleHotEntertainment.setCompoundDrawablesWithIntrinsicBounds(R.drawable.entertainment, 0, 0, 0);
                        saleHotShopping.setCompoundDrawablesWithIntrinsicBounds(R.drawable.shopping, 0, 0, 0);
                        saleHotTravel.setCompoundDrawablesWithIntrinsicBounds(R.drawable.travel_checked, 0, 0, 0);
                        showHotCoupon(3);
                    default:
                        break;
                }
            }
        });
        return sale_hot_frag;
    }

    /**
     * 初始化view
     */
    private void innitView() {
        hot_recv = (RecyclerView) sale_hot_frag.findViewById(R.id.sale_hot_recv);
        hot_recv.setLayoutManager(new LinearLayoutManager(context));
        saleHotFood = (RadioButton) sale_hot_frag.findViewById(R.id.sale_hot_food);
        saleHotEntertainment = (RadioButton) sale_hot_frag.findViewById(R.id.sale_hot_entertainment);
        saleHotShopping = (RadioButton) sale_hot_frag.findViewById(R.id.sale_hot_shopping);
        saleHotTravel = (RadioButton) sale_hot_frag.findViewById(R.id.sale_hot_travel);
    }

    /**
     * 优惠券内容加载
     */
    private void showHotCoupon(int num) {
        switch (num) {
            case 0:
                dataList.clear();
                for (int i = 0; i < sale_hot_food_name.length; i++) {
                    SaleBean saleBean = new SaleBean();
                    saleBean.setText(sale_hot_food_name[i], sale_hot_food_price[i], sale_hot_food_content[i], sale_hot_food_img[i]);
                    dataList.add(saleBean);
                }
                break;
            case 1:
                dataList.clear();
                for (int i = 0; i < sale_hot_ent_name.length; i++) {
                    SaleBean saleBean = new SaleBean();
                    saleBean.setText(sale_hot_ent_name[i], sale_hot_ent_price[i], sale_hot_ent_content[i], sale_hot_ent_img[i]);
                    dataList.add(saleBean);
                }
                break;
            case 2:
                dataList.clear();
                for (int i = 0; i < sale_hot_sp_name.length; i++) {
                    SaleBean saleBean = new SaleBean();
                    saleBean.setText(sale_hot_sp_name[i], sale_hot_sp_price[i], sale_hot_sp_content[i], sale_hot_sp_img[i]);
                    dataList.add(saleBean);
                }
                break;
            case 3:
                dataList.clear();
                for (int i = 0; i < sale_hot_tra_name.length; i++) {
                    SaleBean saleBean = new SaleBean();
                    saleBean.setText(sale_hot_tra_name[i], sale_hot_tra_price[i], sale_hot_tra_content[i], sale_hot_tra_img[i]);
                    dataList.add(saleBean);
                }
                break;
            default:
                break;
        }
        SaleHotCouponAdapter adapter = new SaleHotCouponAdapter(sale_hot_frag.getContext(), dataList);
        hot_recv.setAdapter(adapter);
    }
}


