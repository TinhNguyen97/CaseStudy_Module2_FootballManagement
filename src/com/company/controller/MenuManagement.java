package com.company.controller;

import com.company.controller.UserManagement;
import com.company.view.CoachMenu;
import com.company.view.LoginMenu;
import com.company.view.PlayerMenu;

import java.util.Scanner;

public class MenuManagement {
    public static Scanner scanner = new Scanner(System.in);
    private CoachMenu coachMenu = new CoachMenu();
    private PlayerMenu playerMenu = new PlayerMenu();

    public void run() {
        int choice = -1;
        do {
            menuManagement();
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    coachMenu.run();
                    break;
                case 2:
                    playerMenu.run();
                    break;
            }
        } while (choice != 0);
    }

    private static void menuManagement() {
        System.out.println("1.Quản lý huấn luyện viên");
        System.out.println("2.Quản lý cầu thủ");
        System.out.println("0.Đăng xuất");
        System.out.println("Nhập lựa chọn của bạn");
    }


}
