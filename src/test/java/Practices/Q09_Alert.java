package Practices;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Q09_Alert extends TestBase {

    //    Go to url : http://demo.automationtesting.in/Alerts.html
    //    Click  "Alert with OK" then click 'click the button to display an alert box:'
    //    Accept alert and print the alert on console
    //    Click "Alert with OK & Cancel" then click 'click the button to display a confirm box'
    //    Cancel Alert and print the alert on console
    //    Click "Alert with Textbox" then click 'click the button to demonstrate the prompt box'
    //    SendKeys 'username'
    //    Assert that output message is "Hello username How are you today"

    @Test
    public void test() throws InterruptedException {
        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("//*[text()='Alert with OK & Cancel ']")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("username");
        driver.switchTo().alert().accept();

        String expectedMsg = "Hello username How are you today";
        String actualMsg = driver.findElement(By.xpath("//p[@id='demo1']")).getText();

        Assert.assertEquals(expectedMsg, actualMsg);
    }
}
