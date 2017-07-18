package com.ts.assignment.que2;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceImplTest {


    private StudentService studentService = null;
    List<Student> students = new ArrayList<>();

    @Before
    public void initilse() {
        students.add(new Student(10, null, 0));
        students.add(new Student(19, "Samar", Double.valueOf(3.75)));
        students.add(new Student(22, "Lorry", Double.valueOf(3.76)));
        students.add(new Student(33, "Tina", Double.valueOf(3.68)));
        students.add(new Student(34, null, Double.valueOf(3.68)));
        students.add(new Student(80, null, 0));
        students.add(new Student(82, "Samil", Double.valueOf(3.75)));
        students.add(new Student(85, "Louis", Double.valueOf(3.85)));
        students.add(new Student(86, null, Double.valueOf(3.85)));
        students.add(new Student(87, null, 0));
        studentService = new StudentServiceImpl(students);
    }

    @Test
    public void getAllStudent() throws Exception {
        Assert.assertEquals(students.size(), studentService.getAllStudent().size());
    }

    @Test
    public void getStudentNameListBasedGPA() throws Exception {
        List<String> nameList = studentService.getStudentNameListBasedGPA();
        Assert.assertEquals("Louis", nameList.get(0));
        Assert.assertEquals(null, nameList.get(1));
        Assert.assertEquals("Lorry", nameList.get(2));
        Assert.assertEquals("Samar", nameList.get(3));
        Assert.assertEquals("Samil", nameList.get(4));
        Assert.assertEquals("Tina", nameList.get(5));
    }
}
