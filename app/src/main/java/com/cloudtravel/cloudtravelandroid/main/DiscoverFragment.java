package com.cloudtravel.cloudtravelandroid.main;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
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
    private List<PlaceRcmd> placeRcmdList=new ArrayList<>();
    private PlaceRcmdAdapter adapter;
    private RecyclerView recyclerView;

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
        bannerTitles.add("Venice");
        bannerTitles.add("Maldives, the land of idyllic beauty");
        bannerTitles.add("Eiffel Tower");
        bannerTitles.add("Piazza di Spagna");
        banner = view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        banner.setImageLoader(new GlideImageLoader());
        banner.setImages(bannerImages);
        banner.setBannerAnimation(Transformer.DepthPage);
        banner.setBannerTitles(bannerTitles);
        banner.isAutoPlay(true);
        banner.setDelayTime(6000);
        banner.setIndicatorGravity(BannerConfig.CENTER);
        banner.start();

        placeRcmdList.add(new PlaceRcmd("5 amazing Dim Sum Restaurants in Shanghai",
                "Shanghai",R.drawable.dim_sum_restaurant));
        placeRcmdList.add(new PlaceRcmd("Recommended Spas in Shanghai",
                "Shanghai",R.drawable.spas));
        placeRcmdList.add(new PlaceRcmd("Shanghai nights and smuggling days",
                "Shanghai",R.drawable.night));
        placeRcmdList.add(new PlaceRcmd("A day to the ancient water town",
                "Shanghai",R.drawable.ancient_watertown));
        placeRcmdList.add(new PlaceRcmd("In the spotlight South Bund Fabric Market",
                "Shanghai",R.drawable.fabric_market));
        placeRcmdList.add(new PlaceRcmd("Water house at the Bund, Shanghai/China",
                "Shanghai",R.drawable.water_house));
        recyclerView=view.findViewById(R.id.recycler_view);
        GridLayoutManager layoutManager=new GridLayoutManager(this.getActivity(),2);
        recyclerView.setLayoutManager(layoutManager);
        adapter=new PlaceRcmdAdapter(placeRcmdList);
        recyclerView.setAdapter(adapter);

        return view;
    }

    /*public static String ToDBC(String input) {
        char[] c = input.toCharArray();
        for (int i = 0; i< c.length; i++) {
            if (c[i] == 12288) {
                c[i] = (char) 32;
                continue;
            }if (c[i]> 65280&& c[i]< 65375)
                c[i] = (char) (c[i] - 65248);
        }
        return new String(c);
    }*/
}
