package org.example;

import org.example.model.School;
import org.example.model.Student;
import org.example.model.Subject;
import org.example.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class SchoolTest {
    public static void main(String[] args) {
        // Create a School object
        School school = new School();

        // Add four teachers, one for each subject
        school.addTeacher(new Teacher(1, "Math Teacher", 3000.0));
        school.addTeacher(new Teacher(2, "Science Teacher", 2500.0));
        school.addTeacher(new Teacher(3, "English Teacher", 2800.0));
        school.addTeacher(new Teacher(4, "History Teacher", 2700.0));

        // Add students for each subject
        List<Student> mathStudents = new ArrayList<>();
        mathStudents.add(new Student(101, "Miri", 0));
        mathStudents.add(new Student(102, "Ana", 0));

        List<Student> scienceStudents = new ArrayList<>();
        scienceStudents.add(new Student(201, "Mateo", 0));
        scienceStudents.add(new Student(202, "Teuta", 0));

        List<Student> englishStudents = new ArrayList<>();
        englishStudents.add(new Student(301, "Xhoni", 0));
        englishStudents.add(new Student(302, "Franko", 0));

        List<Student> historyStudents = new ArrayList<>();
        historyStudents.add(new Student(401, "Klea", 0));
        historyStudents.add(new Student(402, "Leo", 0));

        // Add subjects with respective teacher and students
        school.addSubject(new Subject(1, "Mathematics", school.getTeachers().get(0), mathStudents));
        school.addSubject(new Subject(2, "Science", school.getTeachers().get(1), scienceStudents));
        school.addSubject(new Subject(3, "English", school.getTeachers().get(2), englishStudents));
        school.addSubject(new Subject(4, "History", school.getTeachers().get(3), historyStudents));

        // Allow students to pay tuition fees
        for (Subject subject : school.getSubjects()) {
            for (Student student : subject.getStudentList()) {
                student.payFees(3000); // Example: Student pays $2000 towards tuition fees
            }
        }

        // Calculate total earning of the school from tuition fees
        double totalEarning = school.getTotalEarning();
        System.out.println("\nTotal earning of the school from tuition fees: $" + totalEarning
                + "\n------------------------------------------------------------------");

        // Calculate total spending of the school from teachers' salaries
        double totalSpending = school.getTotalSpending();
        System.out.println("Total spending of the school from teachers' salaries: $" + totalSpending
                + "\n------------------------------------------------------------------");

        // Calculate net earnings/losses
        double netEarnings = school.getNetEarnings();
        System.out.println("Net earnings/losses: $" + netEarnings
                + "\n------------------------------------------------------------------");

        // Output the list of students and their paid fees ordered alphabetically into a text file
        school.saveStudentsToFile("student.txt");
    }

}