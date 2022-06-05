package _04_Actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_mouseActions extends TestBase {
    @Test
    public void moveToElement() throws InterruptedException {
        driver.get("https://www.amazon.com");
        Actions actions=new Actions(driver);
        WebElement accountLinki= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountLinki).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();
        Thread.sleep(5000);
    }
    @Test
    public void contextClick(){
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // Right click on the given area
        Actions actions= new Actions(driver);
        WebElement givenArea= driver.findElement(By.id("hot-spot"));
        actions.contextClick(givenArea).perform();
        // Assert that the alert is "You selected a context menu"
        String expectedAlert="You selected a context menu";
        String actualAlert= driver.switchTo().alert().getText();
        Assert.assertEquals(expectedAlert,actualAlert);
        // Accept the alert
        driver.switchTo().alert().accept();
    }
    @Test
    public void dragDrop(){
        driver.get("https://demoqa.com/droppable");
        Actions actions= new Actions(driver);
        WebElement draggableObject=driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement dropPoint= driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(draggableObject,dropPoint).perform();
        // Assert that the result message is "Dropped!"
        WebElement resultElement= driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedResult="Dropped!";
        String actualResult=resultElement.getText();
        Assert.assertEquals(expectedResult,actualResult);
    }
}
