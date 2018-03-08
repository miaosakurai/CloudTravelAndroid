package com.cloudtravel.cloudtravelandroid.main;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.List;

public class ScheduleItemAdapter extends RecyclerView.Adapter<ScheduleItemAdapter.ViewHolder> {
    private List<ScheduleItem> mList;

    static class ViewHolder extends RecyclerView.ViewHolder {
        ImageView place;
        TextView time;
        TextView position;
        ImageView transpotation;

        public ViewHolder(View view) {
            super(view);
            place = (ImageView) view.findViewById(R.id.schedule_image);
            time = (TextView) view.findViewById(R.id.schedule_time);
            position = (TextView) view.findViewById(R.id.schedule_position);
            transpotation = (ImageView) view.findViewById(R.id.schedule_transpotation);
        }
    }

    public ScheduleItemAdapter(List<ScheduleItem> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_item, parent, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ScheduleItem schedule = mList.get(position);
        holder.place.setImageResource(schedule.getPlaceTypeId());
        holder.position.setText(schedule.getPosition());
        holder.time.setText(schedule.getTime());
        holder.transpotation.setImageResource(schedule.getTransportationId());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

}
