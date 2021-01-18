package com.wcc.distancecalculator.dto;

public final class Location {

    private final double longitude;

    private final double latitude;

    private final String postCode;

    public Location(double longitude, double latitude, String postCode) {
        this.longitude = longitude;
        this.latitude = latitude;
        this.postCode = postCode;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public String getPostCode() {
        return postCode;
    }
}
