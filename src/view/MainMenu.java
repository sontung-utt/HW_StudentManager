package view;

import input.Input;
import manager.ClassManager;

public class MainMenu {

    MenuClass menuClass = new MenuClass();
    MenuStudent menuStudent = new MenuStudent();

    public void showMainMenu() {
        int choice;
        do {
            System.out.println("========Trang chủ========");
            System.out.println("1. Quản lý sinh viên");
            System.out.println("2. Quản lý lớp học");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    menuStudent.showMenuStudent();
                    break;
                case 2:
                    menuClass.showMenuClass();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }
}
