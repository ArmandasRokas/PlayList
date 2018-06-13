package com.rokas;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class PlayList {
    private String name;
    private LinkedList<Song> songs;

    public PlayList(String name){
        this.name = name;
        songs = new LinkedList<Song>();
    }

    public LinkedList<Song> getSongs(){
        return songs;
    }

    private Song getSong(String songTitle, ArrayList<Album> albums){
        for(Album album: albums){
            for (Song song: album.getSongs()){
                if(song.getTitle().equals(songTitle)){
                    return song;
                }
            }
        }
        return null;
    }

    public boolean addSongToPlayList(String songTitle, ArrayList<Album> albums){
        Song song = getSong(songTitle, albums);

        if ( song != null){

            for (Song songInPlaylist: songs){
                if (songInPlaylist.getTitle().equals(songTitle)){
                    return false;
                }
            }
            songs.add(song);
            return true;
        } else {
            System.out.println("Song does not exist in albums");
            return false;
        }
    }


    public void printSongsInPlaylist(){
        Iterator<Song> songIterator = songs.iterator();
        System.out.println("Songs in playlist:");
        while(songIterator.hasNext()){
            Song song = songIterator.next();
            System.out.println(song.getTitle() + " " + song.getDuration());
        }
    }


}
