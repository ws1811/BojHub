import java.io.*;
import java.util.*;
public class Main {
	static int N;
	static int M;
	static char[][] map;
	static boolean[][] visited;
	static int[][] dir = {{1,0}, {-1,0}, {0, -1}, {0,1}};
	// 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[N][M];
		visited = new boolean[N][M];
		for (int i = 0; i < N; i++)
		{
			String line = br.readLine();
			for (int j = 0; j < M; j++)
			{
				map[i][j] = line.charAt(j);
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs()
	{
		int count = 1;
		int[] init = new int[] {0, 0, count};
		Queue<int[]> que = new LinkedList<>();
		que.add(init);
		visited[0][0] = true;
		while (!que.isEmpty())
		{
			int[] cur = que.poll();
			if (cur[0] == N - 1 && cur[1] == M - 1)
				return cur[2];
			for (int i = 0; i < 4; i++)
			{
				int ny = cur[0] + dir[i][0];
				int nx = cur[1] + dir[i][1];
				int nc = cur[2] + 1;
				if(ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (map[ny][nx] == '1' && visited[ny][nx] == false)
				{
					que.add(new int[] {ny, nx, nc});
					visited[ny][nx] = true;
				}
			}
		}
		return 0;
	}

}
