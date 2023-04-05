package org.example.dto;

public class LocationBr {
    private double lat;
    private double lon;

    public LocationBr() {
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LocationBr{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}
