package com.example.HW.Entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "T_SONG")
public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @Column
    String name;

    @Column
    int length;

    @ManyToOne
    Album album;

    @ManyToOne
    Artist artist;

    public Song(String name,int length) {
        this.name = name;
        this.length = length;
    }

    public Song() {

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

    public int getLength() {
        return length;
    }

    public Album getAlbum() {
        return album;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", length=" + length +
                ", album=" + album +
                ", artist=" + artist +
                '}';
    }
}
