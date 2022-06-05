package Practices;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Q03_CssLocator {

    /*
    // http://the-internet.herokuapp.com/add_remove_elements/
    // click on the "Add Element" button 100 times
    // write a function that takes a number, and clicks the "Delete" button
    // given number of times, and then validates that given number of
    // buttons was deleted
    */

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        createButtons(driver,100);
        deleteButtonsAndValidate(driver,60);
    }

    private static void createButtons(WebDriver driver, int number) {
        WebElement addButton = driver.findElement(By.xpath("//*[@onclick ='addElement()']"));
        for (int j = 0; j < number; j++) {
            addButton.click();
        }
    }
    private static void deleteButtonsAndValidate(WebDriver driver, int number) {
        List<WebElement> elementsBefore = driver.findElements(By.cssSelector("[onclick= 'deleteElement()']"));
        int sizeBefore = elementsBefore.size();

        List<WebElement> buttonsToDelete = driver.findElements(By.cssSelector("[onclick= 'deleteElement()']"));
        int counter= 0;

        for (WebElement w :buttonsToDelete){
            counter ++;
            if(counter>number){
                break;
            }
            w.click();
        }

        List<WebElement> elementsAfter = driver.findElements(By.cssSelector("[onclick= 'deleteElement()']"));
        int sizeAfter = elementsAfter.size();

        if((sizeBefore-number)==sizeAfter){
            System.out.println("Size After Deletion = " + sizeAfter);
            System.out.println("SUCCESS");
        }else
            System.out.println("FAIL!");

    }

}
