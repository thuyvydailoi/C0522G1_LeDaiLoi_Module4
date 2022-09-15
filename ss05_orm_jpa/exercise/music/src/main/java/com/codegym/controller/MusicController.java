package com.codegym.controller;

import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/music")
public class MusicController {

    @Qualifier("musicService")
    @Autowired
    IMusicService iMusicService;

    @GetMapping("/list")
    public String index(Model model) {
        List<Music> musicList = iMusicService.findAll();
        model.addAttribute("music", musicList);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "/create";
    }

    @PostMapping("/save")
    public String save(Music music) {
        music.setId((int) (Math.random() * 10000));
        iMusicService.save(music);
        return "redirect:/music/list";
    }

    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        iMusicService.update(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String showDelete(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        iMusicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed music successfully!");
        return "redirect:/music";
    }

    @GetMapping("/{id}/view")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("product", iMusicService.findById(id));
        return "/view";
    }
}
