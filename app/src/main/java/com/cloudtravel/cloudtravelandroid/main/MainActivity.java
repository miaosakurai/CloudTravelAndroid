package com.cloudtravel.cloudtravelandroid.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.TextView;
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
        setTitleString("123");
        //showBackIcon();
        //showTitleBar();
        initView();
    }

    private void initView() {
        BottomNavigationBar bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_SHIFTING);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);

        bottomNavigationBar
                //.addItem(new BottomNavigationItem(R.drawable.location, "定位").setActiveColorResource(R.color.orange))
                .addItem(new BottomNavigationItem(R.drawable.share, "发现").setActiveColorResource(R.color.blue))
                //.addItem(new BottomNavigationItem(R.drawable.search, "搜索").setActiveColorResource(R.color.blue))
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
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = null;
                switch (position) {
                    case 0:
                        //fragment = MapFragment.newInstance();
                        setTitleString("定位");
                        break;
                    /*case 1:
                        fragment = DiscoverFragment.newInstance();
                        setTitle("发现");
                        break;
                    case 2:
                        fragment = SearchFragment.newInstance();
                        setTitle("搜索");
                        break;*/
                    default:
                        break;
                }
                fragments.remove(position);
                fragments.add(position, fragment);
                if (fragment.isAdded()) {
                    ft.replace(R.id.layFrame, fragment);
                } else {
                    ft.add(R.id.layFrame, fragment);
                }
                ft.commitAllowingStateLoss();
            }
        }

    }

    private ArrayList<Fragment> getFragments() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        //fragments.add(MapFragment.newInstance());
        return fragments;
    }

    @Override
    public void onTabUnselected(int position) {
        if (fragments != null) {
            if (position < fragments.size()) {
                FragmentManager fm = getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                Fragment fragment = fragments.get(position);
                ft.remove(fragment);
                ft.commitAllowingStateLoss();
            }
        }
    }

    @Override
    public void onTabReselected(int position) {

    }
}
