import java.io.*;
import java.util.*;

public class Main {
	static int R, C;
	static int answer;
	static char[][] map;
	static int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
	static boolean[] used;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		used = new boolean[26]; // A : 0, ... , Z : 25
		answer = 1;
		
		for (int i = 0; i < R; i++)
		{
			String line = br.readLine();
			for (int j = 0; j < C; j++)
			{
				map[i][j] = line.charAt(j);
			}
		}
		dfs(0, 0, 1);
		System.out.println(answer);
		
	}
	
	static void dfs(int y, int x, int count)
	{
		char cur = map[y][x];
		
		if (used[cur - 'A']) // 사용된 알파벳일 경우
		{
			if (count - 1> answer)
				answer = count - 1;
			return;
		}
		
		used[cur - 'A'] = true; // 사용 여부 체크
		
		for (int i = 0; i < 4; i++)
		{
			int ny = y + dir[i][0];
			int nx = x + dir[i][1];
			
			if (ny < 0 || nx < 0 || ny >= R || nx >= C)
				continue;
			int nextChar = map[ny][nx];
			dfs(ny, nx, count + 1);
		}
		used[cur - 'A'] = false;
	}
	
}
