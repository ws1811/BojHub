import java.util.*;
import java.io.*;
// 며칠이 지나면 토마토들이 모두 익는지, 그 최소 일수를 구하는 프로그램을 작성하라.
public class Main {
	static int M; // 가로
	static int N; // 세로
	static int H; // 높이
	static int[][][] tomato;
	static int[][] dir = {{1,0,0}, {-1,0,0}, {0,1,0}, {0,-1,0}, {0,0,1}, {0,0,-1}};
	static Queue<Tomato> que = new LinkedList<>();
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		tomato = new int[H][N][M];
		for (int h = 0; h < H; h++)
		{
			for (int n = 0; n < N; n++)
			{
				st = new StringTokenizer(br.readLine());
				for(int m = 0; m < M; m++)
				{
					// 1 : 익은 토마토, 0 : 익지 않은 토마토, -1 : 빈칸
					tomato[h][n][m] = Integer.parseInt(st.nextToken());
					if(tomato[h][n][m] == 1)
						que.add(new Tomato(h, n, m));
				}
			}
		}
		
		System.out.println(bfs());
	}
	
	static int bfs()
	{
		while(!que.isEmpty())
		{
			Tomato cur = que.poll();
			int ch = cur.height;
			int cr = cur.row;
			int cc = cur.col;
			int curTime = tomato[ch][cr][cc];
			
			for (int i = 0 ; i < dir.length; i++)
			{
				int nh = ch + dir[i][0];
				int nr = cr + dir[i][1];
				int nc = cc + dir[i][2];
				
				if (nh < 0 || nr < 0 || nc < 0 
						|| nh >= H || nr >= N || nc >= M)
					continue;
				if (tomato[nh][nr][nc] == 0)
				{
					que.add(new Tomato(nh, nr, nc));
					tomato[nh][nr][nc] = curTime + 1;
				}
			}
			
		}

		int result = -2;
		
		for (int h = 0; h < H; h++)
		{
			for (int n = 0; n < N; n++)
			{
				for (int m = 0; m < M; m++)
				{
					if (tomato[h][n][m] == 0)
						return -1;
					result = (tomato[h][n][m] > result)? tomato[h][n][m] : result;
				}
			}
		}
		if (result == 1)
			return 0;
		return result - 1;
	}
	
}
class Tomato {
	int height;
	int row;
	int col;
	
	public Tomato(int h, int r, int c) {
		this.height = h;
		this.row = r;
		this.col = c;
	}
}
