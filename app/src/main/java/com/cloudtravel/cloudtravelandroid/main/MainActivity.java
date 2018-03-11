package com.cloudtravel.cloudtravelandroid.main;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.view.Window;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.cloudtravel.cloudtravelandroid.R;
import com.cloudtravel.cloudtravelandroid.base.CloudTravelBaseActivity;
import java.lang.reflect.Field;
import java.util.ArrayList;
import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends CloudTravelBaseActivity implements BottomNavigationBar.OnTabSelectedListener {
    private ArrayList<Fragment> fragments;
    private CircleImageView headPortrait;
    private DrawerLayout mDrawerLayout;
    private TextView toolBarTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        super.hideTitleBar();
        mDrawerLayout=findViewById(R.id.drawer_layout);
        headPortrait =findViewById(R.id.tool_bar_head_portrait);
        headPortrait.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDrawerLayout.openDrawer(GravityCompat.START);
            }
        });
        toolBarTitle=findViewById(R.id.tool_bar_title);
        hideTitleBar();
        BottomNavigationBar bottomNavigationBar = findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_RIPPLE);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_discover,"Discover")
                        .setActiveColorResource(R.color.my_green))
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_calendar,"Schedule")
                        .setActiveColorResource(R.color.my_orange))
                .addItem(new BottomNavigationItem(R.drawable.navigation_icon_paper_plane,"Share")
                        .setActiveColorResource(R.color.my_grey_blue))
                .setFirstSelectedPosition(0)
                .initialise();
        setBottomNavigationItem(bottomNavigationBar,4,24,18);
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
                        setTitleString("发现");
                        break;
                    case 1:
                        fragment = new ScheduleFragment();
                        setTitleString("日程");
                        break;
                    case 2:
                        fragment = new MomentsFragment();
                        setTitleString("分享");
                        break;
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

    private void setBottomNavigationItem(BottomNavigationBar bottomNavigationBar, int space, int imgLen, int textSize){
        Class barClass = bottomNavigationBar.getClass();
        Field[] fields = barClass.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            if(field.getName().equals("mTabContainer")){
                try{
                    //反射得到 mTabContainer
                    LinearLayout mTabContainer = (LinearLayout) field.get(bottomNavigationBar);
                    for(int j = 0; j < mTabContainer.getChildCount(); j++){
                        //获取到容器内的各个Tab
                        View view = mTabContainer.getChildAt(j);
                        //获取到Tab内的各个显示控件
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(56));
                        FrameLayout container = (FrameLayout) view.findViewById(R.id.fixed_bottom_navigation_container);
                        container.setLayoutParams(params);
                        container.setPadding(dip2px(12), dip2px(0), dip2px(12), dip2px(0));
                        //获取到Tab内的文字控件
                        TextView labelView = (TextView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title);
                        //计算文字的高度DP值并设置，setTextSize为设置文字正方形的对角线长度，所以：文字高度（总内容高度减去间距和图片高度）*根号2即为对角线长度，此处用DP值，设置该值即可。
                        labelView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, textSize);
                        labelView.setIncludeFontPadding(false);
                        labelView.setPadding(0,0,0,dip2px(20-textSize - space/2));
                        //获取到Tab内的图像控件
                        ImageView iconView = (ImageView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon);
                        //设置图片参数，其中，MethodUtils.dip2px()：换算dp值
                        params = new FrameLayout.LayoutParams(dip2px(imgLen), dip2px(imgLen));
                        params.setMargins(0,0,0,space/2);
                        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                        iconView.setLayoutParams(params);
                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public int dip2px(float dpValue) {
        final float scale = getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    @Override
    protected void setTitleString(String title) {
        toolBarTitle.setText(title);
    }

    @Override
    protected void setTitleId(int id) {
        toolBarTitle.setText(id);
    }
}
