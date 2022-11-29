package com.example.HW.Repositories;

import com.example.HW.Entities.Playlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatlistRepository extends JpaRepository<Playlist,Integer> {

}
