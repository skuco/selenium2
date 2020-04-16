package tests;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import tools.excel_reader;
import tools.initial_setup;

import java.io.IOException;

public class data_driven_test_excel_reader extends initial_setup {
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

        excel_reader primeExcelReader = new excel_reader(TEST_DATA_PATH);
        Sheet sheet = primeExcelReader.getSheetByName(SHEET);
        for (Row cells : sheet) {
            if (cells.getRowNum() == 0){
                continue;
            }
            System.out.println(cells.getCell(0).getNumericCellValue());

        }
    }

}
