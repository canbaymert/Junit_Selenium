package Practices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q11_WebTables extends TestBase {

    @Test
    public void webTableTest(){
        //  Navigate to “https://demoqa.com/webtables”
        driver.get("https://demoqa.com/webtables");
        //  Print the header names
        System.out.println("Headers : ");
        List <WebElement> headersList = driver.findElements(By.xpath("//div[@class='rt-resizable-header-content']"));
        headersList.stream().forEach(t->System.out.println(t.getText()));
        //  Print the department names
        System.out.println();
        System.out.println("Departments : ");
        int departmentIndex = 0;
        for (int i = 0; i < headersList.size(); i++) {
            if (headersList.get(i).getText().equals("Department")) {
                departmentIndex = i;
            }
        }
        departmentIndex++;

        List <WebElement> departmentsList = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']["+departmentIndex+"]"));
        departmentsList.
                stream().
                filter(t->!(t.getText().equals(" "))).
                forEach(t->System.out.println(t.getText()));

        //  Print out the 3rd header
        System.out.println();
        System.out.println("The 3rd Header : ");
        System.out.println(headersList.get(2).getText());

        // Print out all data on the table
        System.out.println();
        System.out.println("All Data : ");
        WebElement tumtable = driver.findElement(By.xpath("//div[@class='rt-tbody']"));
        System.out.println(tumtable.getText());

        // Print out the number of data cells
        System.out.println();
        System.out.print("Number of data cells : ");
        List<WebElement> dataCells = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-td']"));
        System.out.println(dataCells.size());

        // Print out the number of rows
        System.out.println();
        System.out.print("Number of data rows : ");
        List<WebElement> rows = driver.findElements(By.xpath("//div[@class='rt-tbody']//div[@class='rt-tr-group']"));
        System.out.println(rows.size());

        // Print out the number of columns
        System.out.println();
        System.out.print("Number of data columns : ");
        System.out.println(headersList.size());

        // Print out the 3rd column
        System.out.println();
        System.out.println("Elements of the 3rd column : ");
        List <WebElement> column3 = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][3]"));
        column3.
                stream().
                forEach(t->System.out.println(t.getText()));

        // Print out the salary of Kierra
        System.out.println();
        System.out.print("The Salary of Kierra : ");
        List<WebElement> nameList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][1]"));
        List<WebElement> salaryList = driver.findElements(By.xpath("//div[@class='rt-tr-group']//div[@class='rt-td'][5]"));
        for (int i = 0; i < nameList.size(); i++) {
            if (nameList.get(i).getText().equals("Kierra")) {
                System.out.println(salaryList.get(i).getText());
            }
        }

        // Create a method that prints out the data according to the given row and column information
        System.out.println();
        int row = 2;
        int column = 2;
        System.out.print("Data of the given cell : ");
        printCell(row, column);
    }

    private void printCell(int row, int column) {
        WebElement targetCell = driver.findElement(By.xpath("//div[@class='rt-tr-group']["+row+"]//div[@class='rt-td']["+column+"]"));
        System.out.println(targetCell.getText());
    }
}