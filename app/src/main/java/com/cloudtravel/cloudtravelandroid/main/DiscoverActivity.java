package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.widget.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

public class DiscoverActivity extends AppCompatActivity {

    private List<Integer> images;
    private List<String> titles;
    private Banner banner;

    private TextView search_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_discover);
        init();
    }

    public void init(){

        search_layout=(TextView)findViewById(R.id.search_bar);
        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(DiscoverActivity.this,SearchActivity.class);
                startActivity(intent);
            }
        });

        images=new ArrayList<>();
        images.add(R.drawable.banner_image_italy);
        images.add(R.drawable.banner_image_maldives);
        images.add(R.drawable.banner_image_paris);
        images.add(R.drawable.banner_image_spain);
        titles=new ArrayList<>();
        titles.add("意大利");
        titles.add("马尔代夫");
        titles.add("巴黎");
        titles.add("西班牙");

        banner =(Banner)findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(images);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(titles);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();
    }
}
