package _01_Basics;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

import java.util.List;

public class C07_DropDownMenu extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // Locate the Drop Down Menu
        WebElement dropDownMenu = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        // Create a select object
        Select select = new Select(dropDownMenu);
        // Choose an option
        select.selectByVisibleText("Books");
        // select.selectByIndex(5);
        // select.selectByValue("search-alias=stripbooks-intl-ship");
        // Search for java
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java" + Keys.ENTER);
        WebElement resultElement = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisiStr = resultElement.getText();
        String keyword = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(keyword));
        Thread.sleep(5000);
    }

    @Test
    public void test02() {
        driver.get("https://www.amazon.com");
        WebElement ddm = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");
        // Print the first selected option
        System.out.println(select.getFirstSelectedOption().getText());
        System.out.println();
        // Confirm that there are 28 different options
        List<WebElement> optionsList = select.getOptions();
        int numberOfActualOptions = optionsList.size();
        int numberOfExpectedOptions = 28;
        // Print all of the options
        Assert.assertEquals("There are not 28 options",numberOfExpectedOptions, numberOfActualOptions);
        System.out.println("Options");
        System.out.println();
        for (WebElement each : optionsList) {
            System.out.println(each.getText() + " ");
        }
    }
    @Test
    public void test03() {
        // Navigate to https://the-internet.herokuapp.com/dropdown
        driver.get("https://the-internet.herokuapp.com/dropdown");
        // Select option 1 by index and print
        WebElement ddm = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select = new Select(ddm);
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());
        //  Select option 2 by value and print
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());
        //  Select option 2 by visible text and print
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());
        //  Print all options
        List<WebElement> tumOpsiyonlar = select.getOptions();
        for (WebElement each : tumOpsiyonlar
        ) {
            System.out.println(each.getText());
        }
    }
}
