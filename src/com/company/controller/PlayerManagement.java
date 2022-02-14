package com.company.controller;

import com.company.model.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerManagement implements IGeneralManagement<Player>, ReadFile, WriteFile {
    private List<Player> players = new ArrayList<>();
    private static PlayerManagement playerManagement;
    private PlayerManagement() {
        File file = new File("player.txt");
        if (file.exists()) {
            try {
                readFile("player.txt");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public static PlayerManagement getInstance() {
        if (playerManagement == null) {
            playerManagement = new PlayerManagement();
        }
        return playerManagement;
    }

    @Override
    public void displayAll() {
        for (Player player : players) {
            System.out.println(player);
        }
    }

    @Override
    public void addNew(Player player) {
        this.players.add(player);
        try {
            writeFile("player.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateByName(String name, Player player) {
        int index = findPlayerByName(name);
        this.players.set(index, player);

    }

    @Override
    public boolean deleteByName(String name) {
        int index = findPlayerByName(name);
        if (index != -1) {
            this.players.remove(index);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Player getByName(String name) {
        int index = findPlayerByName(name);
        return this.players.get(index);
    }

    public int findPlayerByName(String name) {
        int index = -1;
        for (int i = 0; i < this.players.size(); i++) {
            if (name.equals(this.players.get(i).getName())) {
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
        this.players = (List<Player>) objectInputStream.readObject();
    }

    @Override
    public void writeFile(String path) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(this.players);
    }
    public void sort()
    {
        players.sort(new PlayerComparator());
    }
}
