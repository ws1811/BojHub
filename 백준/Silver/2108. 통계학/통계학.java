import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	static int n;
	static int total = 0;
	static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
	static int arr[];
	static int count[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		count = new int[8001]; // -4000 ~ 4000 -> 0 ~ 8000
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
			
			if(max < arr[i]) max = arr[i];
			if(min > arr[i]) min = arr[i];
			
			count[arr[i] + 4000]++; // 음수 처리: +4000
		}
		
		Arrays.sort(arr);
		
		// 1. 산술평균
		System.out.println(Math.round((double)total / n)); 
		
		// 2. 중앙값
		System.out.println(arr[n / 2]); 
		
		// 3. 최빈값
		int maxFreq = 0;
		for(int i = 0; i < 8001; i++) {
			if(count[i] > maxFreq) {
				maxFreq = count[i];
			}
		}
		
		// 최빈값이 여러 개인 경우 두 번째로 작은 값
		int mode = 0;
		int modeCount = 0;
		for(int i = 0; i < 8001; i++) {
			if(count[i] == maxFreq) {
				mode = i - 4000; // 원래 값으로 복원
				modeCount++;
				if(modeCount == 2) break; // 두 번째 값
			}
		}
		System.out.println(mode);
		
		// 4. 범위
		System.out.println(max - min); 
	}
}