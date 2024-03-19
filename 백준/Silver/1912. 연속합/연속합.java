import java.io.*;
import java.util.*;
public class Main {
	static int[] seq;
	static int[] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		seq = new int[n];
		dp = new int[n];
		
		for (int i = 0; i < n; i++)
		{
			seq[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = seq[0];
		int max = dp[0];
		for (int i = 1; i < n; i++)
		{
			dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);
			if (dp[i] > max)
				max = dp[i];
		}
		System.out.println(max);
		
	}

}
