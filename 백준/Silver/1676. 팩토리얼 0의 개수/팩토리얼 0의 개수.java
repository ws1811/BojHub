import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int countFive = 0;
		
		// 0 => (2 x 5) 가 곱해질 때 하나씩 생긴다
		// 일반적으로 2가 5보다 많이 곱해지기 때문에 5가 곱해진 횟수를 구하면 된다
		// 5의 배수가 몇번 곱해지는지
		for(int i = 5; i <= N; i *=5)
		{
			countFive += N / i;
		}
		System.out.println(countFive);
	}
	
	
}
