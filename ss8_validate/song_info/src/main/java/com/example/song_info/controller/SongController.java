package com.example.song_info.controller;

import com.example.song_info.dto.SongDto;
import com.example.song_info.model.Song;
import com.example.song_info.service.ISongService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/song")
public class SongController {
    @Autowired
    ISongService iSongService;

    @GetMapping("")
    public String showList(Model model){
        model.addAttribute("songList",iSongService.findAll());
        return "song/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("songDto",new SongDto());
        return "song/create";
    }

    @PostMapping("save")
    public String save(@ModelAttribute @Validated SongDto songDto, BindingResult bindingResult, RedirectAttributes redirectAttributes){
        new SongDto().validate(songDto,bindingResult);
        if (bindingResult.hasErrors()){
            return "song/create";
        }
        else {
            Song song = new Song();
            BeanUtils.copyProperties(songDto,song);
            iSongService.save(song);
            redirectAttributes.addFlashAttribute("mess","Add new song successful!");
        }
        return "redirect:/song";
    }
}