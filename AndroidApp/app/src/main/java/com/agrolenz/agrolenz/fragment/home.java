package com.agrolenz.agrolenz.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.agrolenz.agrolenz.MainActivity;
import com.agrolenz.agrolenz.R;
import com.agrolenz.agrolenz.activity.Redirect;

public class home extends Fragment {
    public final String PLANT_ID="com.agrolenz.plantid";
    public home() {
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);
        GridView gridView=(GridView)rootView.findViewById(R.id.gridView);
        gridView.setAdapter(new ImageAdapter(getContext()));
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Intent intent = new Intent(getContext(), Redirect.class);
                intent.putExtra(PLANT_ID,position);
                startActivity(intent);
            }
        });

        return rootView;
    }
}
