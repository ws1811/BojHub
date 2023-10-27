import java.util.Scanner;

/* 알파벳 대소문자로 된 단어가 주어지면, 
 * 이 단어에서 가장 많이 사용된 알파벳이 무엇인지 알아내는 프로그램을 작성하시오. 
 * 단, 대문자와 소문자를 구분하지 않는다.
 */
public class Main {
	
	static void countAlpha(int[] alpha, char c) {
		// c : 소문자 -> 대문자로 변환
		if ('a' <= c && c <= 'z')
		{
			c = (char)(c - 32);
		}
		
		alpha[c - 65]++;		
	}
	
	static char getMode(int[] alpha) {
		int max = 0;
		int maxIndex = 0;
		for(int i = 0; i < alpha.length; i++) {
			if (max < alpha[i])
			{
				max = alpha[i];
				maxIndex = i;
			}
		}
		// 가장 많이 사용된 알파벳이 여러개 존재하는지 검사
		for(int i = 0; i < alpha.length; i++) {
			if(i != maxIndex && alpha[i] == alpha[maxIndex])
				return '?';
		}
		
		return (char)(maxIndex + 65);
	}
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		// [입력]
		// 첫째 줄에 알파벳 대소문자로 이루어진 단어가 주어진다. 
		// 주어지는 단어의 길이는 1,000,000을 넘지 않는다.
		String word = scan.next();
		char[] wordArray = word.toCharArray();
		int[] alpha = new int[26]; // A, B, ... , Z

		// alpha 배열 초기화
		for(int i = 0; i < 26; i++)
		{
			alpha[i] = 0;
		}
		// [출력]
		// 첫째 줄에 이 단어에서 가장 많이 사용된 알파벳을 대문자로 출력한다. 
		// 단, 가장 많이 사용된 알파벳이 여러 개 존재하는 경우에는 ?를 출력한다.
		for (int i = 0; i < word.length(); i++) {
			countAlpha(alpha, wordArray[i]);
		}
		System.out.println(getMode(alpha));
		
	}
}