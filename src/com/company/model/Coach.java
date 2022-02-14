package com.company.model;

import java.io.Serializable;
import java.util.Comparator;

public class Coach implements Serializable, Comparator<Coach> {
    private String name;
    private int age;
    private String country;

    public Coach()
    {

    }

    public Coach(String name, int age, String country) {
        this.name = name;
        this.age = age;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Coach{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public int compare(Coach o1, Coach o2) {
        return o1.getAge()-o2.getAge();
    }
}
