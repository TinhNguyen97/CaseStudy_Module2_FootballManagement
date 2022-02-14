package com.company.model;

import java.io.Serializable;
import java.util.Comparator;

public class Player implements Serializable {


    private String name;
    private int age;
    private double height;
    private String country;
    public Player()
    {

    }

    public Player(String name, int age, double height, String country) {
        this.name = name;
        this.age = age;
        this.height = height;
        this.country = country;
    }

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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", height=" + height +
                ", country='" + country + '\'' +
                '}';
    }

}
