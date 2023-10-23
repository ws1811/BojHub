import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {

    // 이진 탐색 메소드 -> 정렬된 배열 인자로 전달
	static int binarySearch(int[] cards, int n, int search)
	{
		int first = 0; // 시작 인덱스
		int last = n - 1; // 끝 인덱스
		int mid = 0; // mid 변수 초기화
		
		// 정렬된 배열 cards[] 탐색
		while (first <= last)
		{
			mid = (first + last) / 2;
			if(cards[mid] == search) // 찾으려는 수 있으면 1 리턴
				return 1;
			if(cards[mid] < search)
			{   // (중간값 > 찾으려는 수) 중간값 보다 작은 값들 안보겠다
				first = mid + 1;
			}else {
				// (중간값 < 찾으려는 수) 중간값 보다 큰 값들 안보겠다
				last = mid - 1;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] cards = new int[n];
		for(int i = 0;i < n; i++)
		{
			cards[i] = Integer.parseInt(st.nextToken());
		}
		
		// 이진 탐색을 위한 정렬
		Arrays.sort(cards);
		
		int m = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder(); // 출력할 문자열 1 0 0 1 ....
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++)
		{
			int tmp = Integer.parseInt(st.nextToken());
			sb.append(binarySearch(cards, n, tmp) + " "); // -> 0 또는 1 추가
		}
		bw.write(sb.toString() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

