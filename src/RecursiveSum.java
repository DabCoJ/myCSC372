import java.util.Scanner;

public class RecursiveSum {

    // Recursive method to calculate sum of numbers in an array
    public static int calculateSum(int[] numbers, int index) {
        // Base case: if index is 0, return the number at index 0
        if (index <= 0) {
            return numbers[0];
        } else {
            // Recursive case: add current number to sum of rest of the array
            return numbers[index] + calculateSum(numbers, index - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5]; // Array to store the five numbers
        int sum;

        // Prompt user to enter five numbers
        System.out.println("Enter five numbers:");

        // Read five numbers from user input
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        // Calculate sum using the recursive method
        sum = calculateSum(numbers, 4); // Start from index 4 (last element)

        // Display the sum
        System.out.println("Sum of the five numbers is: " + sum);

        scanner.close();
    }
}
