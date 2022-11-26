package com.example.HW.Entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_ALBUM")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column
    String name;

    @ManyToOne
    Artist artist;

    @OneToMany(mappedBy = "album")
    List<Song> songs = new ArrayList<>();

    public Album(String name,Artist artist) {
        this.name = name;
        this.artist = artist;
    }

    public Album() {
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

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }


    @Override
    public String toString() {
        return "Album{" +
                "name='" + name + '\'' +
                ", artist=" + artist +
                ", songs=" + songs +
                '}';
    }
}
