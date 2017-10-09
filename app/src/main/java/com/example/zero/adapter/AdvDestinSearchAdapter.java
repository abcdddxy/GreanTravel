package com.example.zero.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.donkingliang.labels.LabelsView;
import com.example.zero.bean.AdvDestinSearchBean;
import com.example.zero.greentravel.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kazu_0122 on 2017/9/22.
 */

public class AdvDestinSearchAdapter extends RecyclerView.Adapter<AdvDestinSearchAdapter.AdvDestinSearchViewHolder> {

    private Context context;
    private List<AdvDestinSearchBean> dataList;

    public AdvDestinSearchAdapter(Context context, List<AdvDestinSearchBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public AdvDestinSearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AdvDestinSearchViewHolder(LayoutInflater.from(context).inflate(R.layout.adv_destin_item, parent, false));
    }

    @Override
    public void onBindViewHolder(AdvDestinSearchViewHolder holder, int position) {
        holder.title.setText(dataList.get(position).getTitle());
        holder.comments.setText(dataList.get(position).getComments()+"条评论");
        holder.price.setText("￥"+dataList.get(position).getPrice());
        holder.time.setText(dataList.get(position).getTime());
        holder.img.setImageResource(dataList.get(position).getImg());
        holder.ratingBar.setRating(dataList.get(position).getRate());
        holder.labelsView.setLabels(dataList.get(position).getLabels());
        holder.labelsView.setSelects(0);
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class AdvDestinSearchViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView comments;
        private TextView price;
        private TextView time;
        private ImageView img;
        private RatingBar ratingBar;
        private LabelsView labelsView;

        public AdvDestinSearchViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.adv_destin_item_title);
            comments = (TextView) itemView.findViewById(R.id.adv_destin_item_comments);
            price = (TextView) itemView.findViewById(R.id.adv_destin_item_price);
            time = (TextView) itemView.findViewById(R.id.adv_destin_item_keyword);
            img = (ImageView) itemView.findViewById(R.id.adv_destin_item_img);
            ratingBar = (RatingBar) itemView.findViewById(R.id.adv_destin_item_rate);
            labelsView = (LabelsView) itemView.findViewById(R.id.adv_destin_item_labels);
            labelsView.setOnLabelClickListener(new LabelsView.OnLabelClickListener() {
                @Override
                public void onLabelClick(View label, String labelText, int position) {
                    //label是被点击的标签，labelText是标签的文字，position是标签的位置。
                    labelsView.setSelects(0);
                }
            });
        }
    }
}
