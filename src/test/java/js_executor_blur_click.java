import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class js_executor_blur_click extends initial_setup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void jsExecutorBlur(){
        WebElement textField = driver.findElement(By.id("waitForBlur"));
        textField.sendKeys("test");
        ((JavascriptExecutor)driver).executeScript("arguments[0].blur()" , textField);
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe(textField , "value" , "blured!"));

    }

    @Test
    public void jsExecutorClick(){
        WebElement buttonWFT = driver.findElement(By.id("startWaitForText"));
        ((JavascriptExecutor)driver).executeScript("arguments[0].click()" , buttonWFT);
    }
}
