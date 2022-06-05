package _12_Excel;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class C02_StoreExcel {
    @Test
    public void storeExcel() throws IOException {

        Map<String,String> countryMap= new HashMap<>();
        String filepath="src/resources/Countries.xlsx";
        FileInputStream fis=new FileInputStream(filepath);
        Workbook workbook= WorkbookFactory.create(fis);

        int lastRowIndex=workbook.getSheet("Sheet1").getLastRowNum();
        for (int i = 0; i <=lastRowIndex ; i++) {
            // Index 0 is defined as a key
            String key= workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            // Index 1,2,3 is defined as value
            String value= workbook.getSheet("Sheet1").getRow(i).getCell(1).toString()
                    +", "
                    +workbook.getSheet("Sheet1").getRow(i).getCell(2).toString()
                    +", "
                    +workbook.getSheet("Sheet1").getRow(i).getCell(3).toString();
            countryMap.put(key,value);
            System.out.println(key+ " , " + value);
        }
        System.out.println(countryMap);
        // Assert that map contains "Ghana"
        Assert.assertTrue(countryMap.keySet().contains("Ghana"));
    }

    @Test
    public void readExcelTest() throws IOException {
        String filepath = "src/resources/Countries.xlsx";
        FileInputStream fis = new FileInputStream(filepath);
        Workbook workbook = WorkbookFactory.create(fis);

        int rowNumber = workbook.getSheet("Sheet1").getLastRowNum() + 1;
        int columnNumber = C01_ReadExcel.ColumnNumber();

        Map<Integer, String> ulkelerMap = new HashMap<>();

        String values;
        for (int i = 0; i < rowNumber; i++) {
            values = "";
            for (int j = 0; j < columnNumber; j++) {
                values += workbook.getSheet("Sheet1").getRow(i).getCell(j).toString() + ",";
            }
            ulkelerMap.put(i, values);
        }

        for (Integer each:ulkelerMap.keySet()) {
            String[] valuesArray = ulkelerMap.get(each).split(",");
            System.out.print(each + " : ");
            System.out.print(Arrays.deepToString(valuesArray));
            System.out.println();
        }

        // Print the capital name of Afghanistan

        for (String each:ulkelerMap.values()) {
            String[] valuesArray = each.split(",");
            if (valuesArray[0].equals("Afghanistan")) {
                System.out.println("Capital of Afghanistan : " + valuesArray[1]);
            }
        }
    }
}
