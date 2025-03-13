import javax.swing.JOptionPane;
public class Equation {
    public static void main(String[] args) {
        while (true) {
            String choice = JOptionPane.showInputDialog(null, "Choose the type of equation to solve:\n" +
                    "1. First-degree equation with one variable (ax + b = 0)\n" +
                    "2. System of first-degree equations with two variables\n" +
                    "3. Second-degree equation with one variable (ax^2 + bx + c = 0)\n" +
                    "0. Exit", "Choose", JOptionPane.INFORMATION_MESSAGE);
            	
            switch (choice) {
                case "1":
                    PTBN();
                    break;
                case "2":
                    HPT();
                    break;
                case "3":
                    PTBH();
                    break;
                case "0":
                    JOptionPane.showMessageDialog(null, "Exiting.", "Exit", JOptionPane.INFORMATION_MESSAGE);
                    return;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice, please try again!", "Try again", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    public static void PTBN() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter coefficient a:", "Input a", JOptionPane.INFORMATION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter coefficient b:", "Input b", JOptionPane.INFORMATION_MESSAGE));
        
        if (a == 0) {
            if (b == 0) {
                JOptionPane.showMessageDialog(null, "The equation has infinitely many solutions.", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The equation has no solution.", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double x = -b / a;
            JOptionPane.showMessageDialog(null, "The solution of the equation is x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void HPT() {
        double a11 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a11:", "Input a11", JOptionPane.INFORMATION_MESSAGE));
        double a12 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a12:", "Input a12", JOptionPane.INFORMATION_MESSAGE));
        double b1 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b1:", "Input b1", JOptionPane.INFORMATION_MESSAGE));
        double a21 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a21:", "Input a21", JOptionPane.INFORMATION_MESSAGE));
        double a22 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter a22:", "Input a22", JOptionPane.INFORMATION_MESSAGE));
        double b2 = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter b2:", "Input b2", JOptionPane.INFORMATION_MESSAGE));
        
        double D = a11 * a22 - a12 * a21;
        double Dx = b1 * a22 - b2 * a12;
        double Dy = a11 * b2 - a21 * b1;
        
        if (D == 0) {
            if (Dx == 0 && Dy == 0) {
                JOptionPane.showMessageDialog(null, "The system has infinitely many solutions.", "Result", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "The system has no solution.", "Result", JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            double x1 = Dx / D;
            double x2 = Dy / D;
            JOptionPane.showMessageDialog(null, "The solution of the system is: x1 = " + x1 + ", x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    
    public static void PTBH() {
        double a = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter coefficient a:", "Input a", JOptionPane.INFORMATION_MESSAGE));
        double b = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter coefficient b:", "Input b", JOptionPane.INFORMATION_MESSAGE));
        double c = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter coefficient c:", "Input c", JOptionPane.INFORMATION_MESSAGE));
        
        if (a == 0) {
            JOptionPane.showMessageDialog(null, "This is not a quadratic equation. Switching to linear equation...", "Not satisfied", JOptionPane.INFORMATION_MESSAGE);
            PTBN();
            return;
        }
        
        double delta = b * b - 4 * a * c;
        
        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);
            JOptionPane.showMessageDialog(null, "The equation has two distinct solutions: x1 = " + x1 + ", x2 = " + x2, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "The equation has a double root: x = " + x, "Result", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(null, "The equation has no real solution.", "Result", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
