package com.example.courierservice;

public class Delivery_Details {
    String Add1,Add2,pincode,phone,gmail,user;

    public Delivery_Details(String add1, String add2, String pincode, String phone, String gmail,String user) {
        Add1 = add1;
        Add2 = add2;

        this.pincode = pincode;
        this.phone = phone;
        this.gmail = gmail;
        this.user = user;
    }

    public String getAdd1() {
        return Add1;
    }

    public String getAdd2() {
        return Add2;
    }


    public String getPincode() {
        return pincode;
    }

    public String getPhone() {
        return phone;
    }

    public String getGmail() {
        return gmail;
    }

    public String getUser() {
        return user;
    }
}
