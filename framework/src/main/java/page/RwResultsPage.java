package page;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class RwResultsPage extends AbstractPage{
    private By sameLocationsErrorLocator = By.xpath("//div[text()='No direct communication between stations']");

    protected RwResultsPage(WebDriver driver) {
        super(driver);
    }

    public boolean isInitialized(String origin, String destination) {
        return driver.getCurrentUrl().contains("from=" + origin) &&
               driver.getCurrentUrl().contains("to=" + destination);
    }

    public boolean sameLocationsErrorIsVisible() {
        boolean sameLocationsErrorIsVisible = false;

        try {
            sameLocationsErrorIsVisible = findElementByLocator(sameLocationsErrorLocator).isDisplayed();
        } catch (NoSuchElementException ignored) {}


        return sameLocationsErrorIsVisible;
    }
}
