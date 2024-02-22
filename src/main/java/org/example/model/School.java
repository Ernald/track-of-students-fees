package org.example.model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class School {

    private List<Student> students;
    private List<Teacher> teachers;
    private List<Subject> subjects;
    private double totalMoneyEarned;
    private double totalMoneySpent;

    public School() {
        this.students = new ArrayList<>();
        this.subjects = new ArrayList<>();
        this.teachers = new ArrayList<>();
        this.totalMoneyEarned = 0;
        this.totalMoneySpent = 0;
    }

    //create a method addTeacher that adds a Teacher in the list
    public void addTeacher(Teacher teacher){
        teachers.add(teacher);
    }

    //create a method addStudent that adds a Student in the list
    public void addStudent(Student student){
        students.add(student);
    }

    // Method to add a subject to the school
    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public double getTotalMoneyEarned() {
        return totalMoneyEarned;
    }

    public void setTotalMoneyEarned(double totalMoneyEarned) {
        this.totalMoneyEarned = totalMoneyEarned;
    }

    public double getTotalMoneySpent() {
        return totalMoneySpent;
    }

    public void setTotalMoneySpent(double totalMoneySpent) {
        this.totalMoneySpent = totalMoneySpent;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    // Method to find total earning of the school from tuition fees
    public double getTotalEarning() {
        double totalEarning = 0;
        for (Subject subject : subjects) {
            for (Student student : subject.getStudentList()) {
                totalEarning += student.getFeesPaid();
            }
        }
        return totalEarning;
    }

    // Method to find total spending of the school from teachers' salary
    public double getTotalSpending() {
        double totalSpending = 0;
        for (Teacher teacher : teachers) {
            totalSpending += teacher.getSalary();
        }
        return totalSpending;
    }

    // Method to find net earnings/losses
    public double getNetEarnings() {
        return getTotalEarning() - getTotalSpending();
    }

    // Method to output the list of students and their paid fees ordered alphabetically into a text file
    public void saveStudentsToFile(String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            for (Subject subject : subjects) {
                List<Student> sortedStudents = new ArrayList<>(subject.getStudentList());
                Collections.sort(sortedStudents, Comparator.comparing(Student::getName)); // Sort students alphabetically by name

                for (Student student : sortedStudents) {
                    writer.write(student.toString() + "\n");
                }
            }
            System.out.println("Student information has been saved to " + fileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "School{" +
                "students=" + students +
                ", teachers=" + teachers +
                ", subjects=" + subjects +
                ", totalMoneyEarned=" + totalMoneyEarned +
                ", totalMoneySpent=" + totalMoneySpent +
                '}';
    }
}
