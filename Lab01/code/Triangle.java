import java.util.Scanner;
public class Triangle {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter n: ");
		int n = sc.nextInt();
		for(int i = 1 ; i <=n ; i++ ) {
			for (int j = 1 ; j<= n-i; j++  ) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= 2*i -1 ;j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		sc.close();
		System.exit(0);
	}
}