package repositories;

import models.Student;
import models.Teacher;

import java.io.*;
import java.util.ArrayList;

public class TeacherRepository {
    public ArrayList<Teacher> getAll() {
        File file = new File("src/repositories/data/teachers.csv");
        ArrayList<Teacher> teachers = new ArrayList<>();
        Teacher teacher;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                teacher = new Teacher(arr[1],arr[2],arr[3].equals("true"),Integer.parseInt(arr[4]));
                teacher.setId(Integer.parseInt(arr[0]));
                teachers.add(teacher);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return teachers;
    }
}
