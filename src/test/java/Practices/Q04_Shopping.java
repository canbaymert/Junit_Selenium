package Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class Q04_Shopping {
     /*
     Navigate to https://www.teknosa.com/
     Add a product to your cart and complete a transaction
     */
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.teknosa.com/");

        ChromeOptions op = new ChromeOptions();
        op.addArguments("disable-popup-blocking");
        WebElement searchArea = driver.findElement(By.xpath("//input[@id ='search-input']"));
        searchArea.sendKeys("oppo" + Keys.ENTER);
        System.out.println(driver.findElement(By.xpath("//div[@class ='plp-info']")).getText());

        driver.findElement(By.xpath("(//a[@class='prd-link'])[1]")).click();
        driver.findElement(By.xpath("//button[@id ='addToCartButton']")).click();

        driver.findElement(By.xpath("//a[@class ='btn btn-secondary']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class= 'cart-sum-title']")).getText());
        driver.findElement(By.xpath("//span[.= 'Alışverişi Tamamla']")).click();
        System.out.println(driver.findElement(By.xpath("//div[text()= 'Teknosa’ya hoş geldiniz']")).getText());

    }
}
