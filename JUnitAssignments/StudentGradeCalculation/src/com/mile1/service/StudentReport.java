package com.mile1.service;

import com.mile1.bean.Student;
import com.mile1.exception.NullMarksArrayException;
import com.mile1.exception.NullNameException;
import com.mile1.exception.NullStudentException;

public class StudentReport {

    // Validates the student object
    public String validate(Student student)
            throws NullStudentException, NullNameException, NullMarksArrayException {

        if (student == null) {
            throw new NullStudentException();
        }

        if (student.getName() == null) {
            throw new NullNameException();
        }

        if (student.getMarks() == null) {
            throw new NullMarksArrayException();
        }

        return "VALID";
    }

    // Calculates the grade
    public String findGrade(Student student) {

        int[] marks = student.getMarks();
        int total = 0;

        for (int mark : marks) {
            total += mark;
        }

        int average = total / marks.length;

        if (average >= 80) {
            return "A";
        } else if (average >= 60) {
            return "B";
        } else if (average >= 50) {
            return "C";
        } else if (average >= 35) {
            return "D";
        } else {
            return "F";
        }
    }

    // Counts students with null names
    public int findNumberOfNullName(Student[] students) {

        int count = 0;

        for (Student student : students) {
            if (student != null && student.getName() == null) {
                count++;
            }
        }

        return count;
    }

    // Counts null student objects
    public int findNumberOfNullObjects(Student[] students) {

        int count = 0;

        for (Student student : students) {
            if (student == null) {
                count++;
            }
        }

        return count;
    }

    // Counts students with null marks
    public int findNumberOfNullMarks(Student[] students) {

        int count = 0;

        for (Student student : students) {
            if (student != null && student.getMarks() == null) {
                count++;
            }
        }

        return count;
    }
}