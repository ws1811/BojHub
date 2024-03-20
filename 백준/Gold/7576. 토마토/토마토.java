import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] tomato;
	static boolean[][] visited;
	static int[][] dir = {{1, 0}, {-1 ,0}, {0, 1}, {0, -1}};
	static Queue<int[]> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		tomato = new int[N][M];
		visited = new boolean[N][M];
		boolean flag = true; // 처음부터 모든 토마토가 익어있는지
		
		for (int i = 0; i < N; i++)
		{
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++)
			{
				tomato[i][j] = Integer.parseInt(st.nextToken());
				if (tomato[i][j] == 1)
				{
					que.add(new int[] {i, j, 0});
				}
				if (tomato[i][j] == 0)
					flag = false;
			}
		} // end 입력
		
		if (flag == true) // 처음부터 모두 익어있다면 0을 출력하고 종료
		{
			System.out.println(0);
			return;
		}
		
		int totalDay = bfs();
		// 익지 않은 토마토가 있는지 -> 있다면 -1 출력후 종료
		for (int i = 0; i < N; i++)
		{
			for (int j = 0; j < M; j++)
			{
				if(tomato[i][j] == 0)
				{
					System.out.println(-1);
					return;
				}
			}
		}
		System.out.println(totalDay);
		
	}
	
	static int bfs()
	{
		int totalDay = 0;
		while (!que.isEmpty())
		{
			int[] cur = que.poll();
			int cy = cur[0];
			int cx = cur[1];
			int day = cur[2];
			if (day > totalDay)
				totalDay = day;
			
			for (int i = 0; i < dir.length; i++)
			{
				int ny = cy + dir[i][0];
				int nx = cx + dir[i][1];
				
				if (ny < 0 || nx < 0 || ny >= N || nx >= M)
					continue;
				if (tomato[ny][nx] == 0 && !visited[ny][nx])
				{
					que.add(new int[] {ny, nx, day + 1});
					tomato[ny][nx] = 1;
					visited[ny][nx] = true;
				}
			}
		}
		return totalDay;
	}

}
