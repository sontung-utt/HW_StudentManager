package manager;

import com.sun.org.apache.regexp.internal.RE;
import model.Student;
import readwritedata.ReadWriteStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager implements IManager<Student>{

    List<Student> studentList;
    ReadWriteStudent readWriteStudent = new ReadWriteStudent();

    public StudentManager() {
        this.studentList = this.readWriteStudent.ReadStudent();
    }
    @Override
    public void add(Student student) {
        studentList.add(student);
        readWriteStudent.WriteStudent(studentList);
    }

    @Override
    public void update(int id, Student student) {
        int index = findIndexById(id);
        studentList.set(index, student);
        readWriteStudent.WriteStudent(studentList);
    }

    @Override
    public void remove(int id) {
        int index = findIndexById(id);
        studentList.remove(index);
        readWriteStudent.WriteStudent(studentList);
    }

    @Override
    public List<Student> getAll() {
        this.studentList = this.readWriteStudent.ReadStudent();
        return this.studentList;
    }

    @Override
    public int findIndexById(int id) {
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public List<Student> getStudentByRangeMark(double min, double max) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++){
            if (studentList.get(i).getAvgMark()>=min && studentList.get(i).getAvgMark()<=max) {
                students.add(studentList.get(i));
            }
        }
        return students;
    }

    public List<Student> getStudentByConduct(String conduct) {
        List<Student> students = new ArrayList<>();
        for(int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getConduct().equalsIgnoreCase(conduct)){
                students.add(studentList.get(i));
            }
        }
        return students;
    }

    public List<Student> getStudentByClass(int id){
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getIdClass()==id) {
                students.add(studentList.get(i));
            }
        }
        return students;
    }

    public Student getStudentHighestMark() {
        Student highestStudent = studentList.get(0);
        for (Student student : studentList) {
            if (student.getAvgMark() > highestStudent.getAvgMark()){
                highestStudent = student;
            }
        }
        return highestStudent;
    }

    public List<Student> getSortStudent() {
        List<Student> students = getAll();
        students.sort((s1,s2) -> Double.compare(s2.getAvgMark(),s1.getAvgMark()));
        return students;
    }

}
