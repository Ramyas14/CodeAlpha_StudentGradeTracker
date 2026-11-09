package com.codealpha.studentgradetracker;
import java.util.Scanner;
public class StudentGradeTracker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        while (true) {
            System.out.print("Enter number of students: ");
            String input = sc.nextLine().trim();
            try {
                n = Integer.parseInt(input);
                if (n <= 0) {
                    System.out.println("Invalid! Student count must be at least 1.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid! Please enter a valid number.");
            }
        }
        String[] names = new String[n];
        int[] marks = new int[n];
        int total = 0;
        int highest = Integer.MIN_VALUE;
        int lowest = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            while (true) {
                System.out.print("Enter name of student " + (i + 1) + ": ");
                names[i] = sc.nextLine().trim();
                if (names[i].isEmpty()) {
                    System.out.println("Name cannot be empty!");
                } else {
                    break;
                }
            }
            int mark;
            while (true) {
                System.out.print("Enter marks for " + names[i] + " (0-100): ");
                try {
                    mark = Integer.parseInt(sc.nextLine().trim());
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid! Marks must be between 0 and 100.");
                        continue;
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid! Please enter a valid number.");
                }
            }
            marks[i] = mark;
            total = total + marks[i];
            if (marks[i] > highest) {
                highest = marks[i];
            }
            if (marks[i] < lowest) {
                lowest = marks[i];
            }
        }
        double average = (double) total / n;
        System.out.println("\n--- Student Grade Report ---");
        for (int i = 0; i < n; i++) {
            String grade;
            if (marks[i] >= 90) {
                grade = "A";
            } else if (marks[i] >= 75) {
                grade = "B";
            } else if (marks[i] >= 50) {
                grade = "C";
            } else {
                grade = "F";
            }
            System.out.println(names[i] + " : " + marks[i] + " - Grade " + grade);
        }
        System.out.println("\n--- Summary ---");
        System.out.println("Average Marks: " + average);
        System.out.println("Highest Marks: " + highest);
        System.out.println("Lowest Marks: " + lowest);
        sc.close();
    }
}
