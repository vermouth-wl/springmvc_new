package com.spring_mvc.entity;

public class Address {
    private String province;
    private String city;

    //重写toString()方法
    @Override
    public String toString(){
        return "Address[province=" + province + ", city=" + city + "]";
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String privence) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}