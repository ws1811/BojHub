import java.io.*;

public class Main {
	
	// 정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는 방법의 수를 구하는 프로그램을 작성하시오.
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine()); // test case 개수
		
		for (int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			System.out.println(solution(n));
		}
	}
	
	static int solution(int n)
	{
		int[] dp = new int[n + 1];
		
		if (n == 1)
			return 1;
		if (n == 2)
			return 2;
		if (n == 3)
			return 4;
		
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int i = 4; i <= n; i++)
		{
			dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
		}
		
		return dp[n];
	}
}
