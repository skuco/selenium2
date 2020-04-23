package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

@RunWith(Parameterized.class)
public class parameterTest {
    WebDriver driver;
    int number;
    boolean expectedPrime;

    @Parameterized.Parameters
    public static List<Object[]> getData(){
        return Arrays.asList(new Object[][]{{1,true},{2,true},{6,false},{9,false},{482,false}});
    }

    public parameterTest(int number , boolean expectedPrime) {
        this.number = number;
        this.expectedPrime = expectedPrime;
    }

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.get("http://localhost/primenumber.php");

    }

    @Test
    public void testOptimusUsingParameters() {
        System.out.println(number);
        WebElement inputField = driver.findElement(By.xpath("//div//input[@type='number']"));
        WebElement buttonPrime = driver.findElement(By.xpath("//div//button[contains(@class, btn-default)]"));

        inputField.clear();
        inputField.sendKeys(String.valueOf(number));
        buttonPrime.click();
        checkResult(expectedPrime);
        }

    @After
    public void tearDown(){
        driver.quit();
    }



    private void checkResult(boolean expectedPrime) {
        if (expectedPrime) {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By
                                    .xpath("//div[text()='Optimus approves']")));
        } else {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By
                                    .xpath("//div[text()='Optimus is sad']")));
        }
    }
}
