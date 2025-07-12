package source;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        while (true) {
            System.out.println("\n--- Student Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter name: ");
                        sc.nextLine();
                        String name = sc.nextLine();
                        System.out.print("Enter age: ");
                        int age = sc.nextInt();
                        System.out.print("Enter grade: ");
                        sc.nextLine();
                        String grade = sc.nextLine();
                        dao.addStudent(new Student(0, name, age, grade));
                        System.out.println("Student added successfully.");
                        break;

                    case 2:
                        List<Student> students = dao.getAllStudents();
                        System.out.println("ID\tName\tAge\tGrade");
                        for (Student s : students) {
                            System.out.println(s.getId() + "\t" + s.getName() + "\t" + s.getAge() + "\t" + s.getGrade());
                        }
                        break;

                    case 3:
                        System.out.print("Enter student ID to update: ");
                        int idToUpdate = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New name: ");
                        String newName = sc.nextLine();
                        System.out.print("New age: ");
                        int newAge = sc.nextInt();
                        sc.nextLine();
                        System.out.print("New grade: ");
                        String newGrade = sc.nextLine();
                        dao.updateStudent(new Student(idToUpdate, newName, newAge, newGrade));
                        System.out.println("Student updated.");
                        break;

                    case 4:
                        System.out.print("Enter student ID to delete: ");
                        int idToDelete = sc.nextInt();
                        dao.deleteStudent(idToDelete);
                        System.out.println("Student deleted.");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        System.exit(0);

                    default:
                        System.out.println("Invalid option.");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

