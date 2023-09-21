package a1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class StudentManagementApp {

    private ArrayList<Student> students = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        while (true) {
            System.out.println("STUDENT MANAGEMENT APPLICATION");
            System.out.println("********************************");
            System.out.println("Enter (1) to launch menu or any other key to exit");
            System.out.print(">> ");

            String input = scanner.nextLine();

            if (input.equals("1")) {
                showMenu();
            } else {
                break;
            }
        }
    }

    private void showMenu() {
        while (true) {
            System.out.println("\nPlease select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application");

            System.out.print(">> ");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    captureStudent();
                    break;
                case "2":
                    searchStudent();
                    break;
                case "3":
                    deleteStudent();
                    break;
                case "4":
                    printStudentReport();
                    break;
                case "5":
                    exitApplication();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    public void captureStudent() {
        System.out.println("\nCAPTURE NEW STUDENT");
        System.out.println("********************");

        System.out.print("Enter the student ID: ");
        int studentID = Integer.parseInt(scanner.nextLine());

        System.out.print("Enter student name: ");
        String studentName = scanner.nextLine();

        int studentAge;
        do {
            System.out.print("Enter the student age: ");
            try {
                studentAge = Integer.parseInt(scanner.nextLine());
                if (studentAge < 16) {
                    throw new NumberFormatException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("You have entered an incorrect student age!!!");
            }
        } while (true);

        System.out.print("Enter the student email: ");
        String studentEmail = scanner.nextLine();

        System.out.print("Enter the student course: ");
        String studentCourse = scanner.nextLine();

        students.add(new Student(studentID, studentName, studentAge, studentEmail, studentCourse));
        System.out.println("Student details have been successfully saved.");
    }

    public List<Student> getStudents() {
        return students;
    }

    public void searchStudent() {
        System.out.print("Enter the student ID to search: ");
        int searchID = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (Student student : students) {
            if (student.getStudentID() == searchID) {
                System.out.println("---------------------------------------");
                System.out.println(student);
                System.out.println("---------------------------------------");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Student ID: " + searchID + " was not found!");
        }
    }

    public void deleteStudent() {
        System.out.print("Enter the student ID to delete: ");
        int deleteID = Integer.parseInt(scanner.nextLine());

        boolean found = false;
        for (Student student : students) {
            if (student.getStudentID() == deleteID) {
                System.out.print("Are you sure you want to delete student " + deleteID + " from the system? (Yes/No): ");
                String confirm = scanner.nextLine().trim().toLowerCase();
                if (confirm.equals("yes") || confirm.equals("y")) {
                    students.remove(student);
                    System.out.println("----------------------------------");
                    System.out.println("Student with Student ID: " + deleteID + " was deleted!");
                    System.out.println("----------------------------------");
                }
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student with Student ID: " + deleteID + " was not found!");
        }
    }

    public void printStudentReport() {
        System.out.println("STUDENT REPORT");
        System.out.println("==============");

        int studentNumber = 1;
        for (Student student : students) {
            System.out.println("STUDENT " + studentNumber);
            System.out.println("-----------------------------------------------");
            System.out.println(student);
            System.out.println("-----------------------------------------------");
            studentNumber++;
        }
    }

    public void exitApplication() {
        System.out.println("Exiting the application.");
        System.exit(0);
    }
}
