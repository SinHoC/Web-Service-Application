package com.TeamTemple.TTempleProject.Controller;

import org.apache.commons.math3.stat.Frequency;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.collect.*;

import java.util.List;
import java.util.Random;

import java.io.IOException;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

@RestController
public class WebController {

    @RequestMapping("/frequency")
    public double[] someMath() {
        double[] result = new double[2];
        Frequency f = new Frequency();
        Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            f.addValue(rand.nextInt(21));
        }
        result[0] = f.getUniqueCount();
        result[1] = f.getCumPct(10);
        return result;
    }

    @RequestMapping("/A")
    public int multiply(int a, int b) {
        return a*b;

    }
    
        @RequestMapping("/Subtraction")
    public int subtract(int a, int b) {
        return a-b;

    }
    
    @RequestMapping("/Calculator")
    public int Calculator(int a, int b) {
        return a+b;

    }
    

    @RequestMapping("/C")
    public void soup() {
        try {
            String url = "http://ocw.mit.edu/courses/aeronautics-and-astronautics/16-050-thermal-energy-fall-2002/";
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select("p");
            for (Element p : paragraphs) {
                System.out.println(p.text());
            }
        } catch (IOException ex) {
            Logger.getLogger(WebController.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }
}
