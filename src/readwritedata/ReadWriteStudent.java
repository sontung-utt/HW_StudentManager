package readwritedata;

import com.sun.deploy.security.ruleset.RuleSetParser;
import model.Student;

import java.io.*;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class ReadWriteStudent {
    File file = new File("data/student.csv");

    public void WriteStudent (List<Student> studentList) {
        String data = "";
        for (Student student : studentList) {
            data += student.getId() + "," + student.getName() + "," + student.getNumMark() + "," + student.getAvgMark() + "," +
                    student.getGender() + "," + student.getConduct() + "," + student.getIdClass() + "\n";
        }
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(data);
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Student> ReadStudent(){
        List<Student> studentList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null) {
                String[] data = line.split(",");
                int numMark = Integer.parseInt(data[2]);
                double avgMark = Double.parseDouble(data[3]);
                Student student = new Student(Integer.parseInt(data[0]), data[1], numMark, new double[numMark], data[4], data[5], Integer.parseInt(data[6]));
                student.setAvgMark(avgMark);
                studentList.add(student);
            }
        } catch(Exception e) {
            System.out.println(e);
        }
        return studentList;
    }
}
