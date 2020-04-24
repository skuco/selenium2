package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.InitialSetup;

public class WindowSwitchSndHandlesTest extends InitialSetup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "inception.php");
    }

    @Test
    public void popupWindow(){
        String parentWindow = driver.getWindowHandle();
        WebElement deeperButton = driver.findElement(By.id("letsGoDeeper"));
        deeperButton.click();
        Assert.assertTrue(deeperButton.getAttribute("class").contains("disabled"));
        new WebDriverWait(driver , 10)
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        // Debug this code snippet with Debug mode and evaluate with Alt + F8 - to see all active handles
        driver.getWindowHandles();
        // Lets iterate trough all active window handles
        for (String windowHandle : driver.getWindowHandles()) {
            driver.switchTo().window(windowHandle);
        }
        driver.findElement(By.xpath("//input[1]")).sendKeys("test");
        driver.close(); // close popup window

        // and switch back to parent window
        driver.switchTo().window(parentWindow);
    }

}
