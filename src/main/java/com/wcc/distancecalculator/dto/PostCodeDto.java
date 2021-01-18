package com.wcc.distancecalculator.dto;

public class PostCodeDto {
    private long id;
    private String postCode;
    private double latitude;
    private double longitude;

    public PostCodeDto(long id, String postCode, double latitude, double longitude) {
        this.id = id;
        this.postCode = postCode;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public PostCodeDto() {
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getId() {
        return id;
    }

    public String getPostCode() {
        return postCode;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
