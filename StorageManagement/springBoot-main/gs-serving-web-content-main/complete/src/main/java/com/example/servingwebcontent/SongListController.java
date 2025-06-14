package com.example.servingwebcontent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.servingwebcontent.database.songAiven;

import java.util.ArrayList;
import org.springframework.stereotype.Controller;

//controller to song list
@Controller
public class SongListController {
    @GetMapping("/songlist")

    public String songlist(Model model){

        ArrayList<Song> songList = new ArrayList<Song>();
        songAiven sa = new songAiven();
        songList = sa.songAivenList();
        model.addAttribute("ListOfSong", songList);

        //data to View is ${ListOfSong}
        
       //return view is songList
        return "songlist";

    }

    
}
