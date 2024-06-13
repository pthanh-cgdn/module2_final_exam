package views;

import models.Student;
import models.Teacher;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    public int menuView(){
        System.out.println("Chọn chức năng theo (để tiếp tục):");
        System.out.println("1. Thêm mới sinh viên");
        System.out.println("2. Xoá sinh viên");
        System.out.println("3. Xem danh sách sinh viên");
        System.out.println("4. Tìm kiếm giáo viên");
        System.out.println("5. Tìm kiếm sinh viên");
        System.out.println("0. Thoát");
        Scanner scanner = new Scanner(System.in);
        int choice = Integer.parseInt(scanner.nextLine());
        return choice;
    }

    public Student addView() {
        Scanner scanner = new Scanner(System.in);
        String name;
        String dayOfBirth;
        String gender;
        String phoneNumber;
        String classId;
        do {
            System.out.println("Vui lòng nhập trên sinh viên:");
            name = scanner.nextLine();
            if (!name.matches("[A-Za-z]{4,50}")){
                System.out.println("Vui lòng nhập tên sinh viên đúng định dạng");
            }
        } while(!name.matches("[A-Za-z]{4,50}"));

        do {
            System.out.println("Vui lòng nhập ngày sinh của sinh viên: (dd/MM/yyyy)");
            dayOfBirth = scanner.nextLine();
            if (!dayOfBirth.matches("[0-3][0-9]/[0-1][0-9]/\\d{4}")){
                System.out.println("Vui lòng nhập ngày sinh sinh viên đúng định dạng");
            }
        } while(!dayOfBirth.matches("[0-3][0-9]/[0-1][0-9]/\\d{4}"));

        do {
            System.out.println("Vui lòng nhập giới tính của sinh viên (F: Nữ, M: Nam):");
            gender = scanner.nextLine();
            if (!gender.matches("[MF]")){
                System.out.println("Vui lòng nhập ngày sinh sinh viên đúng định dạng");
            }
        } while(!gender.matches("[MF]"));
        do {
            System.out.println("Vui lòng nhập số điện thoại của sinh viên:");
            phoneNumber = scanner.nextLine();
            if (!phoneNumber.matches("09[01]\\d{7}")){
                System.out.println("Vui lòng nhập ngày sinh sinh viên đúng định dạng");
            }
        } while(!phoneNumber.matches("09[01]\\d{7}"));
        do {
            System.out.println("Vui lòng nhập số mã lớp học của sinh viên:");
            classId = scanner.nextLine();
            if (!classId.matches("\\d+}")){
                System.out.println("Vui lòng nhập ngày sinh sinh viên đúng định dạng");
            }
        } while(!classId.matches("\\d+"));
        return new Student(name,dayOfBirth,gender=="M",Integer.parseInt(phoneNumber),Integer.parseInt(classId));
    }

    public void showMessage(boolean result) {
        if(result){
            System.out.println("Tác vụ thành công");
        } else {
            System.out.println("Tác vụ thất bại");
        }
    }

    public int deleteView() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Vui lòng nhập mã sinh viên");
        String studentId = scanner.nextLine();
        return Integer.parseInt(studentId);
    }

    public void notContainMessage(int studentId) {
        System.out.println("Không tồn tại sinh viên có mã "+studentId);
    }

    public boolean confirmDelete(int studentId) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bạn có chắc chắn muốn xoá sinh viên có mã "+studentId);
        boolean confirm = scanner.nextLine().equals("Y");
        return confirm;
    }

    public void viewAll(String display) {
        System.out.println(display);
    }

    public String findByStudentName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Student Name:");
        String studentName = scanner.nextLine();
        return studentName;
    }

    public int findTeacherId() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input Teacher id:");
        String teacherId = scanner.nextLine();
        return Integer.parseInt(teacherId);
    }

    public void viewTeacher(Teacher teacher) {
        System.out.println(teacher.toString());
    }

    public void notContainMessageTeacher(int teacherId) {
        System.out.println("Không tồn tại giáo viên có mã "+teacherId);
    }
}
