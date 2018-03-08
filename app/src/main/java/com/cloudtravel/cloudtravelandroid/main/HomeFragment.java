package com.cloudtravel.cloudtravelandroid.main;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cloudtravel.cloudtravelandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private TextView tv_collection;
    private TextView tv_information;
    private TextView tv_setting;


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        tv_collection=view.findViewById(R.id.tv_collection);
        tv_information=view.findViewById(R.id.tv_information);
        tv_setting=view.findViewById(R.id.tv_setting);

        return view;
    }

}
