package tests;

import categories.SmokeTest;
import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.InitialSetup;

public class WaitTests extends InitialSetup {

    private final String waitforit = "waitforit.php";
    private final String minions = "minions.php";
    private final String prestige = "prestige.php";

    @Test
    public void waitForText(){
        getDriver().get(getBASE_URL() + waitforit);
        getDriver().findElement(By.id("startWaitForText")).click();
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.attributeToBe((By.id("waitForTextInput")), "value" , "dary !!!"));

        System.out.println(getDriver().findElement(By.id("waitForTextInput")).getAttribute("value"));
    }

    @Category(SmokeTest.class)
    @Test
    public void waitForAttribute() {
        getDriver().get(getBASE_URL() + waitforit);
        WebDriverWait wait_ten_seconds = new WebDriverWait(getDriver(), 10);

        System.out.println("Class without error: " + getDriver().findElement(By.id("waitForProperty")).getAttribute("class").equals("form-control"));
        getDriver().findElement(By.id("startWaitForProperty")).click();
        wait_ten_seconds.until(ExpectedConditions.attributeToBe((By.id("waitForProperty")) , "class" , "form-control error"));

        System.out.println("Class with error: " + getDriver().findElement(By.id("waitForProperty")).getAttribute("class").equals("form-control error"));
        wait_ten_seconds.until(ExpectedConditions.attributeToBe((By.id("startWaitForProperty")) , "disabled" , "true"));
        System.out.println("Is button disabled?: " + getDriver().findElement(By.id("startWaitForProperty")).getAttribute("disabled"));
        System.out.println(getDriver().findElement(By.xpath("//p")).getText());
    }

    @Test
    public void waitForMinions() {
        getDriver().get(getBASE_URL() + minions);
        int num_of_minions = 7;
        getDriver().findElement(By.xpath("//input")).sendKeys(Integer.toString(num_of_minions));
        getDriver().findElement(By.xpath("//button[contains(class, btn-warning)]")).click();

        new WebDriverWait(getDriver(), 10)
                .withMessage("Number of elements must be: " + num_of_minions)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img") , num_of_minions));

        Assert.assertEquals(num_of_minions , getDriver().findElements(By.xpath("//div[@class='minions']//img")).size());
    }

    @Test
    public void waitForInvisibleElements() {
        getDriver().get(getBASE_URL() + prestige);
        WebElement hat = getDriver().findElement(By.xpath("//div[@class=\"hat\"]//img"));

        Assert.assertTrue(hat.isDisplayed());
        hat.click();
        Assert.assertFalse(hat.isDisplayed());

        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.visibilityOf(hat));
        hat.click();
    }

}
