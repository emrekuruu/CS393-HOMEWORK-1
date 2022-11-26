package com.example.HW.Service;


import com.example.HW.Entities.Album;
import com.example.HW.Entities.Artist;
import com.example.HW.Entities.Song;
import com.example.HW.Repositories.AlbumRepository;
import com.example.HW.Repositories.ArtistRepository;
import com.example.HW.Repositories.SongRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class HomeworkService    {

    @Autowired
    AlbumRepository albumRepository;

    @Autowired
    ArtistRepository artistRepository;
    @Autowired
    SongRepository songRepository;

    public Song findSong(int songId){
        return songRepository.findById(songId);
    }
    public Album findAlbum(int albumId){
        return albumRepository.findById(albumId);
    }
    public Artist findArtist(int artistId){
        return artistRepository.findById(artistId);
    }

    public void saveSong(Song song){
        songRepository.save(song);
    }

    // This method saves album with songs
    public void saveAlbum(Album album){
        albumRepository.save(album);
    }

    public void saveArtist(Artist artist){
        artistRepository.save(artist);
    }

    //This method adds a new song to the album whose ID is provided.
    public void addSongToAlbum(int albumId, Song song){
        Album album = findAlbum(albumId);
        album.getSongs().add(song);
        song.setAlbum(album);
        song.setArtist(album.getArtist());
        saveAlbum(album);
        saveSong(song);
    }

    //Changes the artist of an album.
    public void assignArtistToAlbum(int albumId, int artistId){

        //Get the new and the old artist
        Album album = findAlbum(albumId);
        Artist artist = artistRepository.findById(artistId);
        Artist OldArtist = album.getArtist();

        //add-remove the albums
        artist.getAlbums().add(album);
        OldArtist.getAlbums().remove(album);
        album.setArtist(artist);

        //add-remove the songs
        List<Song> songsInTheAlbum = album.getSongs();
        OldArtist.getSongs().removeAll(songsInTheAlbum);
        artist.getSongs().addAll(songsInTheAlbum);

        //change the artist of the songs and save it
        for(Song song : songsInTheAlbum){
            song.setArtist(artist);
            saveSong(song);
        }

        //save everything
        saveArtist(OldArtist);
        saveArtist(artist);
        saveAlbum(album);

    }

    //Deletes an album. Songs related to the album are not deleted.
    public void deleteAlbum(int albumId){

        Album album = findAlbum(albumId);
        List<Song> songs = album.getSongs();

        for (Song song : songs){
            song.setAlbum(null);
            songRepository.save(song);
        }

        albumRepository.delete(album);
    }

    //Deletes the song whose id is given. If the song is associated with an album(or playlist), the album (or playlist) is not deleted
    public void deleteSong(int songId){
        Song song = findSong(songId);
        songRepository.delete(song);
    }

    //Returns all songs related to an artist,including songs in an album

    public List<Song> findSongsWithArtistId(int id){
        List<Song> songs = songRepository.findByArtistId(id);
        return songs;
    }

}
