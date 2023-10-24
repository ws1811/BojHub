import java.util.Scanner;

public class Main {

	// 두 정수 a, b 의 최대공약수를 리턴하는 메소드
	static int gcd(int a, int b)
	{
		int cm = 1; // 공배수
		int lcm = 1; // 리턴할 최소공배수
		
		if(a >= b)
		{	// 편의상 b 가 더 큰 상태로 만들어 계산하겠다
			int tmp = a;
			a = b;
			b = tmp;
		}
		
		while (cm <= a)
		{
			if (a % cm == 0 && b % cm == 0)
			{
				lcm = cm;
			}
			cm++;
		}
		
		return lcm;
	}
	
	
	//두 자연수 A와 B가 주어졌을 때, A와 B의 최소공배수를 구하는 프로그램을 작성하시오.
	public static void main(String[] args)  {
		Scanner scan = new Scanner(System.in);
		// [입력]
		// 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다. 
		// 둘째 줄부터 T개의 줄에 걸쳐서 A와 B가 주어진다. (1 ≤ A, B ≤ 45,000)
		int t = scan.nextInt();
		int a, b;
		// [출력]
		// 첫째 줄부터 T개의 줄에 A와 B의 최소공배수를 입력받은 순서대로 한 줄에 하나씩 출력한다.
		for(int i = 0; i < t; i++)
		{
			a = scan.nextInt();
			b = scan.nextInt();
            // 최소공배수 = (a * b) / 최대공약수
			System.out.println(a * b / gcd(a,b));
		}
		
	}
}
