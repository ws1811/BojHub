import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int n ; 
	static int l;
	static int r;
	static int[][] map;
	static int[][] unionMap;
	static boolean[][] visited;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		l = Integer.parseInt(st.nextToken());
		r = Integer.parseInt(st.nextToken());
	
		map = new int[n][n];
		
		for(int i=0; i< n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j <n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int day = 0;
		boolean result = false;
		while(true) { 
			// while loop 1번당 하루
			// 하루에 (0,0) 부터 (n-1, n-1) 까지 반복문 돌며 방문 안한 노드에 대해 bfs 호출
			// 하루에 이동이 일어난 노드가 1번이라도 있으면 moved = true 배정해 이동이 일어났는지 판별
			// bfs 한번 호출 > 하나의 연합 형성 > 연합번호 부여 > 같은 연합번호를 가진 노드들끼리 n빵
			visited = new boolean[n][n];
			unionMap = new int[n][n];
			int unionNum = 1;
			boolean moved = false;
			
			for(int i=0; i<n; i++) {
				for(int j=0; j <n; j++) {
					if(!visited[i][j]) {
						result = bfs(i, j, unionNum);
						if(result)
							moved = true;
						unionNum++;
					}
				}
			}
			
//			printNthDay(day); // for debug
			
			if(!moved) {
				break;
			}
			if(day > 2000)
				break;
			day++;
		}
		System.out.println(day);
	}

	public static boolean bfs(int x, int y, int unionNum) {
		visited[x][y] = true;
		unionMap[x][y] = unionNum;
		int sum = map[x][y];
		int cnt = 1;
		
		Queue<int[]> que = new LinkedList<>();
		que.add(new int[] {x, y});
		
		while(!que.isEmpty()) {
			int[] cur = que.poll();
			int cur_x = cur[0];
			int cur_y = cur[1];
			
			for(int i=0; i<4; i++) {
				int next_x = cur_x + dir[i][0];
				int next_y = cur_y + dir[i][1];
				if(validate(cur_x, cur_y, next_x, next_y)) {
					visited[next_x][next_y] = true;
					unionMap[next_x][next_y] = unionNum;
					que.add(new int[] {next_x, next_y});
					sum += map[next_x][next_y];
					cnt++;
				}
			}
		}
//		System.out.println("한바퀴 끝 sum : " + sum + " | cnt : " + cnt);
		int popu =  sum / cnt;
		updateUnion(unionNum, popu);
		
		if (cnt > 1)
			return true;
		return false;
	}
	
	public static void updateUnion(int unionNum, int popu) {
		for(int i = 0; i< n; i++) {
			for(int j=0; j<n; j++) {
				if(unionMap[i][j] == unionNum) {
					map[i][j] = popu;
				}
			}
		}
	}
	
	public static boolean validate(int cur_x, int cur_y, int next_x, int next_y) {
		if(next_x < 0 || next_x >= n) {
			return false;
		}
		if(next_y < 0 || next_y >= n) {
			return false;
		}
		if(visited[next_x][next_y])
			return false;
		
		int diff = Math.abs(map[cur_x][cur_y] - map[next_x][next_y]);
		if (diff < l || diff > r)
			return false;
		return true;
	}
	
	public static void printNthDay(int day) {
		System.out.println("==== day " + day + " =====");
		for(int i=0; i<n; i++) {
			for(int j=0; j <n; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}