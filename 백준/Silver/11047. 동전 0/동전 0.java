import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	// 준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.
	// 동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		/* [입력] */
		// 첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());  // 코인의 종류
		int k = Integer.parseInt(st.nextToken());  // 만드려는 합
		int [] coins = new int[n]; // 준규가 가진 동전의 종류들을 저장할 배열
		// 둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. 
		// (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)
		for(int i = 0; i < n; i++)
		{
			coins[i] = Integer.parseInt(br.readLine());
		}
		/* [출력] */
		System.out.println(minCoins(coins, k));
		
	}
	
	// coins[] 배열에 담긴 동전들을 최소로 이용해 -> 총 합 K 를 만드는 메소드
	static int minCoins(int[] coins, int k) {
		int len = coins.length; // 배열의 길이(동전 종류의 수)
		int count = 0; // 사용된 동전의 수를 저장할 변수
		
		// coins 배열은 오름차순 정렬된 상태이므로,
		// 배열의 마지막 원소부터 실행
		while (k > 0)
		{
			if (k / coins[len -1] > 0)
			{
				count += (k / coins[len - 1]); // 동전 개수 만큼 count 증가
				k -= (k / coins[len - 1]) * coins[len - 1]; // 위의 액수만큼 k 감소
			}
			len--;
		}
		return count;
	}
	
}
