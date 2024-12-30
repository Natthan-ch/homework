import java.io.*;
import java.util.*;

public class CSVSorter {
    public static void main(String[] args) {
     
        if (args.length < 2) {
            System.out.println("Usage: java CSVSorter -[n|f|l|s] [file path] [search name (optional)]");
            return;
        }

     
        Vector<Student> students = new Vector<>();

    
        try (Scanner fileScanner = new Scanner(new FileInputStream(args[1]))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();

                if (line.contains("2115")) {
                    String[] fields = line.split(",");
                    if (fields.length >= 4) {
                        students.add(new Student(fields[1].trim(), fields[2].trim(), fields[3].trim()));
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
            return;
        }

   
        String command = args[0];
        switch (command) {
            case "-n":
                System.out.println("Sorting by Student ID:");
                selectionSort(students, "id");
                break;
            case "-f":
                System.out.println("Sorting by First Name:");
                selectionSort(students, "firstName");
                break;
            case "-l":
                System.out.println("Sorting by Last Name:");
                selectionSort(students, "lastName");
                break;
            case "-s":
                if (args.length < 3) {
                    System.out.println("Please provide a name to search for.");
                    return;
                }
                String searchName = args[2];
                searchByFirstName(students, searchName);
                return;
            default:
                System.out.println("Invalid command. Use -n, -f, -l, or -s.");
                return;
        }

 
        students.forEach(System.out::println);
    }

    private static void selectionSort(Vector<Student> students, String sortBy) {
        int n = students.size();
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (compareStudents(students.get(j), students.get(minIndex), sortBy) < 0) {
                    minIndex = j;
                }
            }
 
            Student temp = students.get(minIndex);
            students.set(minIndex, students.get(i));
            students.set(i, temp);
        }
    }


    private static int compareStudents(Student s1, Student s2, String sortBy) {
        switch (sortBy) {
            case "id":
                return s1.getStudentID().compareTo(s2.getStudentID());
            case "firstName":
                return s1.getFirstName().compareTo(s2.getFirstName());
            case "lastName":
                return s1.getLastName().compareTo(s2.getLastName());
            default:
                return 0;
        }
    }


    private static void searchByFirstName(Vector<Student> students, String searchName) {
        boolean found = false;
        for (Student student : students) {
            if (searchName.equalsIgnoreCase(student.getFirstName().trim())) {
                System.out.println("Found: " + student);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No student found with the first name: " + searchName);
        }
    }
}


class Student {
    private String studentID;
    private String firstName;
    private String lastName;

    public Student(String studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return studentID + " " + firstName + " " + lastName;
    }
}
