import java.util.Scanner;

public class Program {
	
	private static final int EOF = 42;
	
	public static int doSumm(int num) {
		int summ = 0;
		
		for (; num > 0; num /= 10) {
			summ += num % 10;
		}
		
		return (summ);
	}
	
	public static boolean isPrimal(int summ) {
		
		if (summ <= 1) {
			System.err.println("IllegalArgument");
			return (false);
		}
		
		if (summ == 2 || summ == 3) {
			return (true);
		}
		
		if (summ % 2 == 0 || summ % 3 == 0) {
			return (false);
		}
		
		for (int i = 5; i * i <= summ; i += 6) {
			if (summ % i == 0 || summ % (i + 2) == 0) {
				return (false);
			}
		}
		
		return (true);
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int num = scanner.nextInt();
		int count = 0;
		int summ;
		
		if (num <= 1) {
			System.err.println("IllegalArgument");
			System.exit(-1);
		}
		
		while (num != EOF) {
			summ = doSumm(num);
			if (isPrimal(summ) == true) {
				count++;
			}
			num = scanner.nextInt();
		}
		
		System.out.println("Count of coffee-request - " + count);
		System.exit(0);
	}
}