package Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class Q02_RelativeLocator {
    /*
    Navigate to http://www.bestbuy.com 'a gidin,
    Assert that title includes "Best"
    Use relative locator;
    logoTest => Assert that the logo is displayed
    mexicoLinkTest => Assert that the link is displayed
    */

    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();

    }
    @Before
    public void testtenOnce(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com");
    }
    @Test
    public void titleTest(){
        Assert.assertTrue("Title doesn't include 'Best' word ", driver.getTitle().contains("Best"));
    }

    @Test
    public void  logoTest(){
        // WebElement logoBestBuy = driver.findElement(By.xpath("//img[@class ='logo']"));
        WebElement helloHeading = driver.findElement(By.xpath("//div[@class ='heading']"));
        WebElement logoBestBuy = driver.findElement(RelativeLocator.with(By.tagName("img")).above(helloHeading));
        Assert.assertTrue(logoBestBuy.isDisplayed());
    }

    @Test
    public void mexicoLinkTest(){
    WebElement usLink = driver.findElement(By.xpath("(//img[@alt ='United States'])[1]"));
    WebElement chooseText =driver.findElement(By.xpath("//h1[text()='Choose a country.']"));
    WebElement mexicoLink = driver.findElement(RelativeLocator.with(By.tagName("a")). toRightOf(usLink).below(chooseText));
    Assert.assertTrue(mexicoLink.isDisplayed());
    }
    @After
    public void close(){
        driver.close();
    }

}
