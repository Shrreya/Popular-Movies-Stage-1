package com.example.android.popularmovies;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<String> mPosters;
    private String[] poster_paths;

    String base_url = "http://image.tmdb.org/t/p/w185";
    String LOG_TAG = "ImageAdapter";

    public ImageAdapter(Context c, ArrayList<String> posters) {
        mContext = c;
        mPosters = posters;
        try {
            poster_paths = new String[mPosters.size()];
            for (int i = 0; i < mPosters.size(); i++) {
                poster_paths[i] = base_url + mPosters.get(i);
            }
        } catch (NullPointerException e) {
            Log.e(LOG_TAG, "Error", e);
        }
    }

    @Override
    public int getCount() {
        return poster_paths.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if(convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(185, 278));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        Picasso.with(mContext).load(poster_paths[position]).into(imageView);
        return imageView;
    }
}
