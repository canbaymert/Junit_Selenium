package _01_Junit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C06_RadioButton extends TestBase {


    @Test
    public void test01() throws InterruptedException {
        // Navigate to facebook
        driver.get("https://www.facebook.com");
        // Accept Cookies if necessary
        // driver.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();
        // Click “Create an Account”
        driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']")).click();
        // Locate the radio button elements
        WebElement femaleButton=driver.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton=driver.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton=driver.findElement(By.xpath("//input[@value='-1']"));
        // Click on maleButton if not selected
        Thread.sleep(3000);
        if (!maleButton.isSelected()){
            maleButton.click();
        }
        Thread.sleep(3000);
    }
}