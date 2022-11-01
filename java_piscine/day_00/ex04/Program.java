import java.util.Scanner;

public class Program {
	
	private static final int MAX_MOST_USED_CHARS = 10;
	private static final int MAX_CHAR_CODE = 65535;
	private static final int MAX_HEIGHT = 10;
	
	public static int[] countChars(String text) {
		
		int[] charsCount = new int[MAX_CHAR_CODE]; 
		char[] textAsArray = text.toCharArray();
		
		for (int i = 0; i < text.length(); i++) {
			charsCount[textAsArray[i]]++;
		}
		
		return (charsCount);
	}
	
	public static char[] findMostUsedChars(int[] charsCount) {
		
		char[] ret = new char[MAX_MOST_USED_CHARS];
		int charCounted;
		
		for (int i = 0; i < MAX_CHAR_CODE; i++) {
			charCounted = charsCount[i];
			if (charCounted > 0) {
				for (int j = 0; j < MAX_MOST_USED_CHARS; j++) {
					if (charsCount[ret[j]] < charCounted) {
						ret = insertChar(ret, (char) i, j);
						break ;
					}
				}
			}
		}
		return (ret);
	}
	
	public static char[] insertChar(char[] mostUsedChars, char c, int index) {
		
		char[] ret = new char[MAX_MOST_USED_CHARS];
		
		for (int i = 0; i < index; i++) {
			ret[i] = mostUsedChars[i];
		}
		ret[index] = c;
		
		for (int i = index + 1; i < MAX_MOST_USED_CHARS; i++) {
			ret[i] = mostUsedChars[i - 1];
		}
		
		return (ret);
	}
	
	public static void printGraph(char[] mostUsed, int[] charsCount) {
		
		int graph[] = new int[MAX_MOST_USED_CHARS];
		int max = charsCount[mostUsed[0]];
		int maxHeight = max;
		int linesCount;
		
		if (max > MAX_HEIGHT) {
			maxHeight = MAX_HEIGHT;
		}
		linesCount = maxHeight + 2;
		
		for (int i = 0; i < MAX_MOST_USED_CHARS; i++) {
			if (max <= MAX_HEIGHT) {
				graph[i] = charsCount[mostUsed[i]];
			} else {
				graph[i] = (charsCount[mostUsed[i]] * MAX_HEIGHT / max);
			}
		}
		System.out.println();
		
		for (int i = 0; i < linesCount; i++) {
			for (int j = 0; j < MAX_MOST_USED_CHARS; j++) {
				if (mostUsed[j] != 0) {
					if (i + graph[j] + 2 == linesCount) {
						System.out.printf("%3d", charsCount[mostUsed[j]]);
					} else if (i == linesCount - 1) {
						System.out.printf("%3c", mostUsed[j]);
					} else if (i + graph[j] >= maxHeight) {
						System.out.printf("%3c", '#');
					}
					if (j != MAX_MOST_USED_CHARS - 1 && mostUsed[j + 1] != 0 && i + graph[j + 1] >= maxHeight) {
						System.out.printf("%c", ' ');
					}
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text = scanner.nextLine();
		
		int[] charsCount = countChars(text);
		char[] mostUsedChars = findMostUsedChars(charsCount);
		
		printGraph(mostUsedChars, charsCount);
		scanner.close();
	}
}