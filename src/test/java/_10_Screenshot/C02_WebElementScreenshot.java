package _10_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C02_WebElementScreenshot extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        driver.get("https://www.amazon.com");
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Java"+ Keys.ENTER);
        WebElement resultElement= driver.findElement(By.xpath("//h1[@class='a-size-base s-desktop-toolbar a-text-normal']"));
        File resultElementSS= new File("target/screenshots/resultElementSS.jpeg");
        File temp=resultElement.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,resultElementSS);
    }
}
