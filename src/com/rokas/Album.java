package com.rokas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class Album {
    private String name;
    private ArrayList<Song> songs;

    public Album (String name){
        this.name = name;
        songs = new ArrayList<Song>();
    }

    public static Album createAlbum(String name){
        return new Album(name);
    }

    public ArrayList<Song> getSongs() {
        return songs;
    }

    public boolean addSongToAlbum(String title, double duration){

        if(findSong(title) == null){
            Song song = new Song(title, duration);
            songs.add(song);
            return true;
        }
        return false;
    }
    public Song findSong(String title){
        for(Song song: this.songs){
            if(song.getTitle().equals(title)){
                return song;
            }
        }
        return null;

    }



}
