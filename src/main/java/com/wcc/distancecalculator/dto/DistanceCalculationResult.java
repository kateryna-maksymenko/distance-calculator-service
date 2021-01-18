package com.wcc.distancecalculator.dto;

public final class DistanceCalculationResult {

    private final Location startPoint;

    private final Location endPoint;

    private final String unit = "km";

    private final double distance;

    public DistanceCalculationResult(Location startPoint, Location endPoint, double distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
    }

    public Location getStartPoint() {
        return startPoint;
    }

    public Location getEndPoint() {
        return endPoint;
    }

    public String getUnit() {
        return unit;
    }

    public double getDistance() {
        return distance;
    }
}
