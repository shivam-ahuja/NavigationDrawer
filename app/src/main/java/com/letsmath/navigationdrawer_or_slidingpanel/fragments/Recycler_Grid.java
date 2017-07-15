package com.letsmath.navigationdrawer_or_slidingpanel.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.letsmath.navigationdrawer_or_slidingpanel.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recycler_Grid extends Fragment {


    public Recycler_Grid() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment2, container, false);
    }

}
