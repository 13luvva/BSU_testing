package by.rw;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.opera.OperaDriver;

public class WebDriverSettings {
    public OperaDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.opera.driver", "C:\\Users\\37533\\Downloads\\operadriver_win64\\operadriver.exe");
        driver = new OperaDriver();
        driver.manage().window().maximize();
    }
    @After
    public void close (){
        driver.quit();
    }
}
