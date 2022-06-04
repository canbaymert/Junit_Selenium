package _01_Basics;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C08_IFrame extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // Navigate to https://the-internet.herokuapp.com/iframe
        driver.get("https://the-internet.herokuapp.com/iframe");
        // Assert that the title element is enabled and print it.
        WebElement titleElement=driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(titleElement.isEnabled());
        System.out.println(titleElement.getText());
        // Switch to the iFrame, locate the text box and write "Hello World" in it.
        WebElement iFrameElement=driver.findElement(By.id("mce_0_ifr"));
        driver.switchTo().frame(iFrameElement);
        WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Hello World");
        // Switch to default content and assert that the link text element is enabled and print it.
        driver.switchTo().defaultContent();
        WebElement linkTextElement=driver.findElement(By.linkText("Elemental Selenium"));
        Assert.assertTrue(linkTextElement.isDisplayed());
        System.out.println(linkTextElement.getText());
        Thread.sleep(5000);
    }
}
