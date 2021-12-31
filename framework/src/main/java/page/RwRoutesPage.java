package page;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RwRoutesPage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private static final String HOMEPAGE_URL = "https://pass.rw.by/en/route";

    private By originInputLocator = By.xpath("//input[@id='one-way-raspFormFromTitle']");

    private By destinationInputLocator = By.xpath("//input[@id='one-way-raspFormToTitle']");

    private By searchButtonLocator = By.xpath("//button[contains(@class,'btn-submit js-input-taber')]");

    private By swapButtonLocator = By.xpath("//button[@class='rasp-form__direction-icon']");

    private By addRouteFormButtonLocator = By.xpath("//button[@class='rasp-form__add-route']");

    private By routeFormsLocator = By.xpath("//div[@class='rasp-form__row-wrap']/div");

    public RwRoutesPage(WebDriver driver) {
        super(driver);
    }

    public RwRoutesPage openHomePage() {
        driver.get(HOMEPAGE_URL);
        LOGGER.log(Level.INFO, "Home page is opened");
        return this;
    }

    public RwRoutesPage enterOrigin(String origin) {
        findElementByLocatorAndClick(originInputLocator).sendKeys(origin);
        LOGGER.log(Level.INFO, "Origin [{}]  is entered", origin);
        return this;
    }

    public RwRoutesPage enterDestination(String destination) {
        findElementByLocatorAndClick(destinationInputLocator).sendKeys(destination);
        LOGGER.log(Level.INFO, "Destination [{}]  is entered", destination);
        return this;
    }

    public RwRoutesPage swapLocations() {
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
        LOGGER.log(Level.INFO, "Searching...");
        findElementByLocatorAndClick(searchButtonLocator);
        return new RwResultsPage(driver);
    }

    public RwRoutesPage changeRouteType(String routeType) {
        findElementByLocatorAndClick(By.xpath("//span[text()='" + routeType + "']"));
        LOGGER.log(Level.INFO, "Route type is changed by [{}]", routeType);
        return this;
    }

    public RwRoutesPage addMaxNumberOfRouteForms() {
        try{
            while (null != new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.elementToBeClickable(addRouteFormButtonLocator))){
                findElementByLocatorAndClick(addRouteFormButtonLocator);
                LOGGER.log(Level.INFO, "Adding route form...");
            }}
        catch(org.openqa.selenium.TimeoutException ignored) {
        }
        return this;
    }

    public int getNumberOfRouteForms() {
        final int routeFormsNumber = driver.findElements(routeFormsLocator).size();
        LOGGER.log(Level.INFO, "Number of route forms equals [{}]", routeFormsNumber);
        return routeFormsNumber;
    }
}
