import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static List<List<Integer>> list = new ArrayList<>();
	static boolean[] visited= new boolean[10001];
	static int[] arr;
	static int max;
	static int n;
	static int m;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		arr = new int[n+1]; // i번 컴퓨터에서 시작해 해킹할 수 있는 컴퓨터 수
		max = 0;
		
		// 인접리스트 초기화
		for(int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		
		// 0. 다음 m개의 줄에 신뢰하는 관계 입력
		for(int i=0; i< m; i++) {
			st = new StringTokenizer(br.readLine());
			// a가 b를 신뢰한다 -> b를 해킹하면 a도 해킹할 수 있다
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list.get(b).add(a); // b를 해킹할 연달아 해킹할 수 있는 컴퓨터 리스트에 a를 넣는다
		}

		// 1. n개의 컴퓨터에 대해 반복문을 돌며 각 컴퓨터에서 해킹할 수 있는 컴퓨터 수를 arr에 저장
		for(int i=1; i<=n; i++) {
			Arrays.fill(visited, false);
			arr[i] = bfs(i);
		}
		
		// 2. 정답리스트를 오른차순 정렬 ->  정렬 없이 출력준비 동시에
		StringBuilder sb = new StringBuilder();
		List<Integer> answerList = new ArrayList<>();
		for(int i=1; i <=n; i++) {
			if(arr[i] == max) {
				answerList.add(i);
				sb.append(i).append(' ');
			}
		}
		
		// 출력
//		for(int k : answerList) {
//			sb.append(k).append(' ');
//		}
		System.out.println(sb.toString());
	}
	
	private static int bfs(int p) {
		int rv=1;
		
//		Queue<Integer> que = new LinkedList<>();
		Queue<Integer> que = new ArrayDeque<>();
		que.add(p);
		visited[p] = true;
		
		while(!que.isEmpty()) {
			
			int cur = que.poll();
			List<Integer> targetList = list.get(cur);
			for(int target : targetList) {
				if(!visited[target]) {
					que.add(target);
					visited[target] = true;
					rv++;
				}
			}
		}
		
		max = Math.max(max, rv);
		
		return rv;
	}
}