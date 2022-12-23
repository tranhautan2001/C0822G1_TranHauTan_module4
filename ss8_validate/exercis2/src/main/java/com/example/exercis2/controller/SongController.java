package com.example.exercis2.controller;

import com.example.exercis2.model.Song;
import com.example.exercis2.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/song")
public class SongController {

    @Autowired
    private ISongService iSongService;

    @GetMapping("")
    public String showList(Model model){
        List<Song> songList = iSongService.fillAll();
        model.addAttribute("songList",songList);
        return "templates/views/list";
    }
}
