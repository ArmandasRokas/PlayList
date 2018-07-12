package com.rokas;

import java.util.ArrayList;

public class Album {
    private String name;
    private SongList songList;


    public Album (String name){
        this.name = name;
        songList = new SongList();
    }

    public static Album createAlbum(String name){
        return new Album(name);
    }

    public ArrayList<Song> getSongs() {

        return songList.getSongs();
    }

    public boolean addSongToAlbum(String title, double duration){

        return songList.addSongToAlbum(title, duration);

    }

// inner class. Ikke sikker, hvad er formål
    private class SongList {
        private ArrayList<Song> songs;

        public SongList(){
            songs = new ArrayList<Song>();
        }

        public ArrayList<Song> getSongs(){
            return songs;
        }

        public boolean addSongToAlbum(String title, double duration) {

            if (findSong(title) == null) {
                Song song = new Song(title, duration);
                songs.add(song);
                return true;
            }
            return false;
        }

        public Song findSong(String title) {
            for (Song song : this.songs) {
                if (song.getTitle().equals(title)) {
                    return song;
                }
            }
            return null;

        }
    }



}
