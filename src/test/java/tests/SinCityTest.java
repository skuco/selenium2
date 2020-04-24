package tests;

import models.Sin;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.InitialSetup;

public class SinCityTest extends InitialSetup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "sincity.php");
    }

    @Test
    public void testNewSin(){
        Sin smokeWeed = new Sin("I smoke weed" , "Bob Dylan" , "I like it!");
        fillSinInformation("I smoke weed" , "Bob Dylan" , "I like it.");
    }

    private void fillSinInformation(String title, String author, String message) {
        driver.findElement(By.name("title")).sendKeys(title);
        driver.findElement(By.name("author")).sendKeys(author);
        driver.findElement(By.name("message")).sendKeys(message);
    }

}
