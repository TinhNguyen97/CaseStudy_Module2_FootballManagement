package com.company.view;

import com.company.controller.CoachManagement;
import com.company.model.Coach;

import java.util.Scanner;

public class CoachMenu {
    public static Scanner scanner = new Scanner(System.in);

    public void run() {

        CoachManagement coachManagement = CoachManagement.getInstance();

        int choice = -1;
        do {
            menu();
            choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    displayCoach(coachManagement);
                    break;
                }
                case 2: {
                    addNewCoach(coachManagement);
                    break;
                }
                case 3: {
                    updateCoach(coachManagement);
                    break;
                }
                case 4: {
                    deleteCoach(coachManagement);
                    break;
                }
                case 5: {
                    findCoach(coachManagement);
                    break;
                }
                case 6:
                    sortCoachByAge(coachManagement);
                    break;
            }
        } while (choice != 0);
    }

    private static void sortCoachByAge(CoachManagement coachManagement) {
        coachManagement.sort();
        System.out.println("Sắp xếp thành công!");
    }

    private static void findCoach(CoachManagement coachManagement) {
        int index;
        System.out.println("---TÌM THÔNG TIN HUẤN LUYỆN VIÊN---");
        System.out.println("Nhập tên huấn luyện viên cần tìm:");
        scanner.nextLine();
        String name = scanner.nextLine();
        index = coachManagement.findCoachByName(name);
        if (index != -1) {
            System.out.println(coachManagement.getByName(name));
        } else {
            System.out.println("Không có huấn luyện viên cần tìm!");
        }
    }

    private static void deleteCoach(CoachManagement coachManagement) {
        int index;
        System.out.println("---XÓA HUẤN LUYỆN VIÊN---");
        System.out.println("Nhập tên huấn luyện viên cần xóa");
        scanner.nextLine();
        String name = scanner.nextLine();
        index = coachManagement.findCoachByName(name);
        if (index != -1) {
            coachManagement.deleteByName(name);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Tên huấn luyện cần xóa không hợp lệ!");
        }
    }

    private static void updateCoach(CoachManagement coachManagement) {
        int index;
        System.out.println("---CẬP NHẬT HUẤN LUYỆN VIÊN---");
        System.out.println("Nhập tên huấn luyện viên cần sửa:");
        scanner.nextLine();
        String name = scanner.nextLine();
        index = coachManagement.findCoachByName(name);
        if (index != -1) {
            Coach coach = getCoach();
            coachManagement.updateByName(name, coach);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Tên huấn luyện viên cần sửa không tồn tại!");
        }
    }

    private static void addNewCoach(CoachManagement coachManagement) {
        scanner.nextLine();
        coachManagement.addNew(getCoach());
    }

    private static void displayCoach(CoachManagement coachManagement) {
        System.out.println("---DANH SÁCH HUẤN LUYỆN VIÊN---");
        coachManagement.displayAll();
    }

    private static Coach getCoach() {
        System.out.println("---THÊM HUẤN LUYỆN VIÊN---");
        System.out.println("Nhập tên huấn luyện viên:");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi huấn luyện viên:");
        int age = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Nhập quốc tịch huấn luyện viên:");
        String country = scanner.nextLine();
        return new Coach(name, age, country);
    }

    private static void menu() {
        System.out.println("---MENU QUẢN LÝ HUẤN LUYỆN VIÊN---");
        System.out.println("1.Hiển thị danh sách huấn luyện viên");
        System.out.println("2.Thêm huấn luyện viên");
        System.out.println("3.Cập nhật huấn luyện viên");
        System.out.println("4.Xóa huấn luyện viên");
        System.out.println("5.Tìm huấn luyện viên");
        System.out.println("6.Sắp xếp huấn luyện viên theo tuổi tăng dần");
        System.out.println("0.Quay lại");
        System.out.println("Nhập lựa chọn của bạn:");
    }
}