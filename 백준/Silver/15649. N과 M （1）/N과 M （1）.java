import java.util.Scanner;

public class Main {
	static int[] seq;
	static boolean visited[];
	static int N;
	static int M;
	// 자연수 N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
	// 1부터 N까지 자연수 중에서 중복 없이 M개를 고른 수열
	public static void main(String[] args) {
		// [입력]
		// 첫째 줄에 자연수 N과 M이 주어진다. (1 ≤ M ≤ N ≤ 8)
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt(); // 1 ~ N 까지
		M = scan.nextInt(); // M 개의 자연수	
		seq = new int[M];
		visited = new boolean[N + 1];
		// [출력]
		// 한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 
		// 중복되는 수열을 여러 번 출력하면 안되며, 각 수열은 공백으로 구분해서 출력해야 한다.
		//수열은 사전 순으로 증가하는 순서로 출력해야 한다.
		sequence(N, M, 0);
	}
	
	// 가능한 수열 출력하는 재귀 함수
	static void sequence(int n, int m, int index) {
		// 재귀탈출 조건
		if (index == M) {
			// 출력하고 종료
			for(int val: seq) {
				System.out.print(val + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i = 1; i <= N; i++) {
			// i 를 방문하지 않았으면
			if(visited[i] == false) {
				// i 방문했다고 체크하고
				visited[i] = true;
				// 수열에 원소 추가
				seq[index] = i;
				// 수열 다음 원소 호출
				sequence(n, m, index + 1);
				// 재귀 호출이 끝나면 다시 i 방문상태 변경
				visited[i] = false;
			}
		}
	}
}
