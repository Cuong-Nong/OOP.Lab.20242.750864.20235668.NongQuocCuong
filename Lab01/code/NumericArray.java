import java.util.Arrays;
import java.util.Scanner;
public class NumericArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        System.out.print("Enter " + n + " numbers: ");
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        for (int num : numbers) {
            sum += num;
        }
        
        double average = (double) sum / n;

        System.out.println("Sorted array: " + Arrays.toString(numbers));
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);
        sc.close();
    }
}