package com.sdmp.sachin.cars;

//This class represent a dealer which has a name and address
public class Dealer {
    public String name;
    public String address;

    public Dealer(String name, String address) {

        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
