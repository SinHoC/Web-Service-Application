package com.TeamTemple.TTempleProject.Controller;

import org.junit.*;

public class FrequencyTest {
    
    @Test
    public void uniqueFrequencyTest() {
        WebController c = new WebController();
        double[] res = c.someMath();
        Assert.assertTrue(res[0] > 0);
    }
    
    @Test
    public void cumPctFrequencyTest() {
        WebController c = new WebController();
        double[] res = c.someMath();
        Assert.assertTrue(res[1] <= 1);
    }
}
