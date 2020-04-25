package tests;

import categories.RegressionTest;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tools.InitialSetup;

import java.util.List;

public class JsExecutorHighlightTest extends InitialSetup {

    @Before
    public void openBaseUrl(){
        getDriver().get(getBASE_URL() + "tabulka.php");
    }

    @Category(RegressionTest.class)
    @Test
    public void jsExecutorHighLight(){
        List<WebElement> rows = getDriver().findElements(By.xpath("//table//tbody//tr"));

        for (WebElement row : rows) {
            if (row.getText().contains("Florian")) {
                highLight(row);
            }
        }
    }

    // Refactor > Extract Method for JavascriptExecutor
    private Object highLight(WebElement row) {
        return ((JavascriptExecutor) getDriver())
                .executeScript("arguments[0].style.border='3px solid red'", row);
    }
}
