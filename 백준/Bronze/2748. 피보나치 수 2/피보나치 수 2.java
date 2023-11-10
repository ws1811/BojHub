import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int n;
	static long[] fiboNums;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		fiboNums = new long[n + 1];
		for (int i = 0; i < n  + 1; i++)
		{
			fiboNums[i] = -1;
		}
		fiboNums[0] = 0;
		fiboNums[1] = 1;
		System.out.println(fibo2(n));
	}
	
	static long fibo2(int m)
	{
		if(m == 0)
			return fiboNums[0];
		if(m == 1)
			return fiboNums[1];
		if(fiboNums[m] == -1)
		{
			fiboNums[m] = fibo2(m - 2) + fibo2(m - 1);
		}
		return fiboNums[m];
	}
}