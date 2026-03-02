import java.io.*;
import java.util.*;

public class Main {
	static int n, m;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<>();
	
		for(int i=0; i<n; i++) {
			set.add(br.readLine());
		}
		int answer = 0;
		for(int i=0; i<m; i++) {
			String str = br.readLine();
			if(set.contains(str))
				answer++;
		}
		System.out.println(answer);
	}
}