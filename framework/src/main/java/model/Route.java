package model;

public class Route {
    private String fromLocation;
    private String toLocation;
    private String routeNumber;

    public Route(String fromLocation, String toLocation, String routeNumber) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.routeNumber = routeNumber;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public String getRouteNumber() {
        return routeNumber;
    }
}
