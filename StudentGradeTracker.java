import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    private ArrayList<student> students;

    public StudentGradeTracker() {
        students = new ArrayList<>();
    }

    public void addStudent(String name, double grade) {
        students.add(new student(name, grade));
    }

    public double computeAverage() {
        double total = 0;
        for (student student : students) {
            total += student.getGrade();
        }
        return total / students.size();
    }

    public double findHighest() {
        double highest = Double.MIN_VALUE;
        for (student student : students) {
            if (student.getGrade() > highest) {
                highest = student.getGrade();
            }
        }
        return highest;
    }

    public double findLowest() {
        double lowest = Double.MAX_VALUE;
        for (student student : students) {
            if (student.getGrade() < lowest) {
                lowest = student.getGrade();
            }
        }
        return lowest;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGradeTracker tracker = new StudentGradeTracker();

        System.out.println("Enter student grades. Type 'done' to finish.");
        while (true) {
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            if (name.equalsIgnoreCase("done")) {
                break;
            }
            System.out.print("Enter student grade: ");
            double grade = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            tracker.addStudent(name, grade);
        }

        System.out.println("Average grade: " + tracker.computeAverage());
        System.out.println("Highest grade: " + tracker.findHighest());
        System.out.println("Lowest grade: " + tracker.findLowest());
    }
}
