package Practices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Q07_DropDown extends TestBase {
    // Go to the url : https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/
    //-->Task1 Find Dropdown on Multi Selection
    //-->Task2 Find all Dropdown Elements on page
    //-->Task3 Print out DropDown Elements' number
    //-->Task4 Print out name of dropdown elements until the "choice 6"


    @Test
    public void test() {
        driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
        driver.findElement(By.xpath("//input[@id ='justAnInputBox']")).click();
        List<WebElement> dropList = driver.findElements(By.xpath("//span[@class ='comboTreeItemTitle']"));

        System.out.println("Number of elements :" + dropList.size());

        for (int i = 0; i < dropList.size(); i++) {
            String text = dropList.get(i).getText();
            System.out.println(text);

            if (text.equals("choice 6")) {
                break;
            }
        }
    }
}
