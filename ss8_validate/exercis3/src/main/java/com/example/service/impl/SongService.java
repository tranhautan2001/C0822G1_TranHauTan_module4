package com.example.service.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import com.example.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService  implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> fillAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
    iSongRepository.save(song);
    }

    @Override
    public Song update(Song song) {
        return iSongRepository.save(song);
    }
}
