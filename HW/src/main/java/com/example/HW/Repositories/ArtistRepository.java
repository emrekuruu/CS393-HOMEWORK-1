package com.example.HW.Repositories;

import com.example.HW.Entities.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistRepository extends JpaRepository<Artist,Integer> {

    public Artist findById(int artistId);
}
