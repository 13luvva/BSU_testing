package page;

import org.openqa.selenium.WebDriver;

public class RwResultsPage extends AbstractPage{
    protected RwResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(String origin, String destination) {
        return driver.getCurrentUrl().contains("from=" + origin) &&
                driver.getCurrentUrl().contains("to=" + destination);
    }
}
