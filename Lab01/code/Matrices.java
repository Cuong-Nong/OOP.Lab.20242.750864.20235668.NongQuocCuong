import java.util.Scanner;
public class Matrices {
    private static void printMatrix(int[][] matrix, int rows, int cols) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of rows: ");
        int row = sc.nextInt();
        System.out.print("Enter the number of columns: ");
        int col = sc.nextInt();

        int[][] matrix1 = new int[row][col];
        int[][] matrix2 = new int[row][col];
        int[][] sumMatrices = new int[row][col];

        System.out.print("Enter first matrix (in order row before column after): ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix1[i][j] = sc.nextInt();
            }
        }

        System.out.print("Enter second matrix (in order row before column after): ");
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix2[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                sumMatrices[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        System.out.println("\nFirst Matrix:");
        printMatrix(matrix1, row, col);

        System.out.println("\nSecond Matrix:");
        printMatrix(matrix2, row, col);

        System.out.println("\nSum of Matrices:");
        printMatrix(sumMatrices, row, col);

        sc.close();
    }

}