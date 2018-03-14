package com.cloudtravel.cloudtravelandroid.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.List;

public class RoadMapDetailsItemAdapter extends RecyclerView.Adapter<RoadMapDetailsItemAdapter.ViewHolder> {
    private List<RoadMapDetailsItem> mList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        TextView time;
        TextView name;

        public ViewHolder(View view) {
            super(view);
            img = (ImageView) view.findViewById(R.id.image_view);
            time = (TextView) view.findViewById(R.id.time_name);
            name = (TextView) view.findViewById(R.id.dst_name);
        }
    }

    public RoadMapDetailsItemAdapter(List<RoadMapDetailsItem> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.road_map_details, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        RoadMapDetailsItem ele = mList.get(position);
        holder.img.setImageResource(ele.getImage());
        holder.name.setText(ele.getName());
        holder.time.setText(ele.getTime());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}