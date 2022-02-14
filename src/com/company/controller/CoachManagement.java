package com.company.controller;

import com.company.model.Coach;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CoachManagement implements IGeneralManagement<Coach>, ReadFile, WriteFile {
    private static CoachManagement coachManagement;
    private List<Coach> coaches = new ArrayList<>();

    private CoachManagement() {
        File file = new File("coach.txt");
        if (file.exists()) {
            try {
                readFile("coach.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static CoachManagement getInstance() {

        if (coachManagement == null) {
            coachManagement = new CoachManagement();
        }
        return coachManagement;
    }

    @Override
    public void displayAll() {
        for (Coach coach : coaches) {
            System.out.println(coach);
        }
    }

    @Override
    public void addNew(Coach coach) {
        this.coaches.add(coach);
        try {
            writeFile("coach.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByName(String name, Coach coach) {
        int index = findCoachByName(name);
        this.coaches.set(index, coach);
    }

    @Override
    public boolean deleteByName(String name) {
        int index = findCoachByName(name);
        if (index != -1) {
            this.coaches.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Coach getByName(String name) {
        int index = findCoachByName(name);
        return this.coaches.get(index);
    }

    public int findCoachByName(String name) {
        int index = -1;
        for (int i = 0; i < this.coaches.size(); i++) {
            if (coaches.get(i).getName().equals(name)) {
                index = i;
            }
        }
        return index;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        this.coaches = (List<Coach>) objectInputStream.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.coaches);
    }

    public void sort(){
        coaches.sort(new CoachComparator());
    }
}
