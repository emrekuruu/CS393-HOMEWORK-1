package com.example.HW.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_ARTIST")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @OneToMany(mappedBy = "artist")
    List<Song> songs;

    @OneToMany(mappedBy = "artist")
    List<Album> albums = new ArrayList<>();

    public Artist(String name,List<Song> songs, List<Album> albums) {
        this.name = name;
        this.songs = songs;
        this.albums = albums;
    }

    public Artist() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    public void setAlbums(List<Album> albums) {
        this.albums = albums;
    }


    @Override
    public String toString() {
        return "Artist{" +
                "name='" + name + '\'' +
                ", songs=" + songs +
                ", albums=" + albums +
                '}';
    }
}
