package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tools.excelReader;
import tools.initialSetup;

import java.io.IOException;

public class dataDrivenExcelReaderTest extends initialSetup {
    private static final String TEST_DATA_PATH = "src/test/resources/data/data.xlsx";
    private static final String SHEET = "prime";

    @Before
    public void openBaseUrl(){
        driver.get(getBASE_URL() + "primenumber.php");
    }

    @Test
    public void primeNumber() throws IOException {
        WebElement inputField = driver.findElement(By.xpath("//div//input[@type='number']"));
        WebElement buttonPrime = driver.findElement(By.xpath("//div//button[contains(@class, btn-default)]"));

        excelReader primeExcelReader = new excelReader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);

        for (Row cells : sheet) {
            if (cells.getRowNum() == 0){
                continue;
            }
            String number = String.valueOf((int) cells.getCell(0).getNumericCellValue());
            boolean expectedPrime = cells.getCell(1).getBooleanCellValue();

            inputField.clear();
            inputField.sendKeys(number);
            buttonPrime.click();

            checkResult(expectedPrime);
        }
    }

    private void checkResult(boolean expectedPrime) {
        if (expectedPrime) {
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By
                                    .xpath("//div[text()='Optimus approves']")));
        }else{
            new WebDriverWait(driver, 10)
                    .until(ExpectedConditions
                            .visibilityOfElementLocated(By
                                    .xpath("//div[text()='Optimus is sad']")));
        }
    }
}
