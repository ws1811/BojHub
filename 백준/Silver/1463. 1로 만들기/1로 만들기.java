import java.io.*;
public class Main {
	static int count;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N + 1];
		// dp[i] -> i 를 만들기 위한 최소 연산 횟수
		for (int i = 2; i <= N; i++)
		{
			// 1 을 빼는 경우
			dp[i] = dp[i - 1] + 1;
			
			// 2로 나눠지는 경우
			if (i % 2 == 0) 
			{
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			
			// 3으로 나눠지는 경우
			if (i % 3 == 0) 
			{
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}
		System.out.println(dp[N]);
	}
}