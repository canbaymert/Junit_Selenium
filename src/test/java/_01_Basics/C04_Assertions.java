package _01_Basics;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_Assertions extends TestBase {

    @Test
    public void AssertTrue() {
        // Navigate to http://automationpractice.com/index.php
        driver.get("http://automationpractice.com/index.php");
        // Press the Sign in button
        driver.findElement(By.xpath("//a[@class='login']")).click();
        // Enter an “Invalid email address” and test
        WebElement mailBox = driver.findElement(By.xpath("//input[@id='email_create']"));
        mailBox.sendKeys("xxxgmail.com" + Keys.ENTER);
        WebElement alertTextElement = driver.findElement(By.xpath("//*[text()='Invalid email address.']"));
        Assert.assertTrue(alertTextElement.isDisplayed());
    }
    @Test
    public void AssertTrue2() {
        driver.get("https://www.amazon.com");
        String keyword = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(keyword));
    }

    @Test
    public void AssertFalse() {
        driver.get("https://www.facebook.com");
        String keyword = "facebook";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(keyword));
    }
    @Test
    public void AssertEquals(){
        driver.get("https://www.amazon.com");
        String expectedUrl="https://www.facebook.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("Actual URL is different than the expected one",expectedUrl,actualUrl);
    }
}