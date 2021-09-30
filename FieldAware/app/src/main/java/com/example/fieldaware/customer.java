package com.example.fieldaware;

public class customer {

    String name,phone,housename,street,city, lmark,pincode, emailid,rep_phone, repname;

    public customer() {

    }

    public customer(String name, String phone, String housename, String street,
                    String city, String lmark, String pincode, String emailid, String rep_phone, String repname) {
        this.name = name;
        this.phone = phone;
        this.housename = housename;
        this.street = street;
        this.city = city;
        this.lmark = lmark;
        this.pincode = pincode;
        this.emailid = emailid;
        this.rep_phone = rep_phone;
        this.repname = repname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHousename() {
        return housename;
    }

    public void setHousename(String housename) {
        this.housename = housename;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLmark() {
        return lmark;
    }

    public void setLmark(String lmark) {
        this.lmark = lmark;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    public String getRep_phone() {
        return rep_phone;
    }

    public void setRep_phone(String rep_phone) {
        this.rep_phone = rep_phone;
    }

    public String getRepname() {
        return repname;
    }

    public void setRepname(String repname) {
        this.repname = repname;
    }
}
