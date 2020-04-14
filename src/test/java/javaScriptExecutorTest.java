import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.sql.SQLOutput;
import java.util.List;

public class javaScriptExecutorTest extends initial_setup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "tabulka.php");
    }

    @Test
    public void jsScriptExecutorTest(){
        List<WebElement> rows = driver.findElements(By.xpath("//table//tbody//tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Florian")) {
                highLight(row);
            }
        }
    }

    // Refactor > Extract Method for JavascriptExecutor
    private Object highLight(WebElement row) {
        return ((JavascriptExecutor) driver)
                .executeScript("arguments[0].style.border='3px solid red'", row);
    }
}
