package com.TeamTemple.TTempleProject.Controller;

import org.apache.commons.math3.stat.Frequency;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.TeamTemple.TTempleProject.ExampleOrder;
import com.google.common.collect.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import java.io.IOException;
import java.util.logging.*;
import org.jsoup.*;
import org.jsoup.nodes.*;
import org.jsoup.select.*;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class WebController {
    
    @GetMapping("/")
    public String getString() {
        return "Welcome to the Home Page";
    }

    @GetMapping("/frequency")
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
    
    @GetMapping("/order1")
    public List<ExampleOrder> order1() {
        ExampleOrder  order = new ExampleOrder("Melvin Chiem-Ngoy", "123-456-7890");
        ExampleOrder  order2 = new ExampleOrder("Yu Sun", "123-123-1234");
        ExampleOrder  order3 = new ExampleOrder("D'Brickashaw Ferguson", "109-876-5432");
        
        List<ExampleOrder> list = new ArrayList<ExampleOrder>();
        list.add(order);
        list.add(order2);
        list.add(order3);
        
        return list;
    }
//
//    @RequestMapping("/A")
//    public void someString() {
//        ImmutableList<String> immutableList = ImmutableList.of("Geeks", "For", "Geeks");
//        System.out.println(immutableList);
//
//        List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi",
//                "mandarin", "date", "quince");
//
//        for (String fruit : fruits) {
//            System.out.println(fruit);
//
//        }
//    }
//
//    @RequestMapping("/C")
//    public void soup() {
//        try {
//            String url = "http://ocw.mit.edu/courses/aeronautics-and-astronautics/16-050-thermal-energy-fall-2002/";
//            Document doc = Jsoup.connect(url).get();
//            Elements paragraphs = doc.select("p");
//            for (Element p : paragraphs) {
//                System.out.println(p.text());
//            }
//        } catch (IOException ex) {
//            Logger.getLogger(WebController.class.getName())
//                    .log(Level.SEVERE, null, ex);
//        }
//    }
}
