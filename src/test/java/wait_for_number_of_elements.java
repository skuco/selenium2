import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.lang.reflect.Array;
import java.util.List;

public class wait_for_number_of_elements extends initial_setup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "minions.php");
    }

    @Test
    public void waitForMinions() {
        int num_of_minions = 7;
        driver.findElement(By.xpath("//input")).sendKeys(Integer.toString(num_of_minions));
        driver.findElement(By.xpath("//button[contains(class, btn-warning)]")).click();

        new WebDriverWait(driver, 10)
                .withMessage("Number of elements must be: " + num_of_minions)
                .until(ExpectedConditions.numberOfElementsToBe(By.xpath("//div[@class='minions']//img") , num_of_minions));

        Assert.assertEquals(num_of_minions , driver.findElements(By.xpath("//div[@class='minions']//img")).size());
    }

}
