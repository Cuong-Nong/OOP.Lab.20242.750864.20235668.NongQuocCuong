import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
	String strNum1, strNum2;

        System.out.println("Enter first number: ");
        strNum1 = sc.nextLine();
        System.out.println("Enter second number: ");
        strNum2 = sc.nextLine();

        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        double sum = num1 + num2;
        double difference = num1 - num2;
        double product = num1 * num2;
        double quotient = num1 / num2;

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
        
        if (num2 == 0) {
		System.out.println("Can't be devided by 0");
        } else {
            	System.out.println("Quotient: " + quotient);
        }

        System.exit(0);
    }
}
