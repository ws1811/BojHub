import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static int m;
	static int[][] arr;
	static boolean[][] visited;
	static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		arr = new int[n][m];
		visited = new boolean[n][m];
		
		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int maxArea = 0;
		int count = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(!visited[i][j] && arr[i][j] == 1) {
					int area = dfs(i, j);
					maxArea = Math.max(maxArea, area);
					count++;
				}
			}
		}
		System.out.println(count);
		System.out.println(maxArea);
	}
	
	private static int dfs(int y, int x) {
		visited[y][x] = true;
		int area = 0;
		Stack<int[]> stack = new Stack<>();
		
		stack.add(new int[] {y, x});
		while(!stack.isEmpty()) {
			int[] cur = stack.pop();
			int cur_y = cur[0];
			int cur_x = cur[1];
			area++;
			
			for(int i = 0; i < 4; i ++) {
				int next_y = cur_y + dir[i][0];
				int next_x = cur_x + dir[i][1];
				
				if(isValid(next_y, next_x)) {
					visited[next_y][next_x] = true;
					stack.add(new int[] {next_y, next_x});
				}
				
			}
		}
		return area;
	}
	
	private static boolean isValid(int y, int x) {
		if(y < 0 || y >= n)
			return false;
		if(x < 0 || x >= m)
			return false;
		if(visited[y][x])
			return false;
		if(arr[y][x] == 0)
			return false;
		return true;
	}
	
}