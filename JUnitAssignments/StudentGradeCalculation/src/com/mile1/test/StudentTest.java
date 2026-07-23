package com.mile1.test;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;
import com.mile1.service.StudentReport;

public class StudentTest {

    public static void main(String[] args) {

        StudentReport report = new StudentReport();

        // ---------------- TC1 ----------------
        Student s1 = new Student("John", new int[] {90, 85, 95});

        try {
            report.validate(s1);
            System.out.println("TC1 Grade: " + report.findGrade(s1));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------- TC2 ----------------
        Student s2 = new Student("Peter", new int[] {40, 35, 38});

        try {
            report.validate(s2);
            System.out.println("TC2 Grade: " + report.findGrade(s2));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------- TC3 ----------------
        Student s3 = new Student("Sam", new int[] {20, 25, 30});

        try {
            report.validate(s3);
            System.out.println("TC3 Grade: " + report.findGrade(s3));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------- TC4 ----------------
        Student s4 = null;

        try {
            report.validate(s4);
        } catch (NullStudentException e) {
            System.out.println("TC4: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------- TC5 ----------------
        Student s5 = new Student(null, new int[] {80, 90, 85});

        try {
            report.validate(s5);
        } catch (NullNameException e) {
            System.out.println("TC5: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------- TC6 ----------------
        Student s6 = new Student("David", null);

        try {
            report.validate(s6);
        } catch (NullMarksArrayException e) {
            System.out.println("TC6: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // ---------------- TC7 TC8 TC9 ----------------

        Student[] students = {
                s1,
                s2,
                s3,
                s4,
                s5,
                s6
        };

        System.out.println("TC7 Null Names : "
                + report.findNumberOfNullName(students));

        System.out.println("TC8 Null Objects : "
                + report.findNumberOfNullObjects(students));

        System.out.println("TC9 Null Marks : "
                + report.findNumberOfNullMarks(students));
    }
}