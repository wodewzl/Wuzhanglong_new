package com.beisheng.snatch.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.beisheng.snatch.R;
import com.beisheng.snatch.model.DiscoverIndexVO;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ActiviesAdapter extends RecyclerView.Adapter implements View.OnClickListener {

    private OnItemClickListener onItemClickListener;

    private List<DiscoverIndexVO.DataBean.ListBean> list;

    private Context context;

    public ActiviesAdapter(Context context,List<DiscoverIndexVO.DataBean.ListBean> list) {
        this.context=context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View view = null;

        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_activies, parent, false);
        viewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

        MyViewHolder viewHolder = (MyViewHolder) holder;
        viewHolder.itemView.setTag(position);
//
        DiscoverIndexVO.DataBean.ListBean listBean = list.get(position);
        viewHolder.tv_activities_title.setText(listBean.getTitle());
        viewHolder.tv_activitiew_content.setText(listBean.getDesc());
        Picasso.with(context).load(listBean.getIcon()).into(viewHolder.iv_activities);


    }

    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        } else {
            return list.size();
        }
    }

    @Override
    public void onClick(View v) {
        int position = (int) v.getTag();
        if(onItemClickListener!=null){
            String title = list.get(position).getTitle();

            String url = list.get(position).getUrl();
            onItemClickListener.onItemClick(v,position,title,url);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view, int position ,String title,String url);
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        public View itemView;
        public ImageView iv_activities;
        public TextView tv_activities_title;
        public TextView tv_activitiew_content;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            iv_activities=itemView.findViewById(R.id.iv_activities);
            tv_activities_title=itemView.findViewById(R.id.tv_activities_title);
            tv_activitiew_content=itemView.findViewById(R.id.tv_activitiew_content);

        }
    }
}
