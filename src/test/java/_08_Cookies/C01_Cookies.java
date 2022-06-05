package _08_Cookies;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void cookiesTesti() {
        driver.get("https://www.amazon.com");
        // List the cookies
        Set<Cookie> cookiesSet= driver.manage().getCookies();
        System.out.println(cookiesSet);
        int counter=1;
        for (Cookie each:cookiesSet
        ) {
            System.out.println("Cookie : "+counter+" : "+ each);
            System.out.println("Name :  "+each.getName());
            System.out.println("Value : "+ each.getValue());
            counter++;
        }
        // Assert that there are more than 5 cookies
        int numberOfCookies= cookiesSet.size();
        Assert.assertTrue(numberOfCookies>5);
        // Assert that the value of the cookie named "i18n-prefs" is USD.
        for (Cookie each: cookiesSet
        ) {
            if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD", each.getValue());
            }
        }
        // Add a new cookie
        Cookie cookie= new Cookie("new cookie","xyz");
        driver.manage().addCookie(cookie);
        counter=1;
        cookiesSet= driver.manage().getCookies();
        // Assert that the new cookie is added.
        Assert.assertTrue(cookiesSet.contains(cookie));
        // Delete the cookie named "skin" and confirm it.
        driver.manage().deleteCookieNamed("skin");
        Assert.assertFalse(cookiesSet.contains("skin"));
        // Delete all cookies and confirm it.
        driver.manage().deleteAllCookies();
        cookiesSet= driver.manage().getCookies();
        Assert.assertTrue(cookiesSet.isEmpty());
    }
}
