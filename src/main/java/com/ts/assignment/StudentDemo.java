package com.ts.assignment;


import com.ts.assignment.que2.Student;
import com.ts.assignment.que2.StudentService;
import com.ts.assignment.que2.StudentServiceImpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentDemo {
    public static void main(String a[]) throws IOException {
        List<Student> students = new ArrayList<>();

        students.add(new Student(new Integer(33), "Tina", new Double(3.68)));
        students.add(new Student(new Integer(85), "Louis", new Double(3.85)));
        students.add(new Student(new Integer(56), "Samar", new Double(3.75)));
        students.add(new Student(new Integer(19), "Samil", new Double(3.75)));
        students.add(new Student(new Integer(22), "Lorry", new Double(3.76)));
        StudentService studentService = new StudentServiceImpl(students);
        System.out.println("-------- Ranking List - Student Names --------");
        studentService.getStudentNameListBasedGPA().stream().forEach(System.out::println);
    }
}
