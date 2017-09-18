package com.example.zero.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.zero.bean.MsgBean;
import com.example.zero.greentravel.R;

import java.util.List;

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.MsgViewHolder> {

    private Context context;
    private List<MsgBean> dataList;

    public MsgAdapter(Context context, List<MsgBean> dataList) {
        this.context = context;
        this.dataList = dataList;
    }

    @Override
    public MsgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MsgViewHolder(LayoutInflater.from(context).inflate(R.layout.msg_item, parent, false));
    }

    @Override
    public void onBindViewHolder(MsgViewHolder holder, int position) {
        holder.text.setText(dataList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    static class MsgViewHolder extends RecyclerView.ViewHolder {
        private TextView text;

        public MsgViewHolder(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.msg_text);
        }
    }
}
