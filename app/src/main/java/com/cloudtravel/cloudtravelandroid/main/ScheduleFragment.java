package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.cloudtravel.cloudtravelandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScheduleFragment extends Fragment {

    private List<ScheduleItem> scheduleList = new ArrayList<>();
    private List<CircleBtnItem> circleBtnList = new ArrayList<>();
    private ImageView add_schedule;
    private Button createSchedule;

    public ScheduleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_schedule, container, false);
        initCircleBtn();
        RecyclerView btnRecyclerView = view.findViewById(R.id.circle_btn_recyclerview);
        LinearLayoutManager btnLayoutManager = new LinearLayoutManager(getContext());
        btnLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        btnRecyclerView.setLayoutManager(btnLayoutManager);
        CircleBtnItemAdapter circleBtnItemAdapter = new CircleBtnItemAdapter(circleBtnList);
        btnRecyclerView.setAdapter(circleBtnItemAdapter);

        initSchedule();
        RecyclerView scheduleRecyclerView = view.findViewById(R.id.schedule_recyclerview);
        LinearLayoutManager ScheduleLayoutManager = new LinearLayoutManager(getContext());
        scheduleRecyclerView.setLayoutManager(ScheduleLayoutManager);
        ScheduleItemAdapter scheduleAdapter = new ScheduleItemAdapter(scheduleList);
        scheduleRecyclerView.setAdapter(scheduleAdapter);

        add_schedule= view.findViewById(R.id.add_schedule);
        add_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(),AddScheduleActivity.class);
                startActivity(intent);
            }
        });
        createSchedule= view.findViewById(R.id.creat_schedule);
        createSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),RoadMapActivity.class);
                startActivity(intent);
            }
        });

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


    private void initCircleBtn(){
        for (int i = 1; i < 31; i++){
            CircleBtnItem circleBtnItem = new CircleBtnItem(Integer.toString(i));
            circleBtnItem.setDate(Integer.toString(i));
            circleBtnList.add(circleBtnItem);
        }
    }
}
