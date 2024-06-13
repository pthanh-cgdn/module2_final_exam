package services;

import models.NotFoundStudentException;
import models.Student;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

import java.util.ArrayList;

public class StudentService {
    StudentRepository studentRepo = new StudentRepository();
    public boolean add(Student student) {
        return studentRepo.add(student);
    }

    public boolean contain(int studentId) {
        return studentRepo.contain(studentId);
    }

    public void delete(int studentId) {
        try {
            studentRepo.delete(studentId);
        } catch (NotFoundStudentException e) {
            System.out.println("Sinh viên không tồn tại");
        }
    }

    public String viewAll() {
        return studentRepo.viewAll();

    }


    public Teacher findTeacherId(int teacherId) {
        TeacherRepository teacherRepo = new TeacherRepository();
        ArrayList<Teacher> teacher =  teacherRepo.getAll();
        for (Teacher t : teacher) {
            if(t.getId() == teacherId) {
                return t;
            }
        }
        return null;
    }
}
