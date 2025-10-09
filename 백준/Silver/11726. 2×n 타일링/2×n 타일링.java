import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static int[] dp;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		dp = new int [n + 1];
		dp[1] = 1;
		if(n > 1) {
			dp[2] = 2;
		}
		System.out.println(f(n));
	}
	
	private static int f(int p) {
		if (p <= 2)
			return dp[p];
		
		if(dp[p] != 0) {
			return dp[p];
		}
		
		dp[p] = (f(p-2) + f(p-1)) % 10007;
		return dp[p];
	}
}