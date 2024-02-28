package com.example.exampreparation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongAdapter2 extends BaseAdapter {
    // set up data
    List<Song> adapterSongList2;
    int SelectedIndex = -1; // initialize the index to -1 so no song is playing
    public List<Song> getAdapterSongList2() {
        return adapterSongList2;
    }
    public void setAdapterSongList2(List<Song> adapterSongList2) {
        this.adapterSongList2 = adapterSongList2;
        notifyDataSetChanged(); // everytime set up a value, notify called
    }
    public int getSelectedIndex() {
        return SelectedIndex;
    }
    public void setSelectedInd(int selectedIndex) {
        SelectedIndex = selectedIndex;
        notifyDataSetChanged(); // everytime set up a value, notify called
    }
    public SongAdapter2(List<Song> adapterSongList2) {
        this.adapterSongList2 = adapterSongList2;
    }
    @Override
    public int getCount() {
        return adapterSongList2.size();
    }
    @Override
    public Object getItem(int i) {
        return adapterSongList2.get(i);
    }
    @Override
    public long getItemId(int i) {
        return i; // return AdapterSongList.get(i).getSongRaw();
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null){
            view = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.layout_songitem2, viewGroup, false);
        }
        TextView txtViewSong2 = view.findViewById(R.id.txtViewSongItem2);
        ImageView imgViewSong2 = view.findViewById(R.id.imgViewSongItem2);
        ImageView imgViewPlayPause = view.findViewById(R.id.imgViewPlayPause);
        txtViewSong2.setText(adapterSongList2.get(i).getSongName());
        imgViewSong2.setImageResource(adapterSongList2.get(i).getSongPic());
        //imgViewSong2.setImageResource(0); //no image show
        if (i == SelectedIndex) {
            imgViewPlayPause.setImageResource(R.drawable.stop);
        } else {
            imgViewPlayPause.setImageResource(R.drawable.play);
        }
        return view;
    }
}
