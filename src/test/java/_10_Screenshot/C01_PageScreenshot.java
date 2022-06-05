package _10_Screenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class C01_PageScreenshot extends TestBase {
    @Test
    public void fullPageSS() throws IOException {
        driver.get("https://www.amazon.com");
        TakesScreenshot ts = (TakesScreenshot) driver;
        LocalDateTime date=LocalDateTime.now();
        DateTimeFormatter dtf= DateTimeFormatter.ofPattern("YYMMddHHmmss");
        String dt = date.format(dtf);

        File fullPageSS= new File("target/screenshots/PageSS"+dt+".jpeg");
        File temp= ts.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,fullPageSS);
    }
}
