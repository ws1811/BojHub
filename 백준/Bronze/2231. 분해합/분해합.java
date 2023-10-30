import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	// 자연수 N 의 분해합 = N + (N 을 이루는 각 자릿수의 합)
	// "N의 생성자가 M이다 " <=> "어떤 자연수 M의 분해합이 N이다"
	// [Ex]
	// 245의 분해합 = 245 + 2 + 4 + 5 = 256  --> 245는 256의 생성자
	// 물론, 어떤 자연수의 경우에는 생성자가 없을 수도 있다
	// 반대로, 생성자가 여러 개인 자연수도 있을 수 있다.
	
	/* 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오. */
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		// [입력] 
		// 첫째 줄에 자연수 N(1 ≤ N ≤ 1,000,000)이 주어진다.
		int n = scan.nextInt();
		// [출력]
		// 첫째 줄에 답을 출력한다. 생성자가 없는 경우에는 0을 출력한다.
		// n 의 생성자가 m이다 <-> m 의 분해합이 n이다
		int result = 0;
		for (int i = 0; i < n; i++) {

			int num = bunhaehab(i); // 분해합 구함....

			if (num == n) { // 분해합이 N과 같으면
				result = i;
				break;
			}
		}
		System.out.println(result);
	}
	
	// 어떤 자연수 n의 분해합을 리턴하는 메소드
	static int bunhaehab(int n) {
		int result = n; // 리턴할 분해합
		// 각 자릿수 더하기
		// 247 -> +2, +4, +7
		int len = Integer.toString(n).length(); // n 의 길이 = 3
		for(int i = 0; i < len; i++) {
			int digit = Integer.toString(n).charAt(i) - '0';
			result += (digit);
		}
		return result;
	}
}
