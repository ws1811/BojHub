import java.io.*;
public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		int[] dp = new int[N];
		int max = 0; // LIS 길이
		
		for (int i = 0; i < N; i++) seq[i] = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++)
		{
			dp[i] = 1;
			for (int j = 0; j < i; j++)
			{
				if (seq[j] < seq[i] && dp[j] + 1 > dp[i]) // 오름차순 일 경우
					dp[i] =  dp[j] + 1;
				if (max < dp[i]) max = dp[i];
			}
		}
		System.out.println(N - max);
	}
	
}
// 3 7 5 2 6 1 4
// 1 2 2 1 3 1 1
