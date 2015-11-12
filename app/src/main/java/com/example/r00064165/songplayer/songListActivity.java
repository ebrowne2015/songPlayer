package com.example.r00064165.songplayer;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by R00064165 on 12/11/2015.
 */
public class songListActivity extends ListActivity {
    private ArrayList<Song> songList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        InputStream stream = getResources().openRawResource(R.raw.musicList);
        //Call to teh controller
        songList = songController.readSongsFromStream(stream);

        //Set up the Adapter
        ArrayAdapter<Song> songListAdapter = new ArrayAdapter<Song>(this, android.R.layout.simple_List_item_1.songList);
        setListAdapter(songListAdapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id)
    {
        super.onListItemClick(l, v, position,id );
        //Get the selected Song Object
        Song selectedSong = songList.get(position);

    }
     
}
