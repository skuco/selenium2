package tests;

import categories.SmokeTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.initialSetup;

public class waitTests extends initialSetup {

    private final String waitforit = "waitforit.php";
    private final String minions = "minions.php";
    private final String prestige = "prestige.php";

    @Test
    public void waitForText(){
        driver.get(getBASE_URL() + waitforit);
        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe((By.id("waitForTextInput")), "value" , "dary !!!"));

        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }

    @Category(SmokeTest.class)
    @Test
    public void waitForAttribute() {
        driver.get(getBASE_URL() + waitforit);
        WebDriverWait wait_ten_seconds = new WebDriverWait(driver, 10);

        System.out.println("Class without error: " + driver.findElement(By.id("waitForProperty")).getAttribute("class").equals("form-control"));
        driver.findElement(By.id("startWaitForProperty")).click();
        wait_ten_seconds.until(ExpectedConditions.attributeToBe((By.id("waitForProperty")) , "class" , "form-control error"));

        System.out.println("Class with error: " + driver.findElement(By.id("waitForProperty")).getAttribute("class").equals("form-control error"));
        wait_ten_seconds.until(ExpectedConditions.attributeToBe((By.id("startWaitForProperty")) , "disabled" , "true"));
        System.out.println("Is button disabled?: " + driver.findElement(By.id("startWaitForProperty")).getAttribute("disabled"));
        System.out.println(driver.findElement(By.xpath("//p")).getText());
    }

    @Test
    public void waitForMinions() {
        driver.get(getBASE_URL() + minions);
        int num_of_minions = 7;
        driver.findElement(By.xpath("//input")).sendKeys(Integer.toString(num_of_minions));
        driver.findElement(By.xpath("//button[contains(class, btn-warning)]")).click();

        new WebDriverWait(driver, 10)
                .withMessage("Number of elements must be: " + num_of_minions)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img") , num_of_minions));

        Assert.assertEquals(num_of_minions , driver.findElements(By.xpath("//div[@class='minions']//img")).size());
    }

    @Test
    public void waitForInvisibleElements() {
        driver.get(getBASE_URL() + prestige);
        WebElement hat = driver.findElement(By.xpath("//div[@class=\"hat\"]//img"));

        Assert.assertTrue(hat.isDisplayed());
        hat.click();
        Assert.assertFalse(hat.isDisplayed());

        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(hat));
        hat.click();
    }

}
