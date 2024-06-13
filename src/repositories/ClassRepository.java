package repositories;

import models.ClassRoom;
import models.Student;

import java.io.*;
import java.util.ArrayList;

public class ClassRepository {
    public String findClassNameById(int id){
        ArrayList<ClassRoom> classes = getAll();
        for(ClassRoom class1:classes){
            if(class1.getId() == id){
                return class1.getName();
            }
        }
        return null;
    }

    public ArrayList<ClassRoom> getAll() {
        File file = new File("src/repositories/data/class.csv");
        ArrayList<ClassRoom> classes = new ArrayList<>();
        ClassRoom class1;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                class1 = new ClassRoom(Integer.parseInt(arr[0]),arr[1],Integer.parseInt(arr[2]));
                classes.add(class1);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return classes;
    }
}
