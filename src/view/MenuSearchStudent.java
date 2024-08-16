package view;

import input.Input;
import manager.ClassManager;
import manager.StudentManager;
import model.Classes;
import model.Student;

import java.util.List;

public class MenuSearchStudent {

    StudentManager studentManager = new StudentManager();
    ClassManager classManager = new ClassManager();

    public void showMenuSearchStudent(){
        int choice;
        do {
            System.out.println("========Quản lý tìm kiếm sinh viên========");
            System.out.println("1.Tìm kiếm sinh viên theo khoảng điểm");
            System.out.println("2.Tìm kiếm sinh viên theo hạnh kiểm");
            System.out.println("3.Tìm kiếm theo lớp");
            System.out.println("4.Tìm kiếm sinh viên có điểm trung bình cao nhất");
            System.out.println("5. Sắp xếp sinh viên theo điểm trung bình");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showStudentByRangeMark();
                    break;
                case 2:
                    showStudentByConduct();
                    break;
                case 3:
                    showStudentByClass();
                    break;
                case 4:
                    showStudentHighestMark();
                    break;
                case 5:
                    showSortStudent();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý tìm kiếm sinh viên!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showStudentByRangeMark() {
        System.out.println("=====Tìm kiếm sinh viên theo khoảng điểm=====");

        double min, max;
        do {
            do {
                System.out.print("Nhập điểm thấp nhất: ");
                min = Input.inputDouble();
                if (min < 0 || min > 10) {
                    System.out.println("Điểm không hợp lệ! Yêu cầu nhập lại.");
                }
            } while (min < 0 || min > 10);
            do {
                System.out.print("Nhập điểm cao nhất: ");
                max = Input.inputDouble();
                if (max < 0 || max > 10) {
                    System.out.println("Điểm không hợp lệ! Yêu cầu nhập lại.");
                }
            } while (max < 0 || max > 10);
            if (min >= max){
                System.out.println("Nhập không hợp lệ! Yêu cầu nhập lại.");
            }
        } while (min >= max);

        List<Student> list = studentManager.getStudentByRangeMark(min,max);
        if (list.isEmpty()){
            System.out.println("Không có sinh viên nào có khoảng điểm từ " + min + " đến " + max);
        } else {
            System.out.println("Danh sách sinh viên có điểm từ " + min + " đến " + max);
            for(Student student: list) {
                System.out.println(student);
            }
        }
    }

    private void showStudentByConduct() {
        System.out.println("=====Tìm kiếm sinh viên theo hạnh kiểm=====");
        System.out.print("Nhập hạnh kiểm: ");
        String conduct = Input.inputString();
        List<Student> list = studentManager.getStudentByConduct(conduct);
        if (list.isEmpty()){
            System.out.println("Không có sinh viên nào hạnh kiểm " + conduct);
        } else {
            System.out.println("Danh sách sinh viên hạnh kiếm " + conduct);
            for (Student student : list) {
                System.out.println(student);
            }
        }
    }

    private void showStudentByClass() {
        System.out.println("=====Tìm kiếm sinh viên theo lớp=====");
        List<Classes> list = classManager.getAll();
        System.out.println("Danh sách lớp học");
        for (int i = 0; i < list.size(); i++){
            System.out.println((i + 1) + ". " + list.get(i).getName());
        }
        int indexClass, idClass;
        do {
            System.out.print("Nhập mã lớp: ");
            int choiceClass = Input.inputInteger();
            indexClass = choiceClass - 1;
            if (indexClass >= list.size() || indexClass < 0) {
                System.out.println("Không tồn tại lớp! Yêu cầu nhập lại.");
            }
        } while (indexClass >= list.size() || indexClass < 0);
        idClass = classManager.getIdClass(indexClass);
        List<Student> students = studentManager.getStudentByClass(idClass);
        if (students.isEmpty()) {
            System.out.println("Không có sinh viên nào trong lớp " + classManager.findClassById(idClass).getName());
        } else {
            System.out.println("Danh sách sinh viên trong lớp " + classManager.findClassById(idClass).getName());
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    private void showStudentHighestMark() {
        System.out.println("=====Tìm kiếm sinh viên có điểm trung bình cao nhất=====");
        System.out.println(studentManager.getStudentHighestMark());
    }

    private void showSortStudent() {
        System.out.println("=====Sắp xếp sinh viên theo điểm trung bình=====");
        List<Student> students = studentManager.getSortStudent();
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
