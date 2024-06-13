package repositories;

import models.NotFoundStudentException;
import models.Student;

import java.io.*;
import java.util.ArrayList;

public class StudentRepository {
    public boolean add(Student student) {
        File file = new File("src/repositories/data/students.csv");
        BufferedWriter bufferedWriter = null;
        ArrayList<Student> students = getAll();
        for (Student s : students) {
            if (student.getPhoneNumber() == s.getPhoneNumber()) {
                return false;
            }
        }
        int max_index = students.size();
        try {
            FileWriter fileWriter = new FileWriter(file, true);
            bufferedWriter = new BufferedWriter(fileWriter);
            max_index = max_index + 1;
            student.setId(max_index);
            bufferedWriter.write(student.toString());
            bufferedWriter.newLine();
        } catch (IOException e) {
            System.out.println("Lỗi nhập liệu");
        } finally {
            try {
                if(bufferedWriter != null) {
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Không thể đóng file");
            }
        }
        return true;
    }

    public ArrayList<Student> getAll() {
        File file = new File("src/repositories/data/students.csv");
        ArrayList<Student> students = new ArrayList<>();
        Student student;
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            String[] arr;
            while ((line = bufferedReader.readLine()) != null) {
                arr = line.split(",");
                student = new Student(arr[1],arr[2],arr[3].equals("true"),Integer.parseInt(arr[4]),Integer.parseInt(arr[5]));
                student.setId(Integer.parseInt(arr[0]));
                students.add(student);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Không tìm thấy file");
        } catch (IOException e) {
            System.out.println("Lỗi đọc file");
        }
        return students;
    }

    public void delete(int studentId) throws NotFoundStudentException{
        ArrayList<Student> students = getAll();
        if(!contain(studentId)) throw new NotFoundStudentException();
        for (Student student : students) {
            if (student.getId() == studentId) {
                students.remove(student);
                break;
            }
        }
        File file = new File("src/hospital/repositories/data/medicals_records.csv");
        FileWriter fileWriter;
        BufferedWriter bufferedWriter = null;
        int index = 1;
        try {
            fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Student student : students) {
                bufferedWriter.write(index + "," + student.getName()+ "," + student.getDayOfBirth()+ "," + student.isMale()+ "," + student.getPhoneNumber()+ "," + student.getClassId());
                bufferedWriter.newLine();
                index = index + 1;
            }
        } catch (IOException e) {
            System.out.println("Lỗi nhập liệu");
        } finally {
            try {
                if (bufferedWriter!=null){
                    bufferedWriter.close();
                }
            } catch (IOException e) {
                System.out.println("Không thể đóng file");
            }
        }
    }

    public boolean contain(int studentId) {
        ArrayList<Student> students = getAll();
        for (Student student : students) {
            if (student.getId() == studentId) {
                return true;
            }
        }
        return false;
    }

    public String viewAll() {
        ClassRepository classRepo = new ClassRepository();
        ArrayList<Student> students = getAll();
        String line ="";
        for (Student student : students) {
            line += student.getId() +","+ student.getName() +","+ student.getDayOfBirth() +", isMale: "+ student.isMale() +", " +classRepo.findClassNameById(student.getClassId())  + "\n";
        }
        return line;
    }
}
