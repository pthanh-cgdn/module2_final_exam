package controllers;

import models.Student;
import models.Teacher;
import services.StudentService;
import views.View;

import java.util.ArrayList;

public class MainController {
    public static void main(String[] args) {
        int choice;
        Student student;
        View view = new View();
        boolean result;
        StudentService service = new StudentService();
        int studentId;
        boolean contain;
        boolean confirm;
        ArrayList<Student> students = new ArrayList<>();
        String display;
        String StudentName;
        int teacherId;
        Teacher teacher;
        while (true){
            choice = view.menuView();
            switch (choice){
                case 1:
                    student = view.addView();
                    result = service.add(student);
                    view.showMessage(result);
                    break;
                case 2:
                    studentId = view.deleteView();
                    contain = service.contain(studentId);
                    if (!contain) {
                        view.notContainMessage(studentId);
                    } else {
                        confirm = view.confirmDelete(studentId);
                        if (confirm) {
                            service.delete(studentId);
                        }
                    }
                    display = service.viewAll();
                    view.viewAll(display);
                    break;
                case 3:
                    display = service.viewAll();
                    view.viewAll(display);
                    break;
                case 4:
                    teacherId = view.findTeacherId();
                    contain = service.contain(teacherId);
                    if (contain) {
                        teacher = service.findTeacherId(teacherId);
                        view.viewTeacher(teacher);
                    } else {
                        view.notContainMessageTeacher(teacherId);
                    }
                    break;
//                case 5:
//                    StudentName = view.findByStudentName();
//                    contain = service.contain(StudentName);
//                    if (contain) {
//                        Student = service.findByPatientNumber(StudentName);
//                        view.viewAll(records);
//                    } else {
//                        view.notContainMessage(patientNumber);
//                    }
//                    break;
                case 0:
                    return;
            }
        }
    }
}
