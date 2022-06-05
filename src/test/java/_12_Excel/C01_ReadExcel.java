package _12_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcel() throws IOException {
        String filepath = "src/resources/Countries.xlsx";
        // Create a file input stream
        FileInputStream fis = new FileInputStream(filepath);
        // Create a workbook object
        Workbook workbook = WorkbookFactory.create(fis);
        // Create a sheet object
        Sheet sheet = workbook.getSheet("Sheet1");
        // Create a row object
        Row row = sheet.getRow(3);
        // Create a cell object (column)
        Cell cell = row.getCell(3);
        System.out.println(cell);
        // Assert that the data in the given cell is Cezayir.
        String expectedData = "Cezayir";
        String actualData = cell.toString(); // Converted to string
        Assert.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData, cell.getStringCellValue());
    }

    @Test
    public void readExcel2() throws IOException {
        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        String actualData = workbook
                .getSheet("Sheet1")
                .getRow(0)
                .getCell(1)
                .toString();
        System.out.println(actualData);
    }

    @Test
    public void readExcel3() throws IOException {
        int rowNumber = 12;
        int columnNumber = 2;

        String expectedData = "Baku";
        String actualData = bringMeCell(rowNumber - 1, columnNumber - 1); // index starts with 0
        Assert.assertEquals(expectedData, actualData);
    }

    @Test
    public void readExcel4() throws IOException {
        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        // Find the row number and the used row number at Sheet2
        int lastRowIndex = workbook
                .getSheet("Sheet2")
                .getLastRowNum();
        int expectedRowNumber = 24;
        Assert.assertEquals(expectedRowNumber, lastRowIndex + 1);
        int usedRowNumber = workbook
                .getSheet("Sayfa2")
                .getPhysicalNumberOfRows();
        int expectedUsedRowNumber = 12;
        Assert.assertEquals(expectedUsedRowNumber, usedRowNumber);
    }

    public static String bringMeCell(int rowIndex, int columnIndex) throws IOException {
        String cellData = "";
        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        cellData = workbook
                .getSheet("Sheet1")
                .getRow(rowIndex)
                .getCell(columnIndex)
                .toString();
        return cellData;
    }

    @Test
    public void printColumn() throws IOException {
        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        // Print the capital names
        int lastRowIndex = workbook.getSheet("Sheet1").getLastRowNum();
        System.out.println(lastRowIndex);
        String rowData = "";
        for (int i = 0; i <= lastRowIndex; i++) {
            rowData = bringMeCell(i, 1);
            System.out.println(rowData);
        }
    }


    public static int ColumnNumber() throws IOException {

        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);
        int rowNumber = workbook.getSheet("Sheet1").getLastRowNum() + 1;

        int columnNumber = 0;
        try {
            while (true) {
                if (workbook.getSheet("Sheet1").getRow(0).getCell(columnNumber).toString().equals(" ")) {
                    break;
                } else {
                    columnNumber++;
                }
            }
        } catch (NullPointerException e) {
            System.out.println("End of Row");
        }

        System.out.println("Column Number : " + columnNumber);
        return columnNumber;
    }
}

