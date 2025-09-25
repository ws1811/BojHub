import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static boolean[][] visited;
	static int[][] graph;
	static int[][] distanceMap;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
	
		graph = new int[n][m];
		distanceMap = new int[n][m];
		visited = new boolean[n][m];
		
		// 시작점
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < n; i++) {
			String line = br.readLine();
			st = new StringTokenizer(line);
			for(int j = 0; j < m; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
				if(graph[i][j] == 2) {
					x = i;
					y = j;
				}
			}
		}
		
		// distanceMap을 -1로 초기화 (도달 불가능한 경우 처리 위함)
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(graph[i][j] == 0) {
                    distanceMap[i][j] = 0;  
                } else {
                    distanceMap[i][j] = -1; 
                }
            }
        }
		
		
		bfs(x, y);
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				System.out.print(distanceMap[i][j] + " ");
			}
			System.out.println();
		}
		
 	}
	
	private static void bfs(int x, int y) {
		
		Queue<int[]> que = new LinkedList<>();
		
		que.add(new int[] {x, y, 0});
		visited[x][y] = true;
		
		while(!que.isEmpty()) {
			int[] point = que.poll();
			int cur_x = point[0];
			int cur_y = point[1];
			int distance = point[2];
			
			distanceMap[cur_x][cur_y] = distance;
			
			for(int i = 0; i < 4; i++) {
				int new_x = cur_x + dir[i][0];
				int new_y = cur_y + dir[i][1];
				
				if(isValid(new_x, new_y)) {
					que.add(new int[] {new_x, new_y, distance + 1});
					visited[new_x][new_y] = true;
				}
			}
		}
	}
	
	private static boolean isValid(int x, int y) {
		if(x < 0 || x >= n)
			return false;
		if(y < 0 || y >= m)
			return false;
		if(visited[x][y] == true)
			return false;
		if(graph[x][y] == 0)
			return false;
		
		return true;
	}
	

}
