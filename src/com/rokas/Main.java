package com.rokas;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Album> userAlbums = new ArrayList<Album>();
        userAlbums.add(Album.createAlbum("The Wall"));
        userAlbums.get(0).addSongToAlbum("In the Flesh?", 3.16);
        userAlbums.get(0).addSongToAlbum("The thin ice", 2.27);
        userAlbums.get(0).addSongToAlbum("Another brick in the wall", 3.21);

        PlayList playlist1 = new PlayList("Best ones");
        playlist1.addSongToPlayList("In the Flesh?", userAlbums);
        playlist1.addSongToPlayList("The thin ice", userAlbums);
        playlist1.addSongToPlayList("Another brick in the wall", userAlbums);
        playlist1.printSongsInPlaylist();

        startPlayer(playlist1.getSongs());

    }

    public static void startPlayer(LinkedList<Song> songs){
        boolean quit = false;
        boolean isForward = false;
        Scanner scanner = new Scanner(System.in);
        ListIterator<Song> songIterator = songs.listIterator();
        if(songs.isEmpty()){
            quit = true;
            System.out.println("Playlist is empty.");
        }
        printMenu();
        System.out.println("Now is playing " + songIterator.next().getTitle());
        while(!quit){
            int input = scanner.nextInt();
            switch (input){
                case 0:
                    quit = true;
                    break;
                case 1: //next song
                    if (!isForward){ // to move iterator one place forward due to direct access next song
                        if(songIterator.hasNext()){
                            songIterator.next();
                            isForward = true;
                        }
                    }
                    if(songIterator.hasNext()){
                        System.out.println("Now is playing " + songIterator.next().getTitle());
                    } else {
                        System.out.println("You reached the end of the list.");
                    } break;
                case 2: //previous song
                    if (isForward){
                        if(songIterator.hasPrevious()){
                            songIterator.previous();
                            isForward = false;
                        }
                    }
                    if (songIterator.hasPrevious()){
                        System.out.println("Now is playing " + songIterator.previous().getTitle());
                    } else {
                        System.out.println("You are at the begging of the list.");
                    } break;
                case 3: // repeat song
                    if (!isForward){
                        if(songIterator.hasNext()){
                            System.out.println("Now is playing: " + songIterator.next().getTitle());
                            isForward = true;
                        } else {
                            System.out.println("Error. Try to move forward or backward on the playlist");
                        }
                    } else{
                        if (songIterator.hasPrevious()) {
                            System.out.println("Now is playing: " + songIterator.previous().getTitle());
                            isForward = false;
                        } else {
                            System.out.println("Error. Try to move forward or backward on the playlist");
                        }
                    } break;
                case 4: // remove a song
                    if(songs.size() > 0){
                        songIterator.remove();
                        if(songIterator.hasNext()){
                            System.out.println("Now is playing " + songIterator.next());
                        } else if (songIterator.hasPrevious()) {
                            System.out.println("Now is playing " + songIterator.previous());
                        } else if(songs.isEmpty()){
                                quit = true;
                                System.out.println("Playlist is empty. Existing the program");
                            }
                    }
                    break;
                case 5: // print songs on playlist
                    for (int i = 0; i < songs.size(); i++){
                        System.out.println(songs.get(i).getTitle() + " " + songs.get(i).getDuration());
                    }
                case 6:
                    printMenu();
            }
        }
    }

    public static void printMenu(){
        System.out.println("Press 0 for quit the program");
        System.out.println("Press 1 to play next a song");
        System.out.println("Press 2 to play previous a song");
        System.out.println("Press 3 to repeat a song");
        System.out.println("Press 4 to remove a song");
        System.out.println("Press 5 to print songs on playlist");
        System.out.println("Press 6 to show available actions");
    }





}
