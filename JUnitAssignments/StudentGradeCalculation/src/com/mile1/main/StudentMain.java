package com.mile1.main;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;
import com.mile1.service.StudentReport;

public class StudentMain {

    public static void main(String[] args) {

        StudentReport report = new StudentReport();

        Student student = new Student("John", new int[] {90, 85, 95});

        try {

            report.validate(student);

            String grade = report.findGrade(student);

            System.out.println("Student Name : " + student.getName());
            System.out.println("Grade        : " + grade);

        } catch (NullStudentException e) {

            System.out.println(e.getMessage());

        } catch (NullNameException e) {

            System.out.println(e.getMessage());

        } catch (NullMarksArrayException e) {

            System.out.println(e.getMessage());

        }
    }
}