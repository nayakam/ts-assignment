package com.ts.assignment.que2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StudentServiceImpl implements StudentService {

    private List<Student> dataSource = new ArrayList<>();

    public StudentServiceImpl(List<Student> dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public List<Student> getAllStudent() {
        return this.dataSource;
    }

    @Override
    public List<String> getStudentNameListBasedGPA() {
        Comparator<String> nullSafeStringComparator = Comparator
                .nullsLast(String::compareToIgnoreCase);
        /**
         * STEP 1: Sort in descending order based on GPA
         * STEP 2: Sort Name in alphabetica order. If name null place it end with-in the GPA band
         * */
        Comparator<Student> gpaRankingThenName = Comparator.comparing(Student::getGpa, Comparator.reverseOrder()).
                thenComparing(Student::getName, nullSafeStringComparator);

        /* Data source will be sorted*/
        Collections.sort(this.dataSource, gpaRankingThenName);
        return this.dataSource.stream().map(item -> item.getName()).collect(Collectors.toList());
    }
}
