import javax.swing.JOptionPane;

public class Calculate {
    public static void main(String[] args) {
	String strNum1, strNum2;
        strNum1 = JOptionPane.showInputDialog(null, "Please input the first number: ", "Input the first number", JOptionPane.INFORMATION_MESSAGE);
        strNum2 = JOptionPane.showInputDialog(null, "Please input the second number: ", "Input the second number", JOptionPane.INFORMATION_MESSAGE);


        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);

        String operation = JOptionPane.showInputDialog(null, "Choose operation: +, -, *, /", "Select type of calculate", JOptionPane.INFORMATION_MESSAGE);
        String result;

        switch (operation) {
            case "+":
                result = "Sum: " + (num1 + num2);
                break;
            case "-":
                result = "Difference: " + (num1 - num2);
                break;
            case "*":
                result = "Product: " + (num1 * num2);
                break;
            case "/":
                if (num2 == 0) {
                    result = "Can't be divided by 0";
                } else {
                    result = "Quotient: " + (num1 / num2);
                }
                break;
            default:
                result = "Invalid operation";
        }
	JOptionPane.showMessageDialog(null, result, "Result", JOptionPane.INFORMATION_MESSAGE);

        System.exit(0);
    }
}
