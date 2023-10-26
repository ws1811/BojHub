import java.util.Scanner;

public class Main {

	// 두 정수 a, b 의 최대공약수를 리턴하는 메소드(유클리드 호제법)
	static long gcd(long a, long b)
	{
		long max = a < b ? b : a; //작은값
		long min = a < b ? a : b; //큰값
		
		long r = max % min;
		if (r == 0)
		{
			return min;
		}		
		return gcd(min, r);
	}
	
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		// [입력]
		long a = scan.nextInt();
		long b = scan.nextInt();
		// [출력]
		//A와 B의 최소공배수를 한 줄에 출력한다.
		// 최소공배수 = (두 수의 곱) / 최대공약수
		long lcm = (a *b) / gcd(a, b);
		System.out.println(lcm);
	}
}