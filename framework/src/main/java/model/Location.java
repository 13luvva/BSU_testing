package model;

public class Location {
    private String fromLocation;
    private String toLocation;
    private String sameLocation;

    public Location(String fromLocation, String toLocation, String sameLocation) {
        this.fromLocation = fromLocation;
        this.toLocation = toLocation;
        this.sameLocation = sameLocation;
    }

    public String getFromLocation() {
        return fromLocation;
    }

    public String getToLocation() {
        return toLocation;
    }

    public String getSameLocation() { return sameLocation; }
}
