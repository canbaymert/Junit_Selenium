package Practices;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q10_Iframe extends TestBase {
    /*
    // Navigate to https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
    // Switch to iframe
    // Select "Animal and Nature" emoji set
    // Click all emojis
    // Navigate back to parent frame
    // Fill the form then click apply
    */

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id ='emoojis']"));
        driver.switchTo().frame(iframe);

        WebElement animalsEmojiSet = driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]"));
        animalsEmojiSet.click();

        List<WebElement> emojis = driver.findElements(By.xpath("//div[@id='nature']//div//img"));
        emojis.stream().forEach(x-> x.click());

        Thread.sleep(3000);

        driver.switchTo().parentFrame();

        List<WebElement> textList = driver.findElements(By.xpath("//input[@class='mdl-textfield__input']"));

        List<String> text = new ArrayList<>(Arrays.asList("Emojis","are","funny","aren't", "they","?", "","", "", "",""));

        for (int i=0; i< textList.size();i++){
            textList.get(i).sendKeys(text.get(i));
        }

        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='send']")).click();
    }
}
