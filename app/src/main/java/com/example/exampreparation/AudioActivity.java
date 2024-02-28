package com.example.exampreparation;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AudioActivity extends AppCompatActivity {

    List<String> SongNames = new ArrayList<>(Arrays.asList("Bag Pipes", "Ukele", "Drums"));
    List<Integer> SongPics = new ArrayList<>(Arrays.asList(R.drawable.bagpipes, R.drawable.ukulele, R.drawable.drums));
    List<Integer> SongRaws = new ArrayList<>(Arrays.asList(R.raw.bagpipes,R.raw.ukulele,R.raw.drums));
    List<Song> SongList = new ArrayList<>();
    MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);
        LoadModelData();
        ListView listViewSongs = findViewById(R.id.listViewSongs);
        //Create adapter object
        //SongAdapter songAdapter = new SongAdapter(SongList);
        SongAdapter2 songAdapter2 = new SongAdapter2(SongList);
        listViewSongs.setAdapter(songAdapter2);
        listViewSongs.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                /*
                switch (i){
                    case 0:
                        Toast.makeText(AudioActivity.this, "Clicked on Bagpies", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(AudioActivity.this, "Clicked on Ukele", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(AudioActivity.this, "Clicked on drums", Toast.LENGTH_SHORT).show();
                }
                 */
                if (mediaPlayer != null && mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                if (songAdapter2.getSelectedIndex() == i ){
                    songAdapter2.setSelectedInd(-1);
                } else {
                    mediaPlayer = MediaPlayer.create(AudioActivity.this, SongList.get(i).getSongRaw());
                    mediaPlayer.start();
                    songAdapter2.setSelectedInd(i);
                }
            }
        });
    }
    private void LoadModelData(){
        for (int i = 0; i < SongNames.size(); i++){
            Song eachSong = new Song(SongNames.get(i), SongPics.get(i), SongRaws.get(i));
            SongList.add(eachSong); // add needs to have at least an empty list, list should not be null
        }
    }
}