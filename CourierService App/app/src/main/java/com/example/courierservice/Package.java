package com.example.courierservice;

public class Package {

    String description,type,price,user;
    int weight;

    public Package(String description, int weight, String type, String price,String user) {
        this.description = description;
        this.weight = weight;
        this.type = type;
        this.price = price;
        this.user = user;
    }

    public String getDescription() {
        return description;
    }

    public int getWeight() {
        return weight;
    }

    public String getType() {
        return type;
    }

    public String getPrice() {
        return price;
    }

    public String getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "Package Details " +
                "description = '" + description + '\'' +
                ", type = '" + type + '\'' +
                ", price = '" + price + '\'' +
                ", user = '" + user + '\'' +
                ", weight = " + weight ;
    }
}
