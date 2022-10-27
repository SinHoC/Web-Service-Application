package com.TeamTemple.TTempleProject.Controller;

import org.junit.Assert;
import org.junit.Test;


public class MultiplyTest {

    @Test
    public void multTest() {
        WebController a = new WebController();
        int res = a.multiply(5,10);
        Assert.assertEquals(50, res);
    }

    @Test
    public void multTest2() {
        WebController a = new WebController();
        int res = a.multiply(6,10);
        Assert.assertEquals(60, res);
    }
}
