package com.TeamTemple.TTempleProject.Contoller;

import java.util.Random;

import org.apache.commons.math3.stat.Frequency;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @RequestMapping("/frequency")
    public String someMath(){
        Frequency f = new Frequency();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            f.addValue(rand.nextInt(21));
        }
        int unique = f.getUniqueCount();
        double cumFreq = f.getCumPct(10);
        return "Unique Numbers: " + unique + "\n Percentage of numbers less than or equal to 10: " + cumFreq;
    }

}
