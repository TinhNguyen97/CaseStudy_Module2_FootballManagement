package com.company.controller;

import com.company.model.Coach;

import java.util.Comparator;

public class CoachComparator implements Comparator<Coach> {

    @Override
    public int compare(Coach o1, Coach o2) {
        return o1.getAge()-o2.getAge();
    }
}
