import java.io.*;
public class Main{
	static int[][] dp = new int[15][15];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < t; i++)
		{
			int k = Integer.parseInt(br.readLine()); // k층
			int n = Integer.parseInt(br.readLine()); // n호
			
			solution(k, n);
		}
	}
	
	static void solution(int k, int n)
	{
		for (int i = 0; i <= 14; i++) // 0층 값 초기화
		{
			dp[0][i] = i;
		}
		
		for (int i = 1; i <= k; i++)
		{
			for (int j = 1; j <= 14; j++)
			{
				dp[i][j] = sum(i - 1, j);
			}
		}
		
		System.out.println(dp[k][n]);
	}

	static int sum(int floor, int roomNum)
	{
		int sum = 0;
		for (int i = 1; i <= roomNum; i++)
		{
			sum += dp[floor][i];
		}
		return sum;
	}
}
