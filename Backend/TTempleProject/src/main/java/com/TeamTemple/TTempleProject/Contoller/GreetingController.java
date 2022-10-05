package com.TeamTemple.TTempleProject.Contoller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @RequestMapping("/Andy")
    public String getGreeting(){

        return "Hello! Andy's webpage.";
    }
    
    @RequestMapping("/melvin")
    public String melvinGreeting(){

        return "Wow, you reached Melvin's message!";
    }

}
