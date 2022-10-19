package edu.TeamTemple.SinHo.Cheung.calculator;

import org.junit.*;

public class CalculatorTest {

    private Calculator c;

    @Before
    public void setup() {
        System.out.println("before testing ...");
        c = new Calculator();
    }

    @After
    public void cleanup() {
        System.out.println("Finishing and cleaning up the test ...");
    }

    @Test
    public void testAdd() {
        int res = c.add(10, 20);
        Assert.assertEquals(30, res);
    }

    @Test
    public void multTest2() {
        int res = a.add(6, 10);
        Assert.assertEquals(16, res);
    }

}
