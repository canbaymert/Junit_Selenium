package _09_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void Test01() {
        // Navigate to “https://demoqa.com/webtables”
        driver.get("https://demoqa.com/webtables");
        // Print the headers
        System.out.println("Name of the headers : ");
        List<WebElement> headers=driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        headers.stream().forEach(x-> System.out.println(x.getText()));
        // Print the departments
        System.out.println("Name of the departments : ");
        int departmentIndex=0;
        for (int i = 0; i < headers.size() ; i++) {
            if (headers.get(i).getText().equals("Department")) departmentIndex=i;
        }
        departmentIndex++;
        List<WebElement> departmentList=driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']["+departmentIndex+"]"));
        departmentList.stream().filter(a->!(a.getText().equals(" "))).forEach(a-> System.out.println(a.getText()));
        //  Print the header of the 3rd Column
        System.out.print("Header of the 3rd Column : ");
        System.out.println(headers.get(2));


        //  Print all data on the table
        System.out.println("All data");
        List<WebElement> allData=driver.findElements(By.xpath("//div[@class='rt-td']"));
        for (int i = 0; i < allData.size(); i++) {
            if (!(allData.get(i).getText().equals(" "))){
                System.out.println(allData.get(i).getText());
            }
        }
         /*
         Alternative method
         WebElement tableElement = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
         System.out.println(tableElement.getText());
         */

        //  Print the number of cells
        System.out.println("Number of Cells : "+allData.size());
        //   Print the number of rows
        List<WebElement> rows = driver.findElements(By.xpath("(//div[@class='rt-tr-group'])"));
        System.out.println("Number of Rows :  " + rows.size());
        //  Print the number of columns
        List<WebElement> columns = driver.findElements(By.xpath("//div[@class='rt-tr-group'][1]//div[@class='rt-td']"));
        System.out.println("Number of Columns : " + columns.size());
        //  Print the 3rd column
        System.out.println("The 3rd column");
        List<WebElement> column3=driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        for (int i = 0; i < column3.size(); i++) {
            if (!(column3.get(i).getText().equals(" "))){
                System.out.println(column3.get(i).getText());
            }
        }
        // Print the salary of Kierra
        System.out.println("Salary of Kierra");
        for (int i = 1; i < rows.size(); i++) {
            if ((driver.findElement(By.xpath("//div[@class='rt-tr-group']["+i+"]//div[@class='rt-td'][1]")).getText().equals("Kierra"))){
                System.out.println(driver.findElement(By.xpath("//div[@class='rt-tr-group']["+i+"]//div[@class='rt-td'][5]")).getText());
            }
        }
        // Print the cell on the 3rd row and the 4th column
        int row = 3;
        int column = 4;
        PrintElement(row, column);
    }
    private void PrintElement(int row, int column) {
        WebElement cell = driver.findElement(By.xpath("(//div[@class='rt-tr-group'][" + row + "]//div[@class='rt-td'])[" + column + "]"));
        System.out.print(cell.getText());
    }
}