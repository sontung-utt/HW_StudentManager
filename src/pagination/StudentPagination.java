package pagination;

import input.Input;
import model.Student;

import java.util.List;

public class StudentPagination {
     private static final int STUDENTS_PER_PAGE = 5;

     public void showAllStudentsPagination(List<Student> studentList) {
         int totalStudents = studentList.size();
         int totalPages = (int) Math.ceil((double) totalStudents/STUDENTS_PER_PAGE);
         int pageNumber = 1;
          while (true) {
              List<Student> studentPerPage = getStudentPerPage(studentList,pageNumber);
              for (Student student : studentPerPage) {
                  System.out.println(student);
              }
              System.out.println("\nTrang " + pageNumber + " của " + totalPages);
              System.out.println("Nhấn Enter để chuyển trang hoặc gõ b để trở về trang quản lý sinh viên!");
              String input = Input.inputString();
              if ("b".equalsIgnoreCase(input)){
                  break;
              }
              if (pageNumber < totalPages && input.isEmpty()){
                  pageNumber++;
              } else if (pageNumber >= totalPages) {
                  System.out.println("Đã hiển thị hết các trang danh sách sinh viên!");
                  break;
              }
          }
     }

     private List<Student> getStudentPerPage(List<Student> students, int pageNumber){
         int start = (pageNumber - 1) * STUDENTS_PER_PAGE;
         int end = Math.min(start + STUDENTS_PER_PAGE, students.size());
         return students.subList(start, end);
     }
}
