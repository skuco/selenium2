import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class wait_for_text_and_attribute extends initial_setup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void wait_for_text(){
        driver.findElement(By.id("startWaitForText")).click();
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.attributeToBe((By.id("waitForTextInput")), "value" , "dary !!!"));

        System.out.println(driver.findElement(By.id("waitForTextInput")).getAttribute("value"));
    }

    @Test
    public void wait_for_attribute() {
        WebDriverWait wait_ten_seconds = new WebDriverWait(driver, 10);

        System.out.println("Class without error: " + driver.findElement(By.id("waitForProperty")).getAttribute("class").equals("form-control"));
        driver.findElement(By.id("startWaitForProperty")).click();
        wait_ten_seconds.until(ExpectedConditions.attributeToBe((By.id("waitForProperty")) , "class" , "form-control error"));

        System.out.println("Class with error: " + driver.findElement(By.id("waitForProperty")).getAttribute("class").equals("form-control error"));
        wait_ten_seconds.until(ExpectedConditions.attributeToBe((By.id("startWaitForProperty")) , "disabled" , "true"));
        System.out.println("Is button disabled?: " + driver.findElement(By.id("startWaitForProperty")).getAttribute("disabled"));
        System.out.println(driver.findElement(By.xpath("//p")).getText());
    }

}
