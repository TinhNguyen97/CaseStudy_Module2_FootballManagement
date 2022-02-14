package com.company.controller;

import com.company.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;


public class UserManagement implements ReadFile, WriteFile {
    private List<User> users = new ArrayList<>();
    private static UserManagement userManagement;

    private UserManagement() {
        File file = new File("user.txt");
        if (file.exists()) {
            try {
                readFile("user.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }

    public boolean validPassword(String password) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,12}$";
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(password).matches();
    }

    public static UserManagement getInstance() {

        if (userManagement == null) {
            userManagement = new UserManagement();
        }
        return userManagement;
    }

//    public void displayUser() {
//        for (User user : this.users) {
//            System.out.println(user);
//        }
//    }


    public void register(User user) {
        users.add(user);
        try {
            writeFile("user.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean checkUsernameExists(String username) {
        boolean isUsername = false;
        int index = findUserByUserName(username);
        if (index != -1) {
            return !isUsername;
        }
        return isUsername;
    }

    public int findUserByUserName(String username) {
        int index = -1;
        for (int i = 0; i < users.size(); i++) {
            if (username.equals(this.users.get(i).getUserName())) {
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        InputStream inputStream = new FileInputStream(path);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        this.users = (List<User>) objectInputStream.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.users);
    }

    public boolean checkUser(User user) {
        boolean isUser = true;
        for (int i = 0; i < this.users.size(); i++) {
            if (this.users.get(i).getUserName().equals(user.getUserName()) && (this.users.get(i).getPassword().equals(user.getPassword()))) {
                return isUser;
            }
        }
        return !isUser;
    }

    public void changePassword(User user,String password) {
        int index=findUserByUserName(user.getUserName());
        for (int i = 0; i < this.users.size(); i++) {
            this.users.get(index).setPassword(password);
        }
    }
//    public String findPasswordByUsername(String username)
//    {
//        String password="";
//        int index=findUserByUserName(username);
//        for (int i = 0; i < this.users.size(); i++) {
//            password=this.users.get(index).getPassword();
//        }
//        return password;
//    }

}

