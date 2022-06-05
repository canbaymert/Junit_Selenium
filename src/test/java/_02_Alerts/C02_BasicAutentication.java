package _02_Alerts;

import org.junit.Test;
import utilities.TestBase;

public class C02_BasicAutentication extends TestBase {

    @Test
    public void basicAutentication(){
        //pattern: https://username:password@URL  (pattern is defined by website and unique)
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
    }
}
