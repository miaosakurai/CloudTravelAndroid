package com.cloudtravel.cloudtravelandroid.main;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.SearchView;
import android.widget.Toast;

import com.baidu.location.BDAbstractLocationListener;
import com.baidu.location.BDLocation;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;
import com.baidu.mapapi.SDKInitializer;
import com.baidu.mapapi.map.BaiduMap;
import com.baidu.mapapi.map.MapStatusUpdate;
import com.baidu.mapapi.map.MapStatusUpdateFactory;
import com.baidu.mapapi.map.MapView;
import com.baidu.mapapi.map.MyLocationData;
import com.baidu.mapapi.model.LatLng;
import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.widget.SearchResultItem;
import com.cloudtravel.cloudtravelandroid.widget.SearchResultItemAdapter;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity {

    public LocationClient mLocationClient;

    private ImageView backImage;
    private Button searchButton;
    private MapView mapView;
    private BaiduMap baiduMap;
    private SearchView searchView;
    private PopupWindow mPopupWindow;
    private RecyclerView recyclerView;

    private boolean isFirstLocate=true;

    private List<SearchResultItem> itemList=new ArrayList<>();

    private static final String TAG = "SearchActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mLocationClient=new LocationClient(getApplicationContext());
        mLocationClient.registerLocationListener(new BDAbstractLocationListener() {
            @Override
            public void onReceiveLocation(BDLocation bdLocation) {
                if(bdLocation.getLocType()==BDLocation.TypeNetWorkLocation
                        ||bdLocation.getLocType()==BDLocation.TypeGpsLocation){
                    //Log.e(TAG, "onReceiveLocation: bdLocation:"+bdLocation.getLatitude()+" "+bdLocation.getLongitude() );
                    navigateTo(bdLocation);
                }
            }
        });
        SDKInitializer.initialize(getApplicationContext());
        setContentView(R.layout.activity_search);
        backImage=(ImageView)findViewById(R.id.back_image);
        backImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivity.this,DiscoverActivity.class);
                startActivity(intent);
            }
        });
        searchButton=(Button)findViewById(R.id.search_button);
        searchView=(SearchView)findViewById(R.id.search_view);
        searchView.setIconified(false);
        mapView=(MapView)findViewById(R.id.baidumap_view);
        baiduMap=mapView.getMap();
        baiduMap.setMyLocationEnabled(true);

        for(int i=0;i<5;i++){
            SearchResultItem item=new SearchResultItem("上海环球港","上海市普陀区中山北路3300号");
            itemList.add(item);
        }
        View popupView=View.inflate(SearchActivity.this,R.layout.search_result_layout,null);
        RecyclerView recyclerView=popupView.findViewById(R.id.search_result_list_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SearchResultItemAdapter adapter=new SearchResultItemAdapter(itemList);
        recyclerView.setAdapter(adapter);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Log.e(TAG, "onClick: 2222222222222222" );
                showPopupWindow();
            }
        });

        init();

        List<String> permissionList=new ArrayList<>();
        if (ContextCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.ACCESS_FINE_LOCATION)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.ACCESS_FINE_LOCATION);
        }
        if (ContextCompat.checkSelfPermission(SearchActivity.this, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            permissionList.add(Manifest.permission.READ_PHONE_STATE);
        }
        if(ContextCompat.checkSelfPermission(SearchActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE)
                !=PackageManager.PERMISSION_GRANTED){
            permissionList.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if(!permissionList.isEmpty()){
            String[] permissions=permissionList.toArray(new String[permissionList.size()]);
            ActivityCompat.requestPermissions(SearchActivity.this,permissions,1);
        }else{
            requestLocation();
        }
    }

    private void requestLocation(){
        initLocation();
        mLocationClient.start();
    }

    private void initLocation(){
        LocationClientOption option=new LocationClientOption();
        option.setScanSpan(5000);
        mLocationClient.setLocOption(option);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){
            case 1:
                if(grantResults.length>0){
                    for(int result:grantResults){
                        if(result!=PackageManager.PERMISSION_GRANTED){
                            Toast.makeText(this,"必须同意所有权限才能使用本程序",Toast.LENGTH_SHORT).show();
                            finish();
                            return;
                        }
                    }
                    requestLocation();
                }else{
                    Toast.makeText(this,"发生未知错误",Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            default:
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLocationClient.stop();
        mapView.onDestroy();
        baiduMap.setMyLocationEnabled(false);
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

    public void init(){

    }

    private void navigateTo(BDLocation location){
        if(isFirstLocate){
            LatLng ll=new LatLng(location.getLatitude(),location.getLongitude());
            //Log.e(TAG, "navigateTo: ll:"+ll.toString() );
            MapStatusUpdate update= MapStatusUpdateFactory.newLatLngZoom(ll,16f);
            baiduMap.animateMapStatus(update);
            isFirstLocate=false;
        }
        MyLocationData.Builder locationBuilder=new MyLocationData.Builder();
        locationBuilder.latitude(location.getLatitude());
        locationBuilder.longitude(location.getLongitude());
        MyLocationData locationData=locationBuilder.build();
        baiduMap.setMyLocationData(locationData);
    }

    private void showPopupWindow(){

        View contentView= getLayoutInflater().inflate(R.layout.search_result_layout,null);
        mPopupWindow=new PopupWindow(contentView, 3000,1000);
        mPopupWindow.setFocusable(true);
        mPopupWindow.setOutsideTouchable(true);
        mPopupWindow.setBackgroundDrawable(new BitmapDrawable());
        mPopupWindow.update();
        View rootView= LayoutInflater.from(SearchActivity.this).inflate(R.layout.activity_search,null);
        mPopupWindow.showAtLocation(rootView, Gravity.BOTTOM,0,0);
        //Log.e(TAG, "showPopupWindow: 3333333333333333333333");
        recyclerView=contentView.findViewById(R.id.search_result_list_view);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        SearchResultItemAdapter adapter=new SearchResultItemAdapter(itemList);
        recyclerView.setAdapter(adapter);
    }
}

