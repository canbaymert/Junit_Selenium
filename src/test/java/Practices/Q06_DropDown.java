package Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Q06_DropDown {

   // Navigate to amazon
   // Choose books on DropDownMenu
   // Print all catagories
   // Search for Les Miserables
   // Print the number of results
   // Assert that result text includes the word "Les Miserables"

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test
    public void test01(){
        driver.get("http://www.amazon.com");
        WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(dropDown);
        List<WebElement> list = select.getOptions();
        for (WebElement w:list) {
            System.out.println(w.getText());
        }
        select.selectByVisibleText("Books");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Les Miserables");
        searchBox.submit();
        WebElement resultNumber = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(resultNumber.getText());
        Assert.assertTrue(resultNumber.getText().contains("Les Miserables"));
        Assert.assertEquals("Result doesn't include Les Misreables",resultNumber.getText().contains("Les Miserables"),true);

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
}
