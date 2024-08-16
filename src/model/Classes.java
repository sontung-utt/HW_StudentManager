package model;

import java.util.ArrayList;
import java.util.List;

public class Classes {
    private int id;
    private String unit;
    private String name;
    private String course;
    private static int idIncrement = 1;

    public Classes(){
    }

    public Classes(String unit, String name, String course) {
        this.id = idIncrement;
        this.unit = unit;
        this.name = name;
        this.course = course;
        idIncrement++;
    }

    public Classes(int id, String unit, String name, String course) {
        this.id = id;
        this.unit = unit;
        this.name = name;
        this.course = course;
        if (id >= idIncrement) {
            idIncrement = id + 1;
        }
    }

    public int getId() {
        return id;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toString() {
        return "=====Lớp học=====" +
                "\nMã lớp học: " + id +
                "\nKhối lớp: " + unit +
                "\nTên lớp: " + name +
                "\nKhóa: " + course;

    }
}
