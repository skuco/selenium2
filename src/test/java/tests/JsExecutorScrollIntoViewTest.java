package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import tools.InitialSetup;

public class JsExecutorScrollIntoViewTest extends InitialSetup {



    @Before
    public void openBaseUrl(){
        getDriver().get(getBASE_URL() + "tabulka.php");
    }

    @Test
    public void scrollTo(){
        WebElement lastRow = getDriver().findElement(By.xpath("//table/tbody//tr[last()]"));
        System.out.println(lastRow.getText());
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView()" , lastRow);
    }

}
