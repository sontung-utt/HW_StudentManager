package view;

import input.Input;
import manager.ClassManager;
import model.Classes;

import java.util.List;

public class MenuClass {

    ClassManager classManager = new ClassManager();

    public void showMenuClass() {
        int choice;
        do {
            System.out.println("========Quản lý lớp học========");
            System.out.println("1. Thêm mới lớp học");
            System.out.println("2. Sửa thông tin lớp học");
            System.out.println("3. Xóa lớp học");
            System.out.println("4. Hiển thị danh sách lớp học");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showAddClass();
                    break;
                case 2:
                    showEditClass();
                    break;
                case 3:
                    showRemoveClass();
                    break;
                case 4:
                    showAllClass();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý lớp học!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showAddClass() {
        System.out.println("=====Thêm mới lớp học=====");
        System.out.print("Nhập khối lớp: ");
        String unit = Input.inputString();
        System.out.print("Nhập tên lớp: ");
        String name = Input.inputString();
        System.out.print("Nhập khóa: ");
        String course = Input.inputString();
        Classes classes = new Classes(unit, name, course);
        classManager.add(classes);
        System.out.println("Thêm mới lớp học thành công!");
    }

    private void showEditClass() {
        System.out.println("=====Sửa thông tin lớp học=====");
        System.out.print("Nhập mã lớp học muốn sửa: ");
        int idEdit = Input.inputInteger();
        if (classManager.findIndexById(idEdit)!=-1){
            System.out.print("Nhập khối lớp: ");
            String unit = Input.inputString();
            System.out.print("Nhập tên lớp: ");
            String name = Input.inputString();
            System.out.print("Nhập khóa: ");
            String course = Input.inputString();
            Classes classes = new Classes(idEdit,unit,name,course);
            classManager.update(idEdit,classes);
            System.out.println("Sửa thông tin lớp học thành công!");
        } else {
            System.out.println("Không tìm thấy mã lớp học!");
        }
    }

    private void showRemoveClass() {
        System.out.println("=====Xóa lớp học=====");
        System.out.print("Nhập mã lớp học muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (classManager.findIndexById(idRemove) != -1) {
            classManager.remove(idRemove);
            System.out.println("Xóa lớp học thành công!");
        } else {
            System.out.println("Không tìm thấy mã lớp học!");
        }
    }

    private void showAllClass() {
        System.out.println("=====Danh sách lớp học=====");
        List<Classes> classList = classManager.getAll();
        for (Classes classes : classList) {
            System.out.println(classes);
        }
    }
}
