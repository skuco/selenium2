package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.initial_setup;

public class excel_reader_test extends initial_setup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "primenumber.php");
    }

    @Test
    public void primeNumber(){
        WebElement inputField = driver.findElement(By.xpath("//div//input[@type='number']"));
        WebElement buttonPrime = driver.findElement(By.xpath("//div//button[contains(@class, btn-default)]"));

        inputField.clear();
        inputField.sendKeys("5");
        buttonPrime.click();
    }

}
