import java.util.Scanner;

public class Program {
	
	private static final String EOF = "42";
	private static final int LIMIT = 18;
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String week = scanner.nextLine();
		
		long grades = 0;
		int weekNum = 1;
		int weekMin;
		
		while (weekNum <= LIMIT && week.equals(EOF) == false) {
			if (week.equals("Week " + weekNum) == false) {
				System.exit(putIllegalArgument());
			}
			weekMin = getMinGrade(scanner);
			grades = getGrades(weekNum, weekMin, grades);
			weekNum++;
			week = scanner.nextLine();
		}
		
		for (int i = 1; i < weekNum; i++) {
			System.out.print("Week " + i + " ");
			putGraph(i, grades);
		}
	}
	
	public static void putGraph(int weekNum, long grades) {
		int printNum;
		
		for (int i = 1; i < weekNum; i++) {
			grades /= 10;
		}
		printNum = (int)(grades % 10);
		
		for (int i = 0; i < printNum; i++) {
			System.out.print("=");
		}
		System.out.println(">");
	}
	
	public static long getGrades(int weekNum, int weekMin, long grades) {
		long ret;
		long power = 1;
		
		for (int i = 1; i < weekNum; i++) {
			power *= 10;
		}
		ret = grades + (weekMin * power);
		
		return (ret);
	}
	
	public static int getMinGrade(Scanner scanner) {
		int min = scanner.nextInt();
		int current;
		
		for (int i = 0; i < 4; i++) {
			current = scanner.nextInt();
			if (current < min) {
				min = current;
			}
		}
		scanner.nextLine();
		return (min);
	}
	
	public static int putIllegalArgument() {
		System.err.println("IllegalArgument");
		return (-1);
	}
}