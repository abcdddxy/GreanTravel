package com.example.zero.view;

import android.content.ClipData;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.PopupMenu;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.zero.fragment.RouteFragment;
import com.example.zero.fragment.RouteFragmentController;
import com.example.zero.greentravel.R;

/**
 * Created by ZERO on 2017/10/19.
 */

public class TitleRouteLayout extends LinearLayout{

    public TitleRouteLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.title_route, this);

        final Button model = (Button) findViewById(R.id.title_btn_model);
        final Button more = (Button) findViewById(R.id.title_btn_more);

        more.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "More info", Toast.LENGTH_SHORT).show();
            }
        });
        model.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //创建弹出式菜单对象（最低版本11）
                PopupMenu popup = new PopupMenu(getContext(), view);//第二个参数是绑定的那个view
                //获取菜单填充器
                MenuInflater inflater = popup.getMenuInflater();
                //填充菜单
                inflater.inflate(R.menu.route_model_menu, popup.getMenu());
                //绑定菜单项的点击事件
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener(){
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.single_model:
                                Toast.makeText(getContext(), "Single", Toast.LENGTH_SHORT).show();
                                model.setText("单人模式");
                                break;
                            case R.id.multi_model:
                                Toast.makeText(getContext(), "Multi", Toast.LENGTH_SHORT).show();
                                model.setText("多人模式");
                                break;
                            default:
                                break;
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }
}
