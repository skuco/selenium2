package tests;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.JavascriptExecutor;
import tools.InitialSetup;

public class JsExecutorScrollByOffsetTest extends InitialSetup {
    JavascriptExecutor js;

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "tabulka.php");
        js =(JavascriptExecutor) driver;
    }

    @Test
    public void scrollByOffset(){
        js.executeScript("window.scrollBy(0,300)");
    }

    @Test
    public void scrollToPageEnd(){
        long height = (long) js.executeScript("return document.body.scrollHeight");
        System.out.println("Page is high " + height + " pixels.");
        js.executeScript("window.scrollBy(0," + height + ")");
    }

}
