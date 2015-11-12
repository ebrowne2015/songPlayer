package com.example.r00064165.songplayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by R00064165 on 12/11/2015.
 */
public class songController {


    private static final int YOUTUBE_URL_INDEX = 0;
    private static final int ARTIST_INDEX = 1;
    private static final int SONG_TITLE_INDEX = 2;



    public static ArrayList<Song> readSongsFromStream(InputStream ioStream) {
        ArrayList<Song> songs = new ArrayList<Song>();
        try {
            // Read through the file line by line
            InputStreamReader ioStreamReader = new InputStreamReader(ioStream);
            BufferedReader br = new BufferedReader(ioStreamReader);

            //Each Line is in the following form :youtube url#Artist#song Title
            //eg Https//www.youtube.com/watch/sdhakhgfa
            //We split each string and creat a Song Object

            String currLine = "";
            while ((currLine = br.readLine()) != null);
            {
                String[] parts = currLine.split("#");


                Song songNew = new Song(parts[YOUTUBE_URL_INDEX], parts[ARTIST_INDEX],parts[SONG_TITLE_INDEX]);
                songs.add(songNew);
            }

        } catch (Exception ioex) {
            System.out.println(ioex.getMessage());
        }
        return songs;
    }


    }

