import java.io.*;
import java.util.*;

public class Main {
	static int w, h; // 너비, 높이
	static int count;
	static int[][] map;
	static boolean[][] visited;
	static int dx[] = {0, 0, -1, 1, -1, 1, -1, 1};
    static int dy[] = {-1, 1, 0, 0, 1, 1, -1, -1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String str = "";
		while(!(str = br.readLine()).equals("0 0"))
		{
			st = new StringTokenizer(str);
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			map = new int[h][w];
			visited = new boolean[h][w];
			
			for (int i = 0; i < h; i++)
			{
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++)
				{
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			count = 0;
			for (int i = 0; i < h; i++)
			{
				for (int j = 0; j < w; j++)
				{
					if(map[i][j] == 1 && !visited[i][j])
					{
						dfs(i, j);
						count++;
					}
				}
			}
			System.out.println(count);
		}
	}
	
	static void dfs(int y, int x) 
	{
		visited[y][x] = true;
		
		for (int i = 0; i < 8; i++)
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if (ny < 0 || nx < 0 | ny >= h || nx >= w)
				continue;
			if (map[ny][nx] == 1 && visited[ny][nx] == false)
				dfs(ny,nx);
		}
	}
}
