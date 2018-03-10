package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DiscoverFragment extends Fragment {

    private List<Integer> bannerImages;
    private List<String> bannerTitles;
    private Banner banner;
    private TextView search_layout;


    public DiscoverFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_discover, container, false);
        search_layout=view.findViewById(R.id.search_bar);
        search_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SearchActivity.class);
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
        banner = view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(bannerImages);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(bannerTitles);
        banner.isAutoPlay(true);
        banner.setDelayTime(3000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

        return view;
    }

}
