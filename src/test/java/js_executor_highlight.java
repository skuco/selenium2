import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import java.util.List;

public class js_executor_highlight extends initial_setup {

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "tabulka.php");
    }

    @Test
    public void jsExecutorHighLight(){
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
