package com.cloudtravel.cloudtravelandroid.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ScheduleActivity extends AppCompatActivity {

    private List<ScheduleItem> scheduleList = new List<ScheduleItem>() {
        @Override
        public int size() {
            return 0;
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public boolean contains(Object o) {
            return false;
        }

        @NonNull
        @Override
        public Iterator<ScheduleItem> iterator() {
            return null;
        }

        @NonNull
        @Override
        public Object[] toArray() {
            return new Object[0];
        }

        @NonNull
        @Override
        public <T> T[] toArray(@NonNull T[] a) {
            return null;
        }

        @Override
        public boolean add(ScheduleItem scheduleItem) {
            return false;
        }

        @Override
        public boolean remove(Object o) {
            return false;
        }

        @Override
        public boolean containsAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean addAll(@NonNull Collection<? extends ScheduleItem> c) {
            return false;
        }

        @Override
        public boolean addAll(int index, @NonNull Collection<? extends ScheduleItem> c) {
            return false;
        }

        @Override
        public boolean removeAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public boolean retainAll(@NonNull Collection<?> c) {
            return false;
        }

        @Override
        public void clear() {

        }

        @Override
        public ScheduleItem get(int index) {
            return null;
        }

        @Override
        public ScheduleItem set(int index, ScheduleItem element) {
            return null;
        }

        @Override
        public void add(int index, ScheduleItem element) {

        }

        @Override
        public ScheduleItem remove(int index) {
            return null;
        }

        @Override
        public int indexOf(Object o) {
            return 0;
        }

        @Override
        public int lastIndexOf(Object o) {
            return 0;
        }

        @NonNull
        @Override
        public ListIterator<ScheduleItem> listIterator() {
            return null;
        }

        @NonNull
        @Override
        public ListIterator<ScheduleItem> listIterator(int index) {
            return null;
        }

        @NonNull
        @Override
        public List<ScheduleItem> subList(int fromIndex, int toIndex) {
            return null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);
        initSchedule();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.schedule_recyclerview);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        ScheduleItemAdapter scheduleAdapter = new ScheduleItemAdapter(scheduleList);
        recyclerView.setAdapter(scheduleAdapter);
    }
    private void initSchedule(){
            ScheduleItem schedule_a = new ScheduleItem("9:00", R.drawable.place_type_icon_mall, "环球港", R.drawable.transportation_icon_walk);
            scheduleList.add(schedule_a);
            ScheduleItem schedule_b = new ScheduleItem("10:00", R.drawable.place_type_icon_restaurant, "火锅店", R.drawable.transportation_icon_bike);
            scheduleList.add(schedule_b);
            ScheduleItem schedule_c = new ScheduleItem("10:00", R.drawable.place_type_icon_amusement_park, "迪士尼", R.drawable.transportation_icon_subway);
            scheduleList.add(schedule_c);
            ScheduleItem schedule_d = new ScheduleItem("10:00", R.drawable.place_type_icon_flight_land, "火锅店", R.drawable.transportation_icon_taxi);
            scheduleList.add(schedule_d);
    }
}
