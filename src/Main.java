import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student(5, "Alice", "123 Ave A"));
        students.add(new Student(2, "Bob", "456 St B"));
        students.add(new Student(10, "Charlie", "789 Blvd C"));
        students.add(new Student(7, "David", "987 Rd D"));
        students.add(new Student(1, "Eve", "654 Ln E"));
        students.add(new Student(4, "Frank", "321 Dr F"));
        students.add(new Student(9, "Grace", "246 Pl G"));
        students.add(new Student(8, "Henry", "135 Ct H"));
        students.add(new Student(3, "Ivy", "864 Way I"));
        students.add(new Student(6, "Jack", "579 Park J"));

        System.out.println("Unsorted students:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sort students using merge sort with StudentComparator
        MergeSort.mergeSort(students, new StudentComparator());

        System.out.println("\nSorted students by roll number:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
