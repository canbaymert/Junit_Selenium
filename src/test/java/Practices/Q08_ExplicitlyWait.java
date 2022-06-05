package Practices;


import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Q08_ExplicitlyWait extends TestBase {

    // Go to web site : https://www.jqueryscript.net/demo/bootstrap-alert-box/
    // Maximize the window
    // Click on action dialog button
    // Use explicitly wait
    // Click on the ok button
    // Accept the alert message


    @Test
    public void test() {
        driver.get("https://www.jqueryscript.net/demo/bootstrap-alert-box/");
        driver.findElement(By.xpath("//button[@id = 'action']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//div[@class = 'modal-body']"))));

        // WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class = 'modal-body']"))));

        WebElement textMsg = driver.findElement(By.xpath("//div[@class = 'modal-body']"));
        Assert.assertTrue(textMsg.isDisplayed());

        driver.findElement(By.id("dialog-mycodemyway-action")).click();

        driver.switchTo().alert().accept();


    }

}


