import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class js_executor_scrollIntoView extends initial_setup {



    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "tabulka.php");
    }

    @Test
    public void scrollTo(){
        WebElement lastRow = driver.findElement(By.xpath("//table/tbody//tr[last()]"));
        System.out.println(lastRow.getText());
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()" , lastRow);
    }

}
