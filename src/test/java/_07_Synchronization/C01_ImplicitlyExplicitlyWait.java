package _07_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ImplicitlyExplicitlyWait extends TestBase {
    @Test
    public void implicitlyWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Click the remove button
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        // Assert that “It’s gone!” message is displayed
        WebElement message= driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(message.isDisplayed());
        // Click the add button
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        // Assert that “It’s back!” message is displayed
        WebElement message2= driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(message2.isDisplayed());
    }
    @Test
    public void explicitlyWait() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Click the remove button
        driver.findElement(By.xpath("//button[@onclick='swapCheckbox()']")).click();
        // Assert that “It’s gone!” message is displayed
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15)); // wait element is created
        WebElement message=wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]"))); // waits until the expected condition
        Assert.assertTrue(message.isDisplayed());
        // Click the add button
        driver.findElement(By.xpath("//button[text()=\"Add\"]")).click();
        // Assert that “It’s back!” message is displayed
        WebElement message2=wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]"))); // waits until the expected condition
        Assert.assertTrue(message2.isDisplayed());
    }
    @Test
    public void explicitlyWait2() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // Assert that the text box is not enabled.
        WebElement textBox= driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        // Click enable and wait until the text box is enabled.
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));
        // Assert that “It’s enabled!” message is displayed
        WebElement message= driver.findElement(By.xpath("//p[text()=\"It's enabled!\"]"));
        Assert.assertTrue(message.isDisplayed());
        // Assert that the text box is enabled.
        Assert.assertTrue(textBox.isEnabled());
    }
}
