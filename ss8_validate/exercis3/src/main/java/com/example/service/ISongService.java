package com.example.service;


import com.example.model.Song;

import java.util.List;

public interface ISongService {
    List<Song> fillAll();

    void save(Song song);

    Song update(Song song);
}
