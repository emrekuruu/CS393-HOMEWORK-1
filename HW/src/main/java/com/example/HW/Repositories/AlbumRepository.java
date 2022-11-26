package com.example.HW.Repositories;

import com.example.HW.Entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album,Integer> {
    public Album findById(int id);

}
