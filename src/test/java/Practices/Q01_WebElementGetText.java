package Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Q01_WebElementGetText {
    /*
    Navigate to http://www.google.com
    Write "Green Mile" and print number of results.
    Write "Premonition" and print number of results.
    Write "The Curious Case of Benjamin Button" and print number of results.
    */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Before
    public void beforeTest() {
        driver.get("http://www.google.com");
    }

    @Test
    public void test1() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Green Mile");
        searchBox.submit();
    }

    @Test
    public void test2() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Premonition" + Keys.ENTER);
    }

    @Test
    public void test3() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("The Curious Case of Benjamin Button" + Keys.ENTER);
    }

    @After
    public void testtenSonra() {
        WebElement resultElement = driver.findElement(By.xpath("//div[@id ='result-stats']"));
        System.out.println("sonucYazisiElementi.getText() = " + resultElement.getText());
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
}
