import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int M = scan.nextInt();
		int N = scan.nextInt();
		
		for (int i = M; i <=N; i++)
		{
			if(isPrime(i) == true)
				System.out.println(i);
		}
	}
	
	// 2부터 루트(num) 까지로 나눠본다 
	// 하나라도 나머지 0이면 소수 아님
	// 나머지가 모두 0이면 소수
	static boolean isPrime(int num)
	{
		int divisor = 2; // 나누는 수
        if (num < 2)
			return false;
		while (divisor * divisor <= num)
		{
			if(num % divisor == 0)
				return false;
			divisor++;
		}
		return true;
	}
}
