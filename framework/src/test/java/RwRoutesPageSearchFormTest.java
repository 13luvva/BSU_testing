import model.Location;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RwRoutesPage;
import page.RwResultsPage;
import service.LocationsCreator;
import util.CommonConditions;

public class RwRoutesPageSearchFormTest extends CommonConditions {
    final static String ROUTE_TYPE = "Composite route";
    final static int MAX_NUMBER_OF_ROUTE_FORMS = 3;

    @Test
    public void sameOriginAndDestinationLocationsTest() {
        Location location = LocationsCreator.locationsFromProperty();
        RwResultsPage resultsPage = new RwRoutesPage(driver).openHomePage()
                                                            .enterOrigin(location.getSameLocation())
                                                            .enterDestination(location.getSameLocation())
                                                            .search();

        Assert.assertTrue(resultsPage.sameLocationsErrorIsVisible());
    }

    @Test
    public void swapOriginAndDestinationLocationsTest() {
        Location location = LocationsCreator.locationsFromProperty();
        RwRoutesPage routesPage = new RwRoutesPage(driver);

        final String[] locations = routesPage.openHomePage()
                                            .enterOrigin(location.getFromLocation())
                                            .enterDestination(location.getToLocation())
                                            .getLocations();

        final String[] swappedLocations = routesPage.swapLocations()
                                                    .getLocations();

        Assert.assertTrue(locations[0].equals(swappedLocations[1]) && locations[1].equals(swappedLocations[0]));
    }

    @Test
    public void findTripsTest() {
        Location location = LocationsCreator.locationsFromProperty();
        RwResultsPage resultsPage = new RwRoutesPage(driver).openHomePage()
                                                            .enterOrigin(location.getFromLocation())
                                                            .enterDestination(location.getToLocation())
                                                            .search();

        Assert.assertTrue(resultsPage.isInitialized(location.getFromLocation(), location.getToLocation()));
    }

    @Test
    public  void addMaxNumberOfCompositeRoutes() {
        final int maxNumberOfRouteForms = new RwRoutesPage(driver).openHomePage()
                                                                  .changeRouteType(ROUTE_TYPE)
                                                                  .addMaxNumberOfRouteForms()
                                                                  .getNumberOfRouteForms();

        Assert.assertEquals(maxNumberOfRouteForms, MAX_NUMBER_OF_ROUTE_FORMS);
    }
}
