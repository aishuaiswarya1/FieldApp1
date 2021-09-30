package com.example.fieldaware;

public class Product_info {
    String brand,family,second_famiy,third_family;

    public Product_info( ) {

    }

    public Product_info(String brand, String family, String second_famiy, String third_family) {
        this.brand = brand;
        this.family = family;
        this.second_famiy = second_famiy;
        this.third_family = third_family;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getSecond_famiy() {
        return second_famiy;
    }

    public void setSecond_famiy(String second_famiy) {
        this.second_famiy = second_famiy;
    }

    public String getThird_family() {
        return third_family;
    }

    public void setThird_family(String third_family) {
        this.third_family = third_family;
    }
}
