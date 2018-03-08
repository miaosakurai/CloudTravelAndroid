package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class DiscoverActivity extends AppCompatActivity {

    private List<Integer> bannerImages;
    private List<String> bannerTitles;
    private Banner banner;

    private TextView search_layout;
    private BottomNavigationBar bottomNavigationBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        initView();
    }

    public void initView(){

        search_layout=(TextView)findViewById(R.id.search_bar);
        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiscoverActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        bannerImages =new ArrayList<>();
        bannerImages.add(R.drawable.banner_image_italy);
        bannerImages.add(R.drawable.banner_image_maldives);
        bannerImages.add(R.drawable.banner_image_paris);
        bannerImages.add(R.drawable.banner_image_spain);
        bannerTitles =new ArrayList<>();
        bannerTitles.add("意大利");
        bannerTitles.add("马尔代夫");
        bannerTitles.add("巴黎");
        bannerTitles.add("西班牙");

        banner =(Banner)findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(bannerImages);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(bannerTitles);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

        bottomNavigationBar=findViewById(R.id.bottom_navigation_bar);
    }
}
