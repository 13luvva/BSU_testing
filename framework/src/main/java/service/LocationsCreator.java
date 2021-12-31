package service;

import model.Location;

public class LocationsCreator {
    public static final String TESTDATA_FROM_LOCATION = "testdata.location.from";
    public static final String TESTDATA_TO_LOCATION = "testdata.location.to";
    public static final String TESTDATA_SAME_LOCATION = "testdata.location.same";

    public static Location locationsFromProperty() {
        return new Location(TestDataReader.getTestData(TESTDATA_FROM_LOCATION),
                            TestDataReader.getTestData(TESTDATA_TO_LOCATION),
                            TestDataReader.getTestData(TESTDATA_SAME_LOCATION));
    }
}
