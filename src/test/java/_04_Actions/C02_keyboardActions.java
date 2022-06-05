package _04_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_keyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");
        WebElement searchBox=driver.findElement(By.id("twotabsearchtextbox"));
        Actions actions=new Actions(driver);
        actions.click(searchBox)
                .keyDown(Keys.SHIFT)
                .sendKeys("j")
                .keyUp(Keys.SHIFT)
                .sendKeys("a")
                .sendKeys("v")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);
    }
    @Test
    public void test02() throws InterruptedException {
        driver.get("https://www.facebook.com");
        // Accept cookies if necessary
        // driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        // Fill the form
        WebElement nameBox= driver.findElement(By.xpath("//input[@name='firstname']"));
        Actions actions= new Actions(driver);
        actions.click(nameBox)
                .sendKeys("Name")
                .sendKeys(Keys.TAB)
                .sendKeys("Surname")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("12345buKl.")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("Jan")
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("2000")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ENTER)
                .perform();
        Thread.sleep(5000);
    }
    @Test
    public void test03() throws InterruptedException {
        // Navigate to https://html.com/tags/iframe/
        driver.get("https://html.com/tags/iframe/");
        // Page down until video is visible
        Actions actions=new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();
        // Play the video
        WebElement iframe=driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']")).click();
        // Assert that the video is displayed
        Thread.sleep(1000);
        WebElement youTubeLink= driver.findElement(By.xpath("//a[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youTubeLink.isDisplayed());
    }
}
