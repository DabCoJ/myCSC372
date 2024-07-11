import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MergeSort {
    public static void mergeSort(ArrayList<Student> students, Comparator<Student> comparator) {
        if (students.size() <= 1) {
            return;
        }

        int mid = students.size() / 2;
        ArrayList<Student> left = new ArrayList<>(students.subList(0, mid));
        ArrayList<Student> right = new ArrayList<>(students.subList(mid, students.size()));

        mergeSort(left, comparator);
        mergeSort(right, comparator);

        merge(students, left, right, comparator);
    }

    private static void merge(ArrayList<Student> students, ArrayList<Student> left, ArrayList<Student> right, Comparator<Student> comparator) {
        int leftIndex = 0;
        int rightIndex = 0;
        int resultIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comparator.compare(left.get(leftIndex), right.get(rightIndex)) <= 0) {
                students.set(resultIndex++, left.get(leftIndex++));
            } else {
                students.set(resultIndex++, right.get(rightIndex++));
            }
        }

        while (leftIndex < left.size()) {
            students.set(resultIndex++, left.get(leftIndex++));
        }

        while (rightIndex < right.size()) {
            students.set(resultIndex++, right.get(rightIndex++));
        }
    }
}
