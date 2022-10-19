package com.TeamTemple.TTempleProject.Controller;

import org.junit.Assert;
import org.junit.Test;

public class SubtractionTest {
    @Test
    public void subTest() {
        WebController a = new WebController();
        int res = a.subtract(35,15);
        Assert.assertEquals(20, res);
    }

    @Test
    public void subTest2() {
        WebController a = new WebController();
        int res = a.subtract(10,20);
        Assert.assertEquals(-10, res);
    }
}
