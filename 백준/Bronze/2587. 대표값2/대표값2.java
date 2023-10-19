import java.util.Arrays;
import java.util.Scanner;

public class Main {

	static int getAvg(int[] arr) {
		int result = 0;
		for(int i=0;i<arr.length;i++)
		{
			result += arr[i];
		}
		return (result/arr.length);
	}
	
	// 오름차순 정렬(버블)
	static void sort(int[] arr) {
		int len = arr.length;
		int c = 0;
		
		while(c < len)
		{
			int i = c + 1;
			while (i < len)
			{
				if (arr[c] < arr[i])
				{
					int tmp = arr[c];
					arr[c] = arr[i];
					arr[i] = tmp;
				}
				i++;
			}
			c++;
		}
	}
	
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] arr = new int[5];
		int avg;
		int mid;
		
		//입력
		for(int i=0;i<5;i++)
		{
			arr[i] = scan.nextInt();
		}
		// 평균
		System.out.println(getAvg(arr));
		// 정렬
		sort(arr);
		//System.out.println(Arrays.toString(arr));
		// 중앙값
		System.out.println(arr[2]);
	}

}
