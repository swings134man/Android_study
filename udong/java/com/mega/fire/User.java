package com.mega.fire;

public class User {
    String name;
    int age;

    public User(){

    } // 생성자.

    public User(String name, int age){
        this.name = name;
        this.age = age;
    } // 파라메터가 있는 생성자.


    // getter & setter
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // toString
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}//class
