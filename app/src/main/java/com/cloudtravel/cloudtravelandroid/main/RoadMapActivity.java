package com.cloudtravel.cloudtravelandroid.main;

import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatus;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.cloudtravel.cloudtravelandroid.R;

import java.util.ArrayList;
import java.util.List;

public class RoadMapActivity extends AppCompatActivity {

    private List<RoadMapDetailsItem> textdstlist = new ArrayList<>();
    private MapView mapView;
    private BaiduMap mBaiduMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        SDKInitializer.initialize(getApplicationContext());
        // Hide actionbar
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.hide();
        }
        //Initialize baidumap
        setContentView(R.layout.activity_road_map);
        // Set layout
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setScrimColor(Color.TRANSPARENT);
        // Button click
        Button button = (Button)findViewById(R.id.bt_back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        // Start code: map
        mapView = (MapView) findViewById(R.id.bmapView);
        mapView = (MapView) findViewById(R.id.bmapView);
//// 不显示缩放比例尺
        mapView.showZoomControls(false);
//// 不显示百度地图Logo
//        mapView.removeViewAt(1);
////百度地图
        mBaiduMap = mapView.getMap();
//// 改变地图状态，使地图显示在恰当的缩放大小
        MapStatus mMapStatus = new MapStatus.Builder().zoom(15).build();
        MapStatusUpdate mMapStatusUpdate = MapStatusUpdateFactory.newMapStatus(mMapStatus);
        mBaiduMap.setMapStatus(mMapStatusUpdate);
        // List

        RoadMapDetailsItem a = new RoadMapDetailsItem("9:00", R.drawable.place_type_icon_mall, "Global");
        textdstlist.add(a);
        RoadMapDetailsItem aa = new RoadMapDetailsItem("10:00", R.drawable.place_type_icon_amusement_park, "Park");
        textdstlist.add(aa);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        RoadMapDetailsItemAdapter tda = new RoadMapDetailsItemAdapter(textdstlist);
        recyclerView.setAdapter(tda);
        recyclerView.addItemDecoration(new RoadMapDetailsItemDecoration());
    }

    @Override
    protected void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mapView.onPause();
    }

    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }
}
