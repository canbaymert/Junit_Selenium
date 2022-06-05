package _06_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FileActions extends TestBase {
    @Test
    public void FilesExists() {
        System.out.println(System.getProperty("user.dir")); // C:\Users\User\IdeaProjects\Junit_Selenium
        System.out.println(System.getProperty("user.home")); // C:\Users\User

        String filePath = System.getProperty("user.home") + "\\Desktop\\text.txt";
        System.out.println(filePath); //C:\Users\User\Desktop\text.txt
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }

    @Test
    public void FileDownload() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        // Download the dummy.txt
        WebElement dummyLink = driver.findElement(By.xpath("//a[text()='dummy.txt']"));
        dummyLink.click();
        Thread.sleep(5000);

        // Assert that the file is downloaded.
        String userPath = System.getProperty("user.home");
        String commonPath = "\\Downloads\\dummy.txt";
        String filePath = userPath + commonPath;
        Assert.assertTrue(Files.exists(Paths.get(filePath)));
    }
    @Test
    public void FileUpload() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/upload");
        WebElement uploadButton= driver.findElement(By.id("file-upload"));
        String userPath=System.getProperty("user.home");
        String commonPath= "\\Desktop\\text.txt";
        String filePath = userPath + commonPath;

        uploadButton.sendKeys(filePath);
        driver.findElement(By.xpath("//input[@id=\"file-submit\"]")).click();

        //Assert that the file is uploaded.
        WebElement confirmation= driver.findElement(By.tagName("h3"));
        Assert.assertTrue(confirmation.isDisplayed());
        Thread.sleep(5000);
    }
}