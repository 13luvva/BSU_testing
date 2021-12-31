import model.Route;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.RwOnlineSchedulePage;
import util.CommonConditions;

import java.util.List;

public class RwOnlineSchedulePageTest extends CommonConditions {
    final static int NUMBER_OF_ROUTES = 3;

    @Test
    public void findActualRoutesFromOnlineScheduleTest() {
        RwOnlineSchedulePage onlineSchedulePage = new RwOnlineSchedulePage(driver);
        final List<Route> routes = onlineSchedulePage.openPage()
                                                     .getRoutes(NUMBER_OF_ROUTES);

        Assert.assertEquals(routes.size(), NUMBER_OF_ROUTES);
    }
}
