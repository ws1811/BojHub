import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int graph[][];
	static boolean visitedArr[];
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int V; // 탐색을 시작할 정점의 번호
    static int count;
	static Queue<Integer> que = new LinkedList<>();

	// DFS by Recursion
	public static void DFS(int v) {
		visitedArr[v] = true; 		// 방문지점 체크
		System.out.print(v + " ");

        if(count == N) {// 재귀 탈출 조건
			return;
		}
		count++;
		for(int i=1; i<=N; i++) {
			// (v, i) 가 1 이고        <=> v번 노드와 i 번 노드 사이에 간선이 있고
			// visitedArr[i]=false 면 <=> i 번 노드를 방문하지 않은 상태라면
			if(graph[v][i] == 1 && visitedArr[i] == false) {
				// i 번 노드 방문
				DFS(i);
			}
		}
	}
	
	// BFS by Queue
	public static void BFS(int v) {
		que.offer(v);	
		visitedArr[v] = true;
		System.out.print(v + " ");

		while(!que.isEmpty()) {
			v = que.poll();
			for(int i=1; i<=N; i++) {
				// v - i 간선 있고    &&    i 번 노드 방문 안헀으면
				if(graph[v][i] == 1 && visitedArr[i] == false) {
					que.offer(i);
					visitedArr[i] = true;
					System.out.print(i + " ");
				}
			}
		}	
	}
		

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());

		graph = new int[1001][1001];
		visitedArr = new boolean[1001];

		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());

			graph[x][y] = graph[y][x] = 1;
		}

		DFS(V);
		System.out.println();

		visitedArr = new boolean[1001];
		BFS(V);
	
	} 
}