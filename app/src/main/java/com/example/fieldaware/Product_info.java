package com.example.fieldaware;

public class Product_info {
    String family_name, sub_family1, sub_family2;

    public Product_info( ) {

    }

    public Product_info( String family_name, String sub_family1, String sub_family2) {
        this.family_name = family_name;
        this.sub_family1 = sub_family1;
        this.sub_family2 = sub_family2;
    }


    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getSub_family1() {
        return sub_family1;
    }

    public void setSub_family1(String sub_family1) {
        this.sub_family1 = sub_family1;
    }

    public String getSub_family2() {
        return sub_family2;
    }

    public void setSub_family2(String sub_family2) {
        this.sub_family2 = sub_family2;
    }
}