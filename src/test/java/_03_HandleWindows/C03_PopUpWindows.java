package _03_HandleWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_PopUpWindows extends TestBase {
    @Test
    public void test01() {
        // Navigate to https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //Confirm that the header is “Opening a new window”.
        WebElement headerElement = driver.findElement(By.xpath("//h3"));
        String expectedHeader = "Opening a new window";
        String actualHeader = headerElement.getText();
        Assert.assertEquals("Title is not 'Opening a new window'. ", expectedHeader, actualHeader);

        String firstPageHandleValue = driver.getWindowHandle();
        System.out.println(firstPageHandleValue);
        driver.findElement(By.linkText("Click Here")).click();
        // Find the handle value of the pop-up window
        Set<String> windowHandleset = driver.getWindowHandles();
        System.out.println(windowHandleset);
        String secondPageHandleValue = "";
        for (String each : windowHandleset) {
            if (!each.equals(firstPageHandleValue)) {
                secondPageHandleValue = each;
            }
        }
        driver.switchTo().window(secondPageHandleValue);
        // Confirm that the title of the pop-up is “New Window”
        String expectedTitle2 = "New Window";
        String actualTitle2 = driver.getTitle();
        Assert.assertEquals(expectedTitle2, actualTitle2);

        // Switch to first page and confirm that the title is “The Internet”
        driver.switchTo().window(firstPageHandleValue);
        String expectedTitle = "The Internet";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

}
