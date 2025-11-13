package org.bharat882.orangehrm;


import org.testng.Assert;
import org.testng.annotations.Test;

public class SanityTest {
    @Test
    public void canRunTestNg(){
        Assert.assertTrue(true, "TestNG is running");
    }
}
