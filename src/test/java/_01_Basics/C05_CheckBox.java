package _01_Basics;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_CheckBox extends TestBase {

    @Test
    public void test01() throws InterruptedException {
        // Navigate to given website
        // https://the-internet.herokuapp.com/checkboxes
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        //Locate two checkBox elements
        WebElement checkBox1=driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement checkBox2=driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // Click checkBoxes if they're not selected.
        Thread.sleep(3000);
        if (!checkBox1.isSelected()){
            checkBox1.click();
        }
        Thread.sleep(3000);
        if (!checkBox2.isSelected()){
            checkBox2.click();
        }
        Thread.sleep(3000);
    }
}
