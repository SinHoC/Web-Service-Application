package com.TeamTemple.TTempleProject.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/")
    public String someMath(){

        return "Hello! Andy's webpage.";
    }

}
