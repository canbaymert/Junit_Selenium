package _02_Alerts;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JavaScriptAlerts extends TestBase {
    @Test
    public void acceptAlert(){

        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        // Click for JS Alert
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        // Accept the alert
        driver.switchTo().alert().accept();
        // Test the result
        String expectedResult = "You successfully clicked an alert";
        WebElement actualResultElement=driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=actualResultElement.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void dismissAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        String keyword="successfully";
        WebElement actualResultElement= driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"));
        String actualResult=actualResultElement.getText();
        Assert.assertFalse(actualResult.contains(keyword));
    }
    @Test
    public void sendKeysAlert(){
        driver.get("https://the-internet.herokuapp.com/javascript_alerts ");
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("username");
        driver.switchTo().alert().accept();
        String keyword="username";
        WebElement actualResultElement= driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult=actualResultElement.getText();
        Assert.assertTrue(actualResult.contains(keyword));
    }
}
