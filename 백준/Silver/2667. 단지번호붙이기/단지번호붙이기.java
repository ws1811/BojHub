import java.util.*;
import java.io.*;
public class Main {
	static int N; // 지도의 크기
	static int total;
	static int count;
	static List<Integer> counts; 
	static int[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0}, {-1, 0}, {0, 1}, {0,-1}};
	
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		total = 0;
		counts = new ArrayList<>();
		
		for (int i = 0; i < N; i++)
		{
			String line = br.readLine();
			for (int j = 0; j < N; j++)
			{
				map[i][j] = line.charAt(j) - '0';
			}
		}
		
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < N; j++)
			{
				if (map[i][j] == 1 && visited[i][j] == false)
				{
					
					count = 0;
					DFS(i, j);
					counts.add(count);
					total++;
				}
			}
		}
		System.out.println(total);
		Collections.sort(counts);
		for (int c : counts) 
		{
			System.out.println(c);
		}
	}
	
	static void DFS(int y, int x) {
		
		if(rangeCheck(y, x) == false)
			return ;
		visited[y][x] = true;
		count++;
		for (int i = 0; i < 4; i++) 
		{
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			if (rangeCheck(ny,nx) == false)
				continue;
			if (map[ny][nx] == 1 && visited[ny][nx] == false) 
			{
				DFS(ny, nx);
			}
		}
		
	}

	static boolean rangeCheck(int y, int x) {
		if (y < 0 || x < 0 || y >= N || x >= N)
			return false;
		return true;
	}
}
