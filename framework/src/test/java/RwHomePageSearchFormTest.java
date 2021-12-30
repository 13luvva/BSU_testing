import org.testng.Assert;
import org.testng.annotations.Test;
import page.RwHomePage;
import page.RwResultsPage;
import util.CommonConditions;

public class RwHomePageSearchFormTest extends CommonConditions {
    private static final String ORIGIN = "Minsk";
    private static final String DESTINATION = "Berlin";
    private static final String SAME_LOCATION = "Paris";

    @Test
    public void sameOriginAndDestinationLocationsTest() {
        RwResultsPage resultsPage = new RwHomePage(driver).openHomePage()
                                                          .enterOrigin(SAME_LOCATION)
                                                          .enterDestination(SAME_LOCATION)
                                                          .search();

        Assert.assertTrue(resultsPage.isInitialized(SAME_LOCATION, SAME_LOCATION));
    }

    @Test
    public void swapOriginAndDestinationLocationsTest() {
        RwHomePage homePage = new RwHomePage(driver);

        final String[] locations = homePage.openHomePage()
                                           .enterOrigin(ORIGIN)
                                           .enterDestination(DESTINATION)
                                           .getLocations();

        final String[] swappedLocations = homePage.swapLocations()
                                                  .getLocations();

        Assert.assertTrue(locations[0].equals(swappedLocations[1]) && locations[1].equals(swappedLocations[0]));
    }

    @Test
    public void findTripsTest() {
        RwResultsPage resultsPage = new RwHomePage(driver).openHomePage()
                                                          .enterOrigin(ORIGIN)
                                                          .enterDestination(DESTINATION)
                                                          .search();

        Assert.assertTrue(resultsPage.isInitialized(ORIGIN, DESTINATION));
    }
}
