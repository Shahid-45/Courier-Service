package com.example.courierservice;

public class Register {

        String name;
        String email;
        String pwd;
        String Cp;
        String addr;
        String pin;
        String city;
        String state;
        String pn;

        public Register() {

        }

        public Register(String name, String email, String pwd, String cp, String addr, String pin, String city, String state, String pn) {
            this.name = name;
            this.email = email;
            this.pwd = pwd;
            Cp = cp;
            this.addr = addr;
            this.pin = pin;
            this.city = city;
            this.state = state;
            this.pn = pn;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public String getPwd() {
            return pwd;
        }

        public String getCp() {
            return Cp;
        }

        public String getAddr() {
            return addr;
        }

        public String getPin() {
            return pin;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getPn() {
            return pn;
        }


}
