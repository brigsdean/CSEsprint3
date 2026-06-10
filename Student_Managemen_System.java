import java.util.ArrayList;
import java.util.Scanner;

// Student Class
class Student {

    private int id;
    private String name;
    private int marks;

    Student(int id, String name, int marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getMarks() {
        return marks;
    }

    void setMarks(int marks) {
        this.marks = marks;
    }

    void setid(int id) {
        this.id = id;
    }

    void setname(String name) {
        this.name = name;
    }

    String getGrade() {

        if (marks >= 90)
            return "A";
        else if (marks >= 75)
            return "B";
        else if (marks >= 60)
            return "C";
        else if (marks >= 40)
            return "D";
        else
            return "Fail";
    }
}

// Main Class
public class Student_Managemen_System {

    static Scanner sc = new Scanner(System.in);
    static ArrayList<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        System.out.println("\n==================================");
        System.out.println("   STUDENT MANAGEMENT SYSTEM");
        System.out.println("==================================");

        do {

            System.out.println("\n-------------- MENU --------------");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Search Student");
            System.out.println("6. Show Total Students");
            System.out.println("7. Show Class Average");
            System.out.println("8. Show Topper");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice : ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("\n Student Data -- Add Process --\n");
                    addStudent();
                    break;

                case 2:
                    System.out.println("\n Student Data -- View Process --\n");
                    viewStudents();
                    break;

                case 3:
                    System.out.println("\n Student Data -- UpDate Process --\n");

                    updateMarks();
                    break;

                case 4:
                    System.out.println("\n Student Data -- Delete Process --\n");

                    deleteStudent();
                    break;

                case 5:
                    System.out.println("\n Student Data -- Search Process --\n");

                    searchStudent();
                    break;

                case 6:
                    System.out.println("\n Student Data -- Show Table Process --\n");

                    System.out.println("\nTotal Students : " + studentList.size());
                    break;

                case 7:
                    System.out.println("\n Student Data -- Show Class Average  Process --\n");

                    showAverage();
                    break;

                case 8:
                    System.out.println("\n Student Data -- Show Topper Process --\n");

                    showTopper();
                    break;

                case 9:
                    System.out.println("\n ********************************************************\n");

                    System.out.println("\n(: Thank you for using the system :)");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 9);

    }

    // Add Student
    static void addStudent() {

        char choice;

        do {

            System.out.print("\nEnter Student ID : ");
            int id = sc.nextInt();
            sc.nextLine();

            for (Student s : studentList) {
                if (s.getId() == id) {
                    System.out.println("Student ID already exists.");
                    return;
                }
            }

            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            System.out.print("Enter Marks : ");
            int marks = sc.nextInt();

            Student s = new Student(id, name, marks);
            studentList.add(s);

            System.out.println("\nStudent added successfully.");

            System.out.print("\nAdd another student? (Y/N): ");
            choice = sc.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');

    }

    // View Students

    static void viewStudents() {

        System.out.println();

        if (studentList.isEmpty()) {

            System.out.println("----------------------------------");
            System.out.println(" No student records available ");
            System.out.println("----------------------------------");
            System.out.println();

            return;
        }

        System.out.println("\n------------------------------------------------");
        System.out.printf("%-10s %-20s %-10s %-10s\n", "ID", "Name", "Marks", "Grade");
        System.out.println("------------------------------------------------");

        for (Student s : studentList) {

            System.out.printf("%-10d %-20s %-10d %-10s\n",
                    s.getId(),
                    s.getName(),
                    s.getMarks(),
                    s.getGrade());
        }

        System.out.println("------------------------------------------------");
        System.out.println();
    }

    // Update Marks
    static void updateMarks() {

        char choice;

        do {

            System.out.print("Enter Student ID : ");
            int id = sc.nextInt();

            for (Student s : studentList) {

                if (s.getId() == id) {

                    System.out.print("Enter New ID : ");
                    int nid = sc.nextInt();
                    s.setid(nid);

                    sc.nextLine(); // clear buffer

                    System.out.print("Enter New Name : ");
                    String nname = sc.nextLine();
                    s.setname(nname);

                    System.out.print("Enter New Marks : ");
                    int marks = sc.nextInt();
                    s.setMarks(marks);

                    System.out.println("\nStudent updated successfully.");

                    System.out.print("\nUpdate another student? (Y/N): ");
                    choice = sc.next().charAt(0);
                    return;
                }
            }

            System.out.println("Student not found.");

            System.out.print("Try again? (Y/N): ");
            choice = sc.next().charAt(0);

        } while (choice == 'Y' || choice == 'y');
    }

    // Delete Student
    static void deleteStudent() {

        System.out.print("Enter Student ID : ");
        int id = sc.nextInt();

        for (Student s : studentList) {

            if (s.getId() == id) {

                System.out.print("Are you sure you want to delete? (Y/N) : ");
                char confirm = sc.next().charAt(0);

                if (confirm == 'Y' || confirm == 'y') {

                    studentList.remove(s);
                    System.out.println("Student deleted successfully.");

                } else {

                    System.out.println("Delete operation cancelled.");
                }

                return;
            }
        }

        System.out.println("Student not found.");

    }

    // Search Student
    static void searchStudent() {

        if (studentList.isEmpty()) {

            System.out.println("\n----------------------------------");
            System.out.println(" No student records available ");
            System.out.println("----------------------------------");
            return;
        }

        System.out.println("\nSearch By:");
        System.out.println("1. ID");
        System.out.println("2. Name");

        System.out.print("Enter choice : ");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {

            System.out.print("Enter Student ID : ");
            int id = sc.nextInt();

            for (Student s : studentList) {

                if (s.getId() == id) {

                    System.out.println("\n----------------------------------");
                    System.out.println(" Student Found ");
                    System.out.println("----------------------------------");
                    System.out.println("ID    : " + s.getId());
                    System.out.println("Name  : " + s.getName());
                    System.out.println("Marks : " + s.getMarks());
                    System.out.println("Grade : " + s.getGrade());
                    System.out.println("----------------------------------");
                    return;
                }
            }

            System.out.println("Student not found.");
        }

        else if (option == 2) {

            System.out.print("Enter Student Name : ");
            String name = sc.nextLine();

            for (Student s : studentList) {

                if (s.getName().equalsIgnoreCase(name)) {

                    System.out.println("\n----------------------------------");
                    System.out.println(" Student Found ");
                    System.out.println("----------------------------------");
                    System.out.println("ID    : " + s.getId());
                    System.out.println("Name  : " + s.getName());
                    System.out.println("Marks : " + s.getMarks());
                    System.out.println("Grade : " + s.getGrade());
                    System.out.println("----------------------------------");
                    return;
                }
            }

            System.out.println("Student not found.");
        }

        else {
            System.out.println("Invalid choice.");
        }
    }

    // Average Marks
    static void showAverage() {

        if (studentList.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        int total = 0;

        for (Student s : studentList) {
            total += s.getMarks();
        }

        double avg = (double) total / studentList.size();

        System.out.println("\nClass Average Marks : " + avg);

    }

    // Topper
    static void showTopper() {

        if (studentList.isEmpty()) {
            System.out.println("No student records available.");
            return;
        }

        Student topper = studentList.get(0);

        for (Student s : studentList) {

            if (s.getMarks() > topper.getMarks()) {
                topper = s;
            }
        }

        System.out.println("\nTopper Student");
        System.out.println("Name  : " + topper.getName());
        System.out.println("Marks : " + topper.getMarks());
        System.out.println("Grade : " + topper.getGrade());

    }

}