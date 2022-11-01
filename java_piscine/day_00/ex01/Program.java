import java.util.Scanner;

public class Program {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int	num = scanner.nextInt();
		int count = 1;
		
		if (num <= 1) {
			System.err.println("IllegalArgument");
			System.exit(-1);
		}
		
		if (num == 2 || num == 3) {
			System.out.println("True " + count);
			System.exit(0);
		}
		
		if (num % 2 == 0 || num % 3 == 0) {
			System.out.println("False " + count);
			System.exit(0);
		}
		
		for (int i = 5; i * i <= num; i += 6) {
			if (num % i == 0 || num % (i + 2) == 0) {
				System.out.println("False " + count);
				System.exit(0);
			}
			count++;
		}
		
		System.out.println("True " + count);
		System.exit(0);
	}
}