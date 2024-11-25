package controllers;


import models.Student;


import java.util.ArrayList;

public class StudentController {
    private ArrayList<Student> students;

    public StudentController() {
        students = new ArrayList<>();
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent(int index, Student updatedStudent) {
        students.set(index, updatedStudent);
    }

    public void deleteStudent(int index) {
        students.remove(index);
    }
}
