package _12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {
    @Test
    public void writeExceltest() throws IOException {
        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        // Add a new quantity ("Population")
        workbook
                .getSheet("Sheet1")
                .getRow(0)
                .createCell(4)
                .setCellValue("Population");
        // Set population value of 5th row: 1500000
        workbook
                .getSheet("Sheet1")
                .getRow(1)
                .createCell(4)
                .setCellValue("1.500.000");
        // Set population value of 10th row: 250000
        workbook
                .getSheet("Sheet1")
                .getRow(9)
                .createCell(4)
                .setCellValue(250000);
        // Set population value of 15th row: 54000
        workbook
                .getSheet("Sheet1")
                .getRow(14)
                .createCell(4)
                .setCellValue(54000);
        // Save file
        FileOutputStream fos = new FileOutputStream(filepath);
        workbook.write(fos);
        // Close file
        fis.close();
        fos.close();
    }
}
