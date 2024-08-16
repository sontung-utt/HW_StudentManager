package readwritedata;

import model.Classes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteClass {
    File file = new File("data/class.csv");

    public void WriteClass(List<Classes> classList) {
        String data = "";
        for (Classes classes : classList) {
            data += classes.getId() + "," + classes.getUnit() + "," + classes.getName() + "," + classes.getCourse() + "\n";
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

    public List<Classes> ReadClass() {
        List<Classes> classList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = "";
            while ((line = bufferedReader.readLine())!=null){
                String[] data =line.split(",");
                Classes classes = new Classes(Integer.parseInt(data[0]), data[1], data[2], data[3]);
                classList.add(classes);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return classList;
    }
}
