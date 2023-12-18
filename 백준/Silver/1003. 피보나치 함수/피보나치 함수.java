import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static Integer[][] fibo = new Integer[41][2];
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int	t;	// test case 개수
	
		fibo[0][0] = 1;
		fibo[0][1] = 0;
		fibo[1][0] = 0;
		fibo[1][1] = 1;
		t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++)
		{
			int n = Integer.parseInt(br.readLine());
			fibonacci(n);
			System.out.printf("%d %d\n", fibo[n][0], fibo[n][1]);
		}
		
	}
	
	static Integer[] fibonacci(int n) 
	{
		if(fibo[n][0] == null || fibo[n][1] == null)
		{
			fibo[n][0] = fibonacci(n - 1)[0] + fibonacci(n - 2)[0];
			fibo[n][1] = fibonacci(n - 1)[1] + fibonacci(n - 2)[1];
		}
		return fibo[n];
	}
	
}
