package com.cloudtravel.cloudtravelandroid.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private List<ScheduleItem> scheduleList = new ArrayList<>();

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        initSchedule();
        RecyclerView recyclerView = view.findViewById(R.id.schedule_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        ScheduleItemAdapter scheduleAdapter = new ScheduleItemAdapter(scheduleList);
        recyclerView.setAdapter(scheduleAdapter);

        return view;
    }

    private void initSchedule(){
        ScheduleItem schedule_a = new ScheduleItem("09:00", R.drawable.place_type_icon_mall, "环球港", R.drawable.transportation_icon_walk);
        scheduleList.add(schedule_a);
        ScheduleItem schedule_b = new ScheduleItem("10:00", R.drawable.place_type_icon_restaurant, "火锅店", R.drawable.transportation_icon_bike);
        scheduleList.add(schedule_b);
        ScheduleItem schedule_c = new ScheduleItem("10:00", R.drawable.place_type_icon_amusement_park, "迪士尼", R.drawable.transportation_icon_subway);
        scheduleList.add(schedule_c);
        ScheduleItem schedule_d = new ScheduleItem("10:00", R.drawable.place_type_icon_flight_land, "火锅店", R.drawable.transportation_icon_taxi);
        scheduleList.add(schedule_d);
    }

}
