package com.example.song_info.service.impl;

import com.example.song_info.model.Song;
import com.example.song_info.repository.ISongRepository;
import com.example.song_info.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    ISongRepository iSongRepository;
    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }
}