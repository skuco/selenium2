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
        getDriver().get(getBASE_URL() + "inception.php");
    }

    @Test
    public void popupWindow(){
        String parentWindow = getDriver().getWindowHandle();
        WebElement deeperButton = getDriver().findElement(By.id("letsGoDeeper"));
        deeperButton.click();
        Assert.assertTrue(deeperButton.getAttribute("class").contains("disabled"));
        new WebDriverWait(getDriver() , 10)
                .until(ExpectedConditions.numberOfWindowsToBe(2));

        // Debug this code snippet with Debug mode and evaluate with Alt + F8 - to see all active handles
        getDriver().getWindowHandles();
        // Lets iterate trough all active window handles
        for (String windowHandle : getDriver().getWindowHandles()) {
            getDriver().switchTo().window(windowHandle);
        }
        getDriver().findElement(By.xpath("//input[1]")).sendKeys("test");
        getDriver().close(); // close popup window

        // and switch back to parent window
        getDriver().switchTo().window(parentWindow);
    }

}
