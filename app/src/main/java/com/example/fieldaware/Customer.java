package com.example.fieldaware;

public class Customer {

    String  cust_id,name,phone,housename,street,city, lmark,pincode, emailid,rep_phone, repname, state, district;

    public Customer(String custId, String name, String phone, String housename, String street, String city, String lmark, String pincode, String emailid, String rep_phone, String repname, String state, String cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_id() {
        return cust_id;
    }

    public void setCust_id(String cust_id) {
        this.cust_id = cust_id;
    }

    public Customer(String name, String phone, String housename, String street, String city, String lmark, String pincode, String emailid, String rep_phone, String repname, String state, String district) {
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
        this.state = state;
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
