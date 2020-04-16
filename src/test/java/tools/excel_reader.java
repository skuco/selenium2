package tools;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class excel_reader {

    public static void main(String[] args) throws IOException {
        // import dependency into the POM - poi-ooxml and create input stream
        FileInputStream fileInputStream = new FileInputStream(new File("src/test/resources/data/data.xlsx"));
        // now, create Workbook, which will use xlsx File as source
        Workbook inputData = new XSSFWorkbook(fileInputStream);
        // now, we will define which sheet we wnt to read
        Sheet sheet = inputData.getSheetAt(1);
        // and we can iterate trough the rows
        for (Row row : sheet) {
            if (row.getRowNum() == 0) {
                continue;
            }
            System.out.println(row.getCell(0).getStringCellValue());
        }

    }

}
