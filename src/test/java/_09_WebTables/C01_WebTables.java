package _09_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C01_WebTables extends TestBase {
    public void login() {
        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();
    }
    @Test
    public void webTable() {
        login();
        // Print all body
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        // Find the number of the columns
        List<WebElement> headersList= driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Number of Columns : " + headersList.size());
        // Find the number of the rows
        List<WebElement> rows= driver.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : " + rows.size());
        // Print the rows
        for (WebElement each: rows
        ) {
            System.out.println(each.getText());
        }
        // Print the elements on the 4th row
        List<WebElement> cellList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement each: cellList
        ) {
            System.out.println(each.getText());
        }
        // Print the emails
        int emailColumn=0;
        for (int i = 0; i < headersList.size() ; i++) {
            if (headersList.get(i).getText().equals("Email")){
                emailColumn=i;
            }
        }
        List<WebElement> emailList=
                driver.findElements(By.xpath("//tbody//td["+(emailColumn+1)+"]"));
        for (WebElement each: emailList) {
            System.out.println(each.getText());
        }
    }
    @Test
    public void printCell() {
        int row=3;
        int column=3;
        login();
        WebElement cell=
                driver.findElement(By.xpath("//tbody//tr["+row+"]//td["+column+"]"));
        System.out.println(cell.getText());
    }

}
