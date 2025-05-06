// StudentManagementSystem.java
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class StudentManagementSystem {

    private List<Student> students;
    private Scanner scanner;

    public StudentManagementSystem() {
        students = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // Method to add a student
    public void addStudent() {
        System.out.print("Enter student name: ");
        String name = scanner.nextLine();

        System.out.print("Enter roll number: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline left by nextInt()

        System.out.print("Enter grade: ");
        String grade = scanner.nextLine();

        Student student = new Student(name, rollNumber, grade);
        students.add(student);
        System.out.println("Student added successfully!");
    }

    // Method to remove a student by roll number
    public void removeStudent() {
        System.out.print("Enter roll number of student to remove: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        Student studentToRemove = null;
        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                studentToRemove = student;
                break;
            }
        }

        if (studentToRemove != null) {
            students.remove(studentToRemove);
            System.out.println("Student removed successfully!");
        } else {
            System.out.println("Student not found!");
        }
    }

    // Method to search for a student by roll number
    public void searchStudent() {
        System.out.print("Enter roll number of student to search: ");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        for (Student student : students) {
            if (student.getRollNumber() == rollNumber) {
                System.out.println(student);
                return;
            }
        }

        System.out.println("Student not found!");
    }

    // Method to display all students
    public void displayAllStudents() {
        if (students.isEmpty()) {
            System.out.println("No students available.");
        } else {
            for (Student student : students) {
                System.out.println(student);
            }
        }
    }

    // Method to save students to a file
    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("students.txt"))) {
            for (Student student : students) {
                writer.write(student.getName() + "," + student.getRollNumber() + "," + student.getGrade());
                writer.newLine();
            }
            System.out.println("Students saved to file successfully.");
        } catch (IOException e) {
            System.out.println("Error saving to file: " + e.getMessage());
        }
    }

    // Method to load students from a file
    public void loadFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("students.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] studentData = line.split(",");
                String name = studentData[0];
                int rollNumber = Integer.parseInt(studentData[1]);
                String grade = studentData[2];
                students.add(new Student(name, rollNumber, grade));
            }
            System.out.println("Students loaded from file successfully.");
        } catch (IOException e) {
            System.out.println("Error loading from file: " + e.getMessage());
        }
    }

    // User interface to interact with the system
    public void showMenu() {
        while (true) {
            System.out.println("\n=== Student Management System ===");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Search Student");
            System.out.println("4. Display All Students");
            System.out.println("5. Save Students to File");
            System.out.println("6. Load Students from File");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    saveToFile();
                    break;
                case 6:
                    loadFromFile();
                    break;
                case 7:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        StudentManagementSystem system = new StudentManagementSystem();
        system.showMenu();
    }
}
