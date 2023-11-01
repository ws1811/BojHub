import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	/* 문제 */
	// N개의 정수 A[1], A[2], …, A[N]이 주어져 있을 때,
	// 이 안에 X라는 정수가 존재하는지 알아내는 프로그램을 작성하시오.
	public static void main(String[] args) throws NumberFormatException, IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] nArray;
		int[] mArray;
		/* [입력] */
		// 첫째 줄에 자연수 N(1 ≤ N ≤ 100,000)이 주어진다
		// 다음 줄에는 N개의 정수 A[1], A[2], …, A[N]이 주어진다.
		// 다음 줄에는 M(1 ≤ M ≤ 100,000)이 주어진다.
		// 다음 줄에는 M개의 수들이 주어지는데, 이 수들이 A안에 존재하는지 알아내면 된다.
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		nArray = new int[n];
		for(int i = 0; i < n; i++) {
			nArray[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(nArray); // 이진탐색을 위한 정렬
		int m = Integer.parseInt(br.readLine());
		mArray = new int[m];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {
			mArray[i]= Integer.parseInt(st.nextToken());
		}
		/* [출력] */
		// M개의 줄에 답을 출력한다. 존재하면 1을, 존재하지 않으면 0을 출력한다.
		for(int i = 0; i < m; i++)
		{
			if(binarySearch(mArray[i], nArray) != -1)
			{
				System.out.println(1);
			}
			else if (binarySearch(mArray[i], nArray) == -1)
			{
				System.out.println(0);
			}
		}
	}
	
	// 이진탐색 메소드           찾으려는 값/   탐색할배열
	static int binarySearch(int m, int[] nArr) {
		int first = 0;
		int last = nArr.length - 1;
		int mid;
		
		while (first <= last) 
		{
			mid = (first + last) / 2;
			if (m < nArr[mid])
			{
				last = mid - 1;
			}
			else if (m > nArr[mid])
			{
				first = mid + 1;
			}
			else {
				return mid;
			}
		}
		// 없으면 -1 리턴
		return -1;
	}
}