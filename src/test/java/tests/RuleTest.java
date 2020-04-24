package tests;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.InitialSetup;

public class RuleTest extends InitialSetup {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "waitforit.php");
    }

    @Test
    public void dummyTestForRule(){
        expectedException.expect(ComparisonFailure.class);
        expectedException.expectMessage("Title is wrong!");

        WebElement text = driver.findElement(By.xpath("//div/h1[text()='wait for it !']"));
        Assert.assertEquals("Title is wrong!" , "wait for it !" , text.getText());
    }

}
