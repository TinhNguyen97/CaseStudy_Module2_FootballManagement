package com.company.view;

import com.company.controller.MenuManagement;
import com.company.controller.UserManagement;
import com.company.model.User;

import java.util.Scanner;

public class LoginMenu {
    public static Scanner scanner = new Scanner(System.in);
    private UserManagement userManagement = UserManagement.getInstance();
    private MenuManagement menuManagement = new MenuManagement();

    public void run() {
        int choice = -1;

        do {
            menuLogin();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    doLogin();
                    break;
                case 2:
                    doRegister();
                    break;
                case 3:
                    changePassword();
                    break;

            }
        } while (choice != 0);
    }


    public void doLogin() {
        System.out.println("---ĐĂNG NHẬP---");
        User user = loginUser();
        checkLogin(user);
    }

    private void checkLogin(User user) {
        boolean isUser = userManagement.checkUser(user);
        if (!isUser) {
            System.err.println("Tài khoản hoặc mật khẩu không đúng");
        } else {
            System.out.println("Đăng nhập thành công!");
            menuManagement.run();
        }

    }

    private void changePassword() {
        boolean isUser;
        String newPassword;
        do {
            System.out.println("---ĐỔI MẬT KHẨU---");
            User user = loginUser();
            isUser = userManagement.checkUser(user);
            if (!isUser) {
                System.err.println("Tài khoản hoặc mật khẩu không đúng!");
            } else {
                newPassword = inputPassword();
                userManagement.changePassword(user, newPassword);
                System.out.println("Đổi mật khẩu thành công!");
            }
        } while (!isUser);
    }

    private User loginUser() {
        System.out.println("Nhập username:");
        String username = scanner.nextLine();
        System.out.println("Nhâp password:");
        String password = scanner.nextLine();
        User user = new User(username, password);
        return user;
    }

    private void doRegister() {
        System.out.println("---ĐĂNG KÝ---");
        User user = creatUser();
        userManagement.register(user);
        System.out.println("Đăng ký thành công!");
    }


    private User creatUser() {
        String username = inputUsername();
        String password = inputPassword();
        User user = new User(username, password);
        return user;
    }

    private String inputPassword() {
        String password;
        boolean isValid;
        do {
            System.out.println("Nhập mật khẩu tạo mới(6-12 ký tự,có ít nhất 1 chữ viết hoa và 1 chữ số):");
            password = scanner.nextLine();
            isValid = userManagement.validPassword(password);
            if (!isValid) {
                System.err.println("Mật khẩu không hợp lệ");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (!isValid);
        return password;
    }

    private String inputUsername() {
        String userName;
        do {
            System.out.println("Nhập username(6-12 ký tự):");
            userName = scanner.nextLine();
            if (userName.length() < 6) {
                System.err.println("Tài khoản phải có ít nhất 6 ký tự!");
            } else if (userName.length() > 12) {
                System.err.println("Tài khoản không vượt quá 12 ký tự!");
            } else if (userManagement.checkUsernameExists(userName)) {
                System.err.println("Tài khoản này đã trùng lặp!");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } while (userName.length() < 6 || userName.length() > 12 || userManagement.checkUsernameExists(userName));

        return userName;

    }


    private void menuLogin() {
        System.out.println("---ỨNG DỤNG QUẢN LÝ BÓNG ĐÁ---");
        System.out.println("1.Đăng nhập");
        System.out.println("2.Đăng ký");
        System.out.println("3.Đổi mật khẩu");
        System.out.println("0.Thoát");
        System.out.println("Nhập lựa chọn của bạn");
    }

}
