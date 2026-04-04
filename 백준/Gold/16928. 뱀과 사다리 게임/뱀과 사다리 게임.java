import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int m;
	static boolean[] visited;
	static Map<Integer, Integer> ladderMap = new HashMap<>();
	static Map<Integer, Integer> snakeMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken()); 
		m = Integer.parseInt(st.nextToken());	
		visited = new boolean[101];
		
		// 1. 사다리 정보 입력
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int ladderIndex = Integer.parseInt(st.nextToken());
			int ladderDestination = Integer.parseInt(st.nextToken());
			ladderMap.put(ladderIndex, ladderDestination);
		}
		// 2. 뱀 정보 입력
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int snakeIndex = Integer.parseInt(st.nextToken());
			int snakeDestination = Integer.parseInt(st.nextToken());
			snakeMap.put(snakeIndex, snakeDestination);
		}
		
		int rv = bfs();
		
		System.out.println(rv);
	}
	
	private static int bfs() {
		// 3.bfs로 탐색
		Queue<int[]> que = new LinkedList<>(); // {위치, 주사위굴린 횟수}
		que.add(new int[] {1, 0}); // 시작위치=1, 굴린횟수=0
		visited[1] = true;
		
		while(!que.isEmpty()) {
			int[] curNode = que.poll();
			int curIndex = curNode[0];
			int curTry = curNode[1];
			
			if(curIndex == 100) {
				return curTry;
			}
			
			for(int i=1; i<=6; i++) {
	            int nextIndex = curIndex + i;
	            if(nextIndex > 100) continue;
	            
	            int dest = getDestination(nextIndex); // 사다리/뱀 최종 목적지 계산 (사다리 타고 도착한 곳에 또 사다리/뱀이 있는 경우 등)
	            
	            if(!visited[dest]) {
	                visited[dest] = true;
	                que.add(new int[] {dest, curTry + 1});
	            }
	        }
		}
		
		return 0;
	}
	
	// 사다리/뱀이 있으면 최종 목적지까지 한번에 이동
	private static int getDestination(int pos) {
	    while(ladderMap.containsKey(pos) || snakeMap.containsKey(pos)) {
	        if(ladderMap.containsKey(pos)) pos = ladderMap.get(pos);
	        else pos = snakeMap.get(pos);
	    }
	    return pos;
	}
}