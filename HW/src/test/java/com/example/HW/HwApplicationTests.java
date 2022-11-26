package com.example.HW;

import com.example.HW.Entities.Album;
import com.example.HW.Entities.Artist;
import com.example.HW.Entities.Song;
import com.example.HW.Service.HomeworkService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.AbstractList;
import java.util.List;

@SpringBootTest
class HwApplicationTests {


	@Autowired
	HomeworkService service;


	@Test
	void saveAlbum() {
		Album album = new Album();
		service.saveAlbum(album);
	}

	@Test
	void addSongToAlbum(){
		Song song3 = new Song("Third song",100);
		service.addSongToAlbum(1,song3);
		Song song = new Song();
	}

	@Test
	void AssignArtistToAlbum(){
	service.assignArtistToAlbum(1,2);
	Album album = new Album();
	}

	@Test
	void findSongsWithArtistID(){
		List<Song> songs = service.findSongsWithArtistId(1);
		System.out.print(songs.size());
	}

	@Test
	void deleteSong(){
		service.deleteSong(1);
	}

	@Test
	void deleteAlbum(){
		service.deleteAlbum(1);
	}
}
