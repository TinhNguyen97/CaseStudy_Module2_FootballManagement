package com.company.view;

import com.company.controller.PlayerManagement;
import com.company.model.Player;

import java.util.Scanner;

public class PlayerMenu {
    public static Scanner scanner = new Scanner(System.in);

    public void run() {
        PlayerManagement playerManagement = PlayerManagement.getInstance();

        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    displayPlayer(playerManagement);
                    break;
                }
                case 2: {
                    addNewPlayer(playerManagement);
                    break;
                }
                case 3: {
                    updatePlayer(playerManagement);
                    break;
                }
                case 4: {
                    deletePlayer(playerManagement);
                    break;
                }
                case 5: {
                    findPlayer(playerManagement);
                    break;
                }
                case 6:
                    sortPlayerByAge(playerManagement);
                    break;
            }
        } while (choice != 0);
    }

    private static void sortPlayerByAge(PlayerManagement playerManagement) {
        playerManagement.sort();
        System.out.println("Sắp xếp thành công!");
    }

    private static void findPlayer(PlayerManagement playerManagement) {
        int index;
        System.out.println("---TÌM THÔNG TIN CẦU THỦ---");
        System.out.println("Nhập tên cầu thủ cần tìm:");
        scanner.nextLine();
        String name = scanner.nextLine();
        index = playerManagement.findPlayerByName(name);
        if (index != -1) {
            System.out.println(playerManagement.getByName(name));
        } else {
            System.out.println("Không có cầu thủ cần tìm!");
        }
    }

    private static void deletePlayer(PlayerManagement playerManagement) {
        int index;
        System.out.println("---XÓA CẦU THỦ---");
        System.out.println("Nhập tên cầu thủ cần xóa");
        scanner.nextLine();
        String name = scanner.nextLine();
        index = playerManagement.findPlayerByName(name);
        if (index != -1) {
            playerManagement.deleteByName(name);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Tên cầu thủ cần xóa không hợp lệ!");
        }
    }

    private static void updatePlayer(PlayerManagement playerManagement) {
        int index;
        System.out.println("---CẬP NHẬT CẦU THỦ---");
        System.out.println("Nhập tên cầu thủ cần sửa:");
        scanner.nextLine();
        String name = scanner.nextLine();
        index = playerManagement.findPlayerByName(name);
        if (index != -1) {
            Player player = getPlayer();
            playerManagement.updateByName(name, player);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Tên cầu thủ cần sửa không tồn tại!");
        }
    }

    private static void addNewPlayer(PlayerManagement playerManagement) {
        scanner.nextLine();
        playerManagement.addNew(getPlayer());
    }

    private static void displayPlayer(PlayerManagement playerManagement) {
        System.out.println("---DANH SÁCH CẦU THỦ---");
        playerManagement.displayAll();
    }

    private static Player getPlayer() {
        System.out.println("---THÊM CẦU THỦ---");
        System.out.println("Nhập tên cầu thủ:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi cầu thủ:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập chiều cao cầu thủ:");
        double height = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Nhập quốc tịch cầu thủ:");
        String country = scanner.nextLine();
        return new Player(name, age, height, country);
    }

    private static void menu() {
        System.out.println("---MENU QUẢN LÝ CẦU THỦ---");
        System.out.println("1.Hiển thị danh sách cầu thủ");
        System.out.println("2.Thêm cầu thủ");
        System.out.println("3.Cập nhật cầu thủ");
        System.out.println("4.Xóa cầu thủ");
        System.out.println("5.Tìm cầu thủ");
        System.out.println("6.Sắp xếp cầu thủ theo tuổi tăng dần");
        System.out.println("0.Quay lại");
        System.out.println("Nhập lựa chọn của bạn:");
    }
}
