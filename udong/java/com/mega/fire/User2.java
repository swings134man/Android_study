package com.mega.fire;

public class User2 {
    String name;
    String email;

    public User2(String name, String email) {
        this.name = name;
        this.email = email;
    } //생성자

    public  User2() {
    }//빈 생성자.
    // getter, setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // toString
    @Override
    public String toString() {
        return "User2{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    } // toString
}//class
