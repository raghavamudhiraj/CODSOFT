import java.util.Scanner;

public class StudentGradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("🎓 Student Marks & Grade Calculator");

        System.out.print("Enter the number of subjects: ");
        int subjectCount = scanner.nextInt();

        // Array to store marks
        int[] marks = new int[subjectCount];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < subjectCount; i++) {
            while (true) {
                System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
                int mark = scanner.nextInt();
                if (mark >= 0 && mark <= 100) {
                    marks[i] = mark;
                    totalMarks += mark;
                    break;
                } else {
                    System.out.println("Invalid input! Please enter marks between 0 and 100.");
                }
            }
        }

        // Calculate average percentage
        double averagePercentage = (double) totalMarks / subjectCount;

        // Determine grade
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F (Fail)";
        }

        // Display results
        System.out.println("\n📊 Result Summary:");
        System.out.println("Total Marks      : " + totalMarks + " / " + (subjectCount * 100));
        System.out.printf("Average Percentage: %.2f%%\n", averagePercentage);
        System.out.println("Grade            : " + grade);

        scanner.close();
    }
}
