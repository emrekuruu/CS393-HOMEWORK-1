package com.example.HW;

import com.example.HW.Entities.Album;
import com.example.HW.Entities.Artist;
import com.example.HW.Entities.Song;
import com.example.HW.Service.HomeworkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.AbstractList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class HwApplicationTests {


	@Autowired
	HomeworkService service;


	@Test
	void saveAlbum() {
		Album album = new Album();
		album.setArtist(service.findArtist(2));
		album.setName("THIRD ALBUM");
		service.saveAlbum(album);
		assertEquals(album.getId(),service.findAlbum(album.getId()).getId());
	}

	@Test
	void addSongToAlbum(){
		Song song3 = new Song("Third song",100);
		service.addSongToAlbum(1,song3);
		assertTrue(song3.getAlbum().getId() == service.findAlbum(1).getId() );
	}

	@Test
	void AssignArtistToAlbum(){
	service.assignArtistToAlbum(1,2);
	assertTrue(service.findAlbum(1).getArtist().getId() == service.findArtist(2).getId());
	}


	@Test
	void deleteSong(){
		service.deleteSong(1);
		assertNull(service.findSong(1));
	}

	@Test
	void deleteAlbum(){
		service.deleteAlbum(2);
		assertNull(service.findAlbum(2));
	}

	@Test
	void findSongsWithArtistID(){
		List<Song> songs = service.findSongsWithArtistId(1);
		assertNotNull(songs);
	}

}
