package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.InitialSetup;


public class JsExecutorBlurClickTest extends InitialSetup {

    @Before
    public void openBaseUrl(){
        getDriver().get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void jsExecutorBlur(){
        WebElement textField = getDriver().findElement(By.id("waitForBlur"));
        textField.sendKeys("test");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].blur()" , textField);
        new WebDriverWait(getDriver(), 10)
                .until(ExpectedConditions.attributeToBe(textField , "value" , "blured!"));

    }

    @Test
    public void jsExecutorClick(){
        WebElement buttonWFT = getDriver().findElement(By.id("startWaitForText"));
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click()" , buttonWFT);
    }
}
