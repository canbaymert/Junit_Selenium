package Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q05_YandexMail {
    // Navigate to https://mail.yandex.com.tr/
    // Login to your mail address and open first e-mail
    // Find the activation code and print it on console
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ChromeOptions op = new ChromeOptions();
        op.addArguments("disable-popup-blocking");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://mail.yandex.com.tr/");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void mail1() throws InterruptedException {
        driver.findElement(By.xpath("(//a[@data-lego=\"react\"])[2]")).click();
        WebElement eMailBox= driver.findElement(By.xpath("//input[@type='text']"));
        eMailBox.sendKeys("username@yandex.com");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        Thread.sleep(2000);
        WebElement passwordBox= driver.findElement(By.xpath("//input[@class='Textinput-Control']"));
        passwordBox.sendKeys("password");
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.findElement(By.xpath("//span[@title='info@wax.io']")).click();
        WebElement activationCode= driver.findElement(By.xpath("(//p[@style])[2]"));
        System.out.println(activationCode.getText());
        Thread.sleep(1000);
    }
}
