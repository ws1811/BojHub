import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] stair = new int[n + 1];
		
		for (int i = 1; i < n + 1; i++)
		{
			stair[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[n + 1];
		if(n == 1) 
		{
			dp[1] = stair[1];
		}
		else if(n == 2) 
		{
			dp[2] = stair[2] + stair[1];
		}
		else 
		{
			dp[1] = stair[1];
			dp[2] = stair[2] + stair[1];
			dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);
			
			for(int i=4; i<n+1; i++) 
			{
				dp[i] = Math.max(dp[i - 3] + stair[i] + stair[i - 1], dp[i - 2] + stair[i]);
			}
		}
		System.out.println(dp[n]);
	}

}
