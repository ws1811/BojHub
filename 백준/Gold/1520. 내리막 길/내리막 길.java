import java.io.*;
import java.util.*;
public class Main {
	static int N, M; 
	static int H;
	static int[][] map;
	static Integer[][] dp;
	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		H = 0;
		map = new int[N][M];
		dp = new Integer[N][M];
		
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
			{
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		H = dfs(0, 0);
		System.out.println(H);
	}
	
	static int dfs(int y, int x)
	{
		if (y == N - 1 && x == M - 1)
			return 1;
		
		if (dp[y][x] != null)
		{
			return dp[y][x];
		}
		dp[y][x] = 0;
		for (int i = 0; i < 4; i++)
		{
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || ny >= N || nx >= M)
				continue;
			if (map[ny][nx] < map[y][x])
			{
				dp[y][x] += dfs(ny, nx);
			}
		}
		return dp[y][x];
	}

}
