package com.cloudtravel.cloudtravelandroid.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.List;

/**
 * Created by KingJ on 2018/3/13.
 */

public class CircleBtnItemAdapter extends RecyclerView.Adapter<CircleBtnItemAdapter.ViewHolder>{
    private List<CircleBtnItem> mList;

    static class ViewHolder extends  RecyclerView.ViewHolder{
        TextView date;

        public ViewHolder(View view){
            super(view);
            date = (TextView) view.findViewById(R.id.circle_btn);
        }
    }

    public CircleBtnItemAdapter(List<CircleBtnItem> mList) {
        this.mList = mList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.circle_btn_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        CircleBtnItem circleBtn = mList.get(position);
        holder.date.setText(circleBtn.getDate());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
