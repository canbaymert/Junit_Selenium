package _05_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_FakerFile extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.facebook.com");
        // Accept cookies if necessary
        // driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement nameBox= driver.findElement(By.xpath("//input[@name='firstname']"));

        Actions actions= new Actions(driver);
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();
        actions.click(nameBox)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeMail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
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
        Thread.sleep(15000);
    }
}
