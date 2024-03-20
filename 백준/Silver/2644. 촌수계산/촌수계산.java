import java.io.*;
import java.util.*;

public class Main {
	static int n; // 전체 사람의 수
	static int start, end;
	static int m; // 관계의 개수
	static int result;
	static boolean[] visited;
	static List<List<Integer>> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(br.readLine());
		visited = new boolean[n + 1];
		result = -1;
		
		// 빈 리스트 n + 1 개 생성
		for (int i = 0; i <= n; i++)
		{
			list.add(new ArrayList<>());
		}
		// 관계 입력
		for (int i = 1; i <= m; i++)
		{
			st = new StringTokenizer(br.readLine());
			int person1 = Integer.parseInt(st.nextToken());
			int person2 = Integer.parseInt(st.nextToken());
			
			list.get(person1).add(person2);
			list.get(person2).add(person1);
		}
		dfs(start, 0);
		System.out.println(result);
	}

	static void dfs(int now, int depth)
	{
		if (now == end)
		{
			result = depth;
			return;
		}
		visited[now] = true;
		List near = list.get(now);
		for (int i = 0; i < near.size(); i++)
		{
			int next = (int)near.get(i);
			if (!visited[next])
			{
				dfs(next, depth + 1);
			}
		}
	}
}
