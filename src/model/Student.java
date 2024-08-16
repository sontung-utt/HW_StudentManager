package model;

import javax.security.auth.Subject;
import java.util.Arrays;

public class Student {
    private int id;
    private String name;
    private int numMark;
    private double[] marks;
    private String gender;
    private String conduct;
    private int idClass;
    private double avgMark;
    private static int idIncrement = 1;

    public Student(){
    }

    public Student(String name, int numMark, double[] marks, String gender, String conduct, int idClass) {
        this.id = idIncrement;
        this.name = name;
        this.numMark = numMark;
        this.marks = marks;
        this.avgMark = getAverageMark(marks);
        this.gender = gender;
        this.conduct = conduct;
        this.idClass = idClass;
        idIncrement++;
    }

    public Student (int id, String name, int numMark, double[] marks,String gender, String conduct, int idClass) {
        this.id = id;
        this.name = name;
        this.numMark = numMark;
        this.marks = marks;
        this.avgMark = getAverageMark(marks);
        this.gender = gender;
        this.conduct = conduct;
        this.idClass = idClass;
        if(id >= idIncrement) {
            idIncrement = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public double[] getMarks() {
        return marks;
    }

    public void setMarks(double[] marks) {
        this.marks = marks;
        this.avgMark = getAverageMark(marks);
    }

    public String getConduct() {
        return conduct;
    }

    public void setConduct(String conduct) {
        this.conduct = conduct;
    }

    public int getNumMark() {
        return numMark;
    }

    public void setNumMark(int numMark) {
        this.numMark = numMark;
    }

    public double getAvgMark() {
        return avgMark;
    }

    public void setAvgMark(double avgMark) {
        this.avgMark = avgMark;
    }

    private double getAverageMark(double[] marks) {
        double sum = 0;
        for (double mark : marks) {
            sum += mark;
        }
        avgMark = sum/marks.length;
        return avgMark;
    }

    public String toString() {
        return "=====Sinh viên=====" +
                "\nMã sinh viên: " + id +
                "\nTên sinh viên: " + name +
                "\nGiới tính: " + gender +
                "\nHạnh kiểm: " + conduct +
                "\nĐiểm trung bình: " + Math.round(avgMark*100.0)/100.0;
    }
}
