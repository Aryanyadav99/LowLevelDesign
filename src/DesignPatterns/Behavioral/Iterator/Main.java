package DesignPatterns.Behavioral.Iterator;

import java.util.*;

interface MyIterator<T> {
    boolean hasNext();
    T next();
}

class PlaylistIterator implements MyIterator<String> {
    private List<String> songs;
    private int index = 0;
    public PlaylistIterator(List<String> songs) {
        this.songs = songs;
    }
    @Override
    public boolean hasNext() {
        return index < songs.size();
    }

    @Override
    public String next() {
        return songs.get(index++);
    }
}

class Playlist {
    private List<String> songs = new ArrayList<>();
    public void addSong(String song) {
        songs.add(song);
    }
    public MyIterator<String> createIterator() {
        return new PlaylistIterator(songs);
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Playlist playlist = new Playlist();
        playlist.addSong("Believer");
        playlist.addSong("Perfect");
        playlist.addSong("Blinding Lights");

        MyIterator<String> iterator = playlist.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}