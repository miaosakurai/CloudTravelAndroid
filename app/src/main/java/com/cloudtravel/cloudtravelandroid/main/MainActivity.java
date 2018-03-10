package com.cloudtravel.cloudtravelandroid.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.Window;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseActivity;

import java.util.ArrayList;

public class MainActivity extends CloudTravelBaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        hideTitleBar();
        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_discover,"发现")
                        .setActiveColorResource(R.color.my_green))
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_calendar,"日程")
                        .setActiveColorResource(R.color.my_orange))
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_paper_plane,"分享")
                        .setActiveColorResource(R.color.my_grey_blue))
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_user,"我")
                        .setActiveColorResource(R.color.my_dark_blue))
                .setFirstSelectedPosition(0)
                .initialise();
        fragments = getFragments();
        bottomNavigationBar.setTabSelectedListener(this);
        onTabSelected(0);
    }

    @Override
    public void onTabSelected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        fragment = new DiscoverFragment();
                        //setTitleString("发现");
                        break;
                    case 1:
                        fragment = new ScheduleFragment();
                        //setTitleString("日程");
                        break;
                    case 2:
                        fragment = new MomentsFragment();
                        //setTitleString("分享");
                        break;
                    case 3:
                        fragment = new HomeFragment();
                        //setTitleString("我");
                    default:
                        break;
                }
                fragments.remove(position);
                fragments.add(position, fragment);
                if (fragment.isAdded()) {
                    fragmentTransaction.replace(R.id.frame_layout, fragment);
                } else {
                    fragmentTransaction.add(R.id.frame_layout, fragment);
                }
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new DiscoverFragment());
        fragments.add(new ScheduleFragment());
        fragments.add(new MomentsFragment());
        fragments.add(new HomeFragment());
        return fragments;
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                Fragment fragment = fragments.get(position);
                fragmentTransaction.remove(fragment);
                fragmentTransaction.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
