package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import tools.InitialSetup;

public class SkipTest extends InitialSetup {

    @Before
    public void openBaseUrl(){
        getDriver().get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void first_test(){
        Assert.assertEquals("WAIT FOR IT !" , getDriver().findElement(By.xpath("//div//h1")).getText());
    }
    @Test
    public void second_test(){
        Assert.assertEquals("WAIT FOR IT !" , getDriver().findElement(By.xpath("//div//h1")).getText());
    }
    @Test
    @Ignore
    public void third_test(){
        Assert.assertEquals("WAIT FOR IT !" , getDriver().findElement(By.xpath("//div//h1")).getText());
    }
    @Test
    public void fourth_test(){
        Assert.assertEquals("WAIT FOR IT !" , getDriver().findElement(By.xpath("//div//h1")).getText());
    }

}
