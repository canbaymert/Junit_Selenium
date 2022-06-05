package _03_HandleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_Windows extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // Navigate to Amazon
        driver.get("https://www.amazon.com");
        String firstPageHandleValue = driver.getWindowHandle();
        // Switch to a new Window and Navigate to BestBuy
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String secondPageHandleValue = driver.getWindowHandle();
        // Navigate to first page and search for "Java"
        driver.switchTo().window(firstPageHandleValue);
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        // Assert that the result text element includes the word "Java"
        WebElement resultTextElement = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String resultText = resultTextElement.getText();
        String keyword = "Java";
        Assert.assertTrue(resultText.contains(keyword));
        // Navigate to second window
        driver.switchTo().window(secondPageHandleValue);
        // Assert that the logo is displayed
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
