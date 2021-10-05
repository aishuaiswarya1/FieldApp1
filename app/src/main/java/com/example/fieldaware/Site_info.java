package com.example.fieldaware;

public class Site_info {
    String Site_name,Landmark,District,State,Longitude,Latitude,Pincode;

    public Site_info( ) {

    }

    public Site_info(String site_name, String landmark, String district, String state,
                     String longitude, String latitude, String pincode) {
        Site_name = site_name;
        Landmark = landmark;
        District = district;
        State = state;
        Longitude = longitude;
        Latitude = latitude;
        Pincode = pincode;
    }

    public String getSite_name() {
        return Site_name;
    }

    public void setSite_name(String site_name) {
        Site_name = site_name;
    }

    public String getLandmark() {
        return Landmark;
    }

    public void setLandmark(String landmark) {
        Landmark = landmark;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getLongitude() {
        return Longitude;
    }

    public void setLongitude(String longitude) {
        Longitude = longitude;
    }

    public String getLatitude() {
        return Latitude;
    }

    public void setLatitude(String latitude) {
        Latitude = latitude;
    }

    public String getPincode() {
        return Pincode;
    }

    public void setPincode(String pincode) {
        Pincode = pincode;
    }
}
