package com.company.controller;

import java.util.Comparator;

public interface IGeneralManagement<T> {
    void displayAll();
    void addNew(T t);
    void updateByName(String name,T t);
    boolean deleteByName(String name);
    T getByName(String name);

}
