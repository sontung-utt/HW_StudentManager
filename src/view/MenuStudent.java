package view;

import input.Input;
import manager.ClassManager;
import manager.StudentManager;
import model.Classes;
import model.Student;
import pagination.StudentPagination;

import java.util.List;

public class MenuStudent {

    StudentManager studentManager = new StudentManager();
    ClassManager classManager = new ClassManager();
    Student student = new Student();
    MenuSearchStudent menuSearchStudent = new MenuSearchStudent();
    StudentPagination studentPagination = new StudentPagination();

    public void showMenuStudent() {
        int choice;
        do {
            System.out.println("========Quản lý sinh viên========");
            System.out.println("1.Thêm mới sinh viên");
            System.out.println("2.Sửa thông tin sinh viên");
            System.out.println("3.Xóa sinh viên");
            System.out.println("4.Hiển thị danh sách sinh viên");
            System.out.println("5.Tìm kiếm sinh viên");
            System.out.println("6. Hiển thị phân trang danh sách sinh viên");
            System.out.println("0. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");
            choice = Input.inputInteger();
            switch (choice) {
                case 1:
                    showAddStudent();
                    break;
                case 2:
                    showEditStudent();
                    break;
                case 3:
                    showRemoveStudent();
                    break;
                case 4:
                    showAllStudent();
                    break;
                case 5:
                    menuSearchStudent.showMenuSearchStudent();
                    break;
                case 6:
                    showPaginationStudent();
                    break;
                case 0:
                    System.out.println("Thoát chương trình quản lý sinh viên!");
                    break;
                default:
                    System.out.println("Không có lựa chọn phù hợp!");
                    break;
            }
        } while (choice != 0);
    }

    private void showAddStudent() {
        System.out.println("=====Thêm mới sinh viên=====");
        System.out.print("Nhập tên sinh viên: ");
        String name = Input.inputString();
        System.out.print("Nhập giới tính: ");
        String gender = Input.inputString();
        System.out.println("Danh sách lớp học");
        List<Classes> classList = classManager.getAll();
        for (int i = 0; i < classList.size(); i++){
            System.out.println((i + 1) + ". " + classList.get(i).getName());
        }
        int indexClass, idClass;
        do {
            System.out.print("Chọn lớp: ");
            int choiceClass = Input.inputInteger();
            indexClass = choiceClass - 1;
            if (indexClass >= classList.size() || indexClass < 0) {
                System.out.println("Không tồn tại lớp! Yêu cầu nhập lại.");
            }
        } while(indexClass >= classList.size() || indexClass < 0);
        idClass = classManager.getIdClass(indexClass);
        System.out.print("Nhập số môn học: ");
        int numMark = Input.inputInteger();
        System.out.println("Nhập điểm từng môn");
        double[] marks = new double[numMark];
        for (int i = 0; i < marks.length; i++){
            do {
                System.out.print("Nhập điểm môn thứ " + (i + 1) + ": ");
                marks[i] = Input.inputDouble();
                if (marks[i] < 0 || marks[i] > 10) {
                    System.out.println("Điểm không phù hợp! Yêu cầu nhập lại.");
                }
            } while (marks[i] < 0 || marks[i] > 10);
        }
        System.out.println("Danh sách điểm của sinh viên " + name);
        for (int i = 0; i < marks.length; i++) {
            System.out.print(marks[i] + " ");
        }
        System.out.println();
        System.out.print("Nhập hạnh kiểm: ");
        String conduct = Input.inputString();
        Student student = new Student(name, numMark, marks, gender, conduct, idClass);
        studentManager.add(student);
        System.out.println("Thêm sinh viên thành công!");
    }

    private void showEditStudent() {
        System.out.println("=====Sửa thông tin sinh viên=====");
        System.out.print("Nhập mã sinh viên muốn sửa: ");
        int idEdit = Input.inputInteger();
        if (studentManager.findIndexById(idEdit)!=-1) {
            System.out.print("Nhập tên sinh viên: ");
            String name = Input.inputString();
            System.out.print("Nhập giới tính: ");
            String gender = Input.inputString();
            System.out.println("Danh sách lớp học");
            List<Classes> classList = classManager.getAll();
            for (int i = 0; i < classList.size(); i++){
                System.out.println((i + 1) + ". " + classList.get(i).getName());
            }
            int indexClass;
            do {
                System.out.print("Chọn lớp: ");
                int choiceClass = Input.inputInteger();
                indexClass = choiceClass - 1;
                if (indexClass >= classList.size()) {
                    System.out.println("Không tồn tại lớp! Yêu cầu nhập lại.");
                }
            } while(indexClass >= classList.size());
            int idClass = classManager.getIdClass(indexClass);
            System.out.print("Nhập số môn học: ");
            int numMark = Input.inputInteger();
            System.out.println("Nhập điểm từng môn");
            double[] marks = new double[numMark];
            for (int i = 0; i < marks.length; i++){
                do {
                    System.out.print("Nhập điểm môn thứ " + (i + 1) + ": ");
                    marks[i] = Input.inputDouble();
                    if (marks[i] < 0 || marks[i] > 10) {
                        System.out.println("Điểm không phù hợp! Yêu cầu nhập lại.");
                    }
                } while (marks[i] < 0 || marks[i] > 10);
            }
            System.out.println("Danh sách điểm của sinh viên " + name);
            for (int i = 0; i < marks.length; i++) {
                System.out.print(marks[i] + " ");
            }
            System.out.println();
            System.out.print("Nhập hạnh kiểm: ");
            String conduct = Input.inputString();
            Student student = new Student(idEdit,name,numMark,marks,gender,conduct,idClass);
            studentManager.update(idEdit, student);
            System.out.println("Sửa thông tin sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy mã sinh viên!");
        }
    }

    private void showRemoveStudent() {
        System.out.println("=====Xóa sinh viên=====");
        System.out.print("Nhập mã sinh viên muốn xóa: ");
        int idRemove = Input.inputInteger();
        if (studentManager.findIndexById(idRemove) != -1) {
            studentManager.remove(idRemove);
            System.out.println("Xóa sinh viên thành công!");
        } else {
            System.out.println("Không tìm thấy mã sinh viên!");
        }
    }

    private void showAllStudent() {
        System.out.println("=====Danh sách sinh viên=====");
        List<Student> studentList = studentManager.getAll();
        for (Student student : studentList) {
            Classes classes = classManager.findClassById(student.getIdClass());
            System.out.println(student + "\nKhối lớp: " + classes.getUnit() + "\nTên lớp: " + classes.getName() + "\nKhóa học: " + classes.getCourse());
        }

    }

    private void showPaginationStudent() {
        List<Student> students = studentManager.getAll();
        studentPagination.showAllStudentsPagination(students);
    }

}
