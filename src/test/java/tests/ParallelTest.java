package tests;

import com.google.code.tempusfugit.concurrency.ConcurrentTestRunner;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

// Java micro-library for writing & testing concurrent code
// Home Page: "http://tempusfugitlibrary.org/"
// Add it to the POM

@RunWith(ConcurrentTestRunner.class)
public class ParallelTest {
    public WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","src/test/resources/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test
    public void testA(){
        System.out.println("Running test A");
        driver.get("http://dsl.sk/");
    }
    @Test
    public void testB(){
        System.out.println("Running test B");
        driver.get("http://dsl.sk/");
    }
    @Test
    public void testC(){
        System.out.println("Running test C");
        driver.get("http://dsl.sk/");
    }
    @Test
    public void testD(){
        System.out.println("Running test D");
        driver.get("http://dsl.sk/");
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
