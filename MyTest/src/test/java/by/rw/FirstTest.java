package by.rw;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.opera.OperaDriver;

public class FirstTest extends WebDriverSettings {

    @Test
    public void FirstTest() {
        driver.get("https://www.rw.by");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Официальный сайт - Белорусская железная дорога"));
    }


}
