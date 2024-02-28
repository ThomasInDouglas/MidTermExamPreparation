package com.example.exampreparation;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import java.util.List;

public class SongAdapter extends BaseAdapter {
    // set up data
    List<Song> AdapterSongList;
    // set up the getCount based on data
    // set up constructor to set the data
    // customize getView() method
    public SongAdapter(List<Song> adapterSongList) {
        AdapterSongList = adapterSongList;
    }
    @Override
    public int getCount() {
        return AdapterSongList.size(); // reflects size of data
    }
    @Override
    public Object getItem(int i) {
        return AdapterSongList.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i; // return AdapterSongList.get(i).getSongRaw();
    }
    @Override //i is the index, view is the view item, viewGroup is the listView
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            //inflate external layout
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_songitem,viewGroup, false);
        }
        TextView txtViewSong = view.findViewById(R.id.txtViewSongItem);
        txtViewSong.setText(AdapterSongList.get(i).getSongName());
        txtViewSong.setGravity(Gravity.CENTER_VERTICAL);
        Drawable img = ContextCompat
                .getDrawable(viewGroup.getContext(), AdapterSongList.get(i).getSongPic());
        img.setBounds(0,0,80,80);
        txtViewSong.setCompoundDrawables(img, null, null, null);
        txtViewSong.setCompoundDrawablePadding(8);
        return view;
    }
}
