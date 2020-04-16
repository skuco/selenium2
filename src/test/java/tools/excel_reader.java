package tools;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class excel_reader {
        private Workbook excelData;

    public excel_reader(String excelPath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(excelPath));
        this.excelData = new XSSFWorkbook(fileInputStream);
    }

    public Sheet getSheetByName(String SheetName){
        return excelData.getSheet(SheetName);
    }
}
