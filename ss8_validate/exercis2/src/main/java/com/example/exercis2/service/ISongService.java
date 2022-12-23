package com.example.exercis2.service;

import com.example.exercis2.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> fillAll();

    void save(Song song);

    Song update(Song song);
}
