package _03_HandleWindows;

import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

public class C01_Tabs extends TestBase {

    @Test
    public void test01(){
        driver.get("https://www.amazon.com");
        // Get window handle value
        String firstPageHandleValue= driver.getWindowHandle();
        System.out.println(firstPageHandleValue); // CDwindow-93381F7F90B408BD28AC876099A60AB9
        // Search for Java
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        WebElement firstImage=driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        // Switch to a new tab
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();
        // Print the product title and the URL in new tab
        WebElement productTitleElement=driver.findElement(By.xpath("//span[@id=\"productTitle\"]"));
        System.out.println(productTitleElement.getText());
        System.out.println(driver.getCurrentUrl());
        // Switch to the first tab and print the URL
        driver.switchTo().window(firstPageHandleValue);
        System.out.println(driver.getCurrentUrl());
    }
}