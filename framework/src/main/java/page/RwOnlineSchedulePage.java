package page;

import model.Route;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class RwOnlineSchedulePage extends AbstractPage {
    private static final Logger LOGGER = LogManager.getRootLogger();

    private static final String PAGE_URL = "https://pass.rw.by/en/tablo";

    final String routeLocator = "//div[@class='info-table__table table-adaptive']/table/tbody/tr";

    public RwOnlineSchedulePage(WebDriver driver) {
        super(driver);
    }

    public RwOnlineSchedulePage openPage() {
        driver.get(PAGE_URL);
        findElementByLocatorAndClick(By.xpath("//body"));
        LOGGER.log(Level.INFO, "Online schedule page is opened");
        return this;
    }

    public List<Route> getRoutes(int numberOfRoutes) {
        List<Route> routes = new LinkedList<>();

        for (int i = 1; i < numberOfRoutes + 1; i++) {
            final String number = findElementByLocatorAndGetText(By.xpath(routeLocator + "[" + i + "]/td/span"));
            final String[] locations = new String(
                    findElementByLocatorAndGetText(By.xpath(routeLocator + "[" + i + "]/td"))
                                                     .getBytes(StandardCharsets.UTF_8))
                                                     .split(number)[1]
                                                     .trim()
                                                     .split("—");

            final String from = locations[0].trim();
            final String to = locations[1].trim();

            LOGGER.log(Level.INFO, "Found actual route: #" + number + " from [" + from + " ] to [" + to + "]");

            routes.add(new Route(from, to, number));
        }

        LOGGER.log(Level.INFO, "Found [{}] actual routes!", numberOfRoutes);

        return routes;
    }
}
