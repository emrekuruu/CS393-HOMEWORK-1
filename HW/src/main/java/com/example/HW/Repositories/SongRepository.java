package com.example.HW.Repositories;

import com.example.HW.Entities.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SongRepository extends JpaRepository<Song,Integer> {

    public Song findById(int songId);

    public List<Song> findByArtistId(int artistId);
}
