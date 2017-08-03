package com.agrolenz.agrolenz.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.agrolenz.agrolenz.R;

/**
 * Created by lbclimax on 7/29/2017.
 */

public class ImageAdapter extends BaseAdapter {
    private Context mContext;

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return mThumbIds.length;
    }

    public Object getItem(int position) {
        return null;
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            LayoutInflater inflater = (LayoutInflater) mContext
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.home_icon, null);
        } else {
            view = convertView;
        }


        TextView title= (TextView) view.findViewById(R.id.title);
        title.setText(titles[position]);

        ImageView i = (ImageView) view.findViewById(R.id.image);
        i.setImageResource(mThumbIds[position]);
        i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        i.setPadding(0, 0, 0,0);

        return view;
    }
//// TODO: 7/30/2017 make class to handle the list of crop and their image 
    // references to our images
    private Integer[] mThumbIds = {
            R.drawable.tomato,
            R.drawable.maize,
            R.drawable.watermelon,
            R.drawable.potatoes,
    };
    private String[] titles = {
           "nyanya",
            "mahindi",
            "matikiti",
            "viazi"
    };
}
