package com.example.fieldaware;

public class DeviceID {
    String device,date;
    String latitude,longitude;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public DeviceID(String s, String deviceid, String latitude, String device) {
        this.device = device;
        this.latitude = this.latitude;
        this.longitude = this.longitude;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
}
