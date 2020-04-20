package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import tools.initialSetup;

public class skipTest extends initialSetup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void first_test(){
        Assert.assertEquals("WAIT FOR IT !" , driver.findElement(By.xpath("//div//h1")).getText());
    }
    @Test
    public void second_test(){
        Assert.assertEquals("WAIT FOR IT !" , driver.findElement(By.xpath("//div//h1")).getText());
    }
    @Test
    @Ignore
    public void third_test(){
        Assert.assertEquals("WAIT FOR IT !" , driver.findElement(By.xpath("//div//h1")).getText());
    }
    @Test
    public void fourth_test(){
        Assert.assertEquals("WAIT FOR IT !" , driver.findElement(By.xpath("//div//h1")).getText());
    }

}
