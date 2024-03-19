import java.io.*;
import java.util.*;
public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] seq = new int[N];
		st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++)
			seq[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(seq);
		int result = seq[0];
		int[] sum = new int [N];
		sum[0] = seq[0];
		for (int i = 1; i < N; i++)
		{
			sum[i] = sum[i - 1] + seq[i];
			result += sum[i];
		}
		System.out.println(result);
	}

}
