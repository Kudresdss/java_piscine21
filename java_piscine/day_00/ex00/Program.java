public class Program {
	
	public static void main(String[] args) {
		int number = 463611;
		int result = 0;
		
		if (number < 0)
			number *= -1;
		
		result += number % 10;
		number /= 10;
		result += number % 10;
		number /= 10;
		result += number % 10;
		number /= 10;
		result += number % 10;
		number /= 10;
		result += number % 10;
		number /= 10;
		result += number % 10;
		number /= 10;
		
		System.out.println(result);
	}
}