package com.cloudtravel.cloudtravelandroid.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.cloudtravel.cloudtravelandroid.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MomentsFragment extends Fragment {

    private RecyclerView rv_moments;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.main_fragment_moments, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_moments = view.findViewById(R.id.rv_moments);

    }

    public MomentsFragment() {
        // Required empty public constructor
    }

}
