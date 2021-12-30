package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RwHomePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private static final String HOMEPAGE_URL = "https://www.rw.by";

    private By originInputLocator = By.xpath("//input[@id='acFrom']");

    private By destinationInputLocator = By.xpath("//input[@id='acTo']");

    private By searchButtonLocator = By.xpath("//span[@class='std-button']/input");

    private By swapButtonLocator = By.xpath("//a[@class='switch']");

    public RwHomePage(WebDriver driver) {
        super(driver);
    }

    public RwHomePage openHomePage() {
        driver.get(HOMEPAGE_URL);
        LOGGER.log(Level.INFO, "Home page is opened");
        return this;
    }

    public RwHomePage enterOrigin(String origin) {
        findElementByLocatorAndClick(originInputLocator).sendKeys(origin);
        LOGGER.log(Level.INFO, "Origin [{}]  is entered", origin);
        return this;
    }

    public RwHomePage enterDestination(String destination) {
        findElementByLocatorAndClick(destinationInputLocator).sendKeys(destination);
        LOGGER.log(Level.INFO, "Destination [{}]  is entered", destination);
        return this;
    }

    public RwHomePage swapLocations() {
        findElementByLocatorAndClick(swapButtonLocator);
        LOGGER.log(Level.INFO, "Locations are swapped");
        return this;
    }

    public String[] getLocations() {
        JavascriptExecutor js = (JavascriptExecutor)driver;
        String origin = findElementByLocator(originInputLocator).getAttribute("value");
        String destination = findElementByLocator(destinationInputLocator).getAttribute("value");
        LOGGER.log(Level.INFO, "Locations [" + origin + "] and [" + destination + "] are obtained");
        return new String[] {origin, destination};
    }

    public RwResultsPage search() {
        findElementByLocatorAndClick(searchButtonLocator);
        LOGGER.log(Level.INFO, "Searching...");
        return new RwResultsPage(driver);
    }
}
