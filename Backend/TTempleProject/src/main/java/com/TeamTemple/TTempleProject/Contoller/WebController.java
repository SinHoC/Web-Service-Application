package com.TeamTemple.TTempleProject.Contoller;

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

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;


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

    @RequestMapping("/A")
    public void someString(){
        ImmutableList<String> immutableList = ImmutableList.of("Geeks", "For", "Geeks");
        System.out.println(immutableList);

    	List<String> fruits = Lists.newArrayList("orange", "banana", "kiwi", 
                "mandarin", "date", "quince");
    	
    	for (String fruit: fruits) {
    		System.out.println(fruit);

    	}
    }
    
    
    @RequestMapping("/C")
    public class WebController {
    public static void main(String[] args) {
        try {
            String url = "http://ocw.mit.edu/courses/aeronautics-and-astronautics/16-050-thermal-energy-   fall-2002/";
            Document doc = Jsoup.connect(url).get();
            Elements paragraphs = doc.select("p");
        for(Element p : paragraphs)
   System.out.println(p.text());

           } 
        catch (IOException ex) {
          Logger.getLogger(WebController.class.getName())
             .log(Level.SEVERE, null, ex);
            }
         }
    }
    
    @RequestMapping("/H")
    public class Utf8File {
        public static String loadFileIntoString(String filePath) throws FileNotFoundException, IOException {
            return IOUtils.toString(new FileInputStream(filePath), "UTF-8");
        }

        public static void saveStringIntoFile(String filePath, String content) throws IOException {
            File f = new File(filePath);
            FileUtils.writeStringToFile(f, content, "UTF-8");
        }
    }


}
