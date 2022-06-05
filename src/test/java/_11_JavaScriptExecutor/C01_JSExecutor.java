package _11_JavaScriptExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C01_JSExecutor extends TestBase {
    @Test
    public void JSExecutorTest() throws InterruptedException {
        driver.get("https://www.amazon.com");
        // Scroll down with JSE until the sign-in button is visible
        JavascriptExecutor jse= (JavascriptExecutor) driver;
        WebElement signInButton= driver.findElement(By.xpath("(//span[text()='Sign in'])[2]"));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].scrollIntoView(true);",signInButton);
        // Click the sign-in button with JSE
        jse.executeScript("arguments[0].click();",signInButton);
        Thread.sleep(3000);
    }
}
