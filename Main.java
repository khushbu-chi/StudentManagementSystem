import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
class  studentDetails{
    private int rollNo;
    private String name;
    private double marks;

    // Constructor
    public studentDetails(int rollNo, String name, double marks) {
        this.rollNo = rollNo;
        this.name = name;
        this.marks = marks;
    }
    public int getRollNo() {
        return rollNo;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
    @Override
    public String toString() {
        return "Roll No: " + rollNo + ", Name: " + name + ", Marks: " + marks;
    }

}
class studentManagement{

    private ArrayList<studentDetails> students = new ArrayList<>();

    // Method to add student
    public void addStudent(int rollNo, String name, double marks) {
        students.add(new studentDetails(rollNo, name, marks));
    }
    // Method to display all students
    public void displayStudents() {
        for (studentDetails student : students) {
            System.out.println(student);
        }
    }
    // Method to update a student's details
    public void updateStudent(int rollNo, String newName, double newMarks) {
        for (studentDetails student : students) {
            if (student.getRollNo() == rollNo) {
                student.setName(newName);
                student.setMarks(newMarks);
                return;
            }
        }
        System.out.println("Student not found!");
    }
    // Method to delete a student
    public void deleteStudent(int rollNo) {
        Iterator<studentDetails> it = students.iterator();
        while (it.hasNext()) {
            if (it.next().getRollNo() == rollNo) {
                it.remove();
                return;
            }
        }
        System.out.println("Student not found!");
    }

}
public class Main {
    public static void main(String[] args) {
        studentManagement sms = new studentManagement();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n1. Add Student");
            System.out.println("2. Display Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Roll Number: ");
                    int rollNo = scanner.nextInt();

                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Marks: ");
                    double marks = scanner.nextDouble();

                    sms.addStudent(rollNo, name, marks);
                    break;

                case 2:
                    sms.displayStudents();
                    break;

                case 3:
                    System.out.print("Enter Roll Number to Update: ");
                    rollNo = scanner.nextInt();
                    scanner.nextLine();  // Consume newline

                    System.out.print("Enter New Name: ");
                    name = scanner.nextLine();

                    System.out.print("Enter New Marks: ");
                    marks = scanner.nextDouble();

                    sms.updateStudent(rollNo, name, marks);
                    break;

                case 4:
                    System.out.print("Enter Roll Number to Delete: ");
                    rollNo = scanner.nextInt();
                    sms.deleteStudent(rollNo);
                    break;
                case 5: System.out.println("Exit");
                default:System.out.println("\"Invalid choice! Please try again.");
            }
        } while (choice != 5);
    }
}

