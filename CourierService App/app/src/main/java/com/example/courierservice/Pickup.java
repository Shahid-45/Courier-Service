package com.example.courierservice;

public class Pickup extends  login_reference{
    String address1,address2,time,pin,phone,mail,date,user;

    public Pickup(String address1, String address2, String time, String pin, String phone, String mail, String date,String user) {

        this.user = user;
        this.address1 = address1;
        this.address2 = address2;
        this.time = time;
        this.pin = pin;
        this.phone = phone;
        this.mail = mail;
        this.date = date;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getTime() {
        return time;
    }

    public String getPin() {
        return pin;
    }

    public String getPhone() {
        return phone;
    }

    public String getMail() {
        return mail;
    }

    public String getDate() {
        return date;
    }

    public String getUser() {
        return user;
    }

}
