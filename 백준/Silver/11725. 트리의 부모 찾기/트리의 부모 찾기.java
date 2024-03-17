import java.io.*;
import java.util.*;
public class Main{
	static int N; // 노드의 개수
	static List<List<Integer>> tree = new ArrayList<>();
	static boolean[] visited;
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		//첫째 줄에 노드의 개수 N (2 ≤ N ≤ 100,000)이 주어진다. 둘째 줄부터 N-1개의 줄에 트리 상에서 연결된 두 정점이 주어진다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		parent = new int[N + 1];
		
		
		for (int i = 0; i <= N; i++) 
		{
	         tree.add(new ArrayList<>());
	     }
		for (int i = 0; i < N - 1; i++)
		{
			st = new StringTokenizer(br.readLine());
			List<Integer> relation = new ArrayList<>();
			int n1 = Integer.parseInt(st.nextToken());
			int n2 = Integer.parseInt(st.nextToken());
			tree.get(n1).add(n2);
			tree.get(n2).add(n1);
		}
		
		dfs(1);
		
		for (int i = 2; i <= N; i++)
			System.out.println(parent[i]);
		
	}
	
	static void dfs(int cur) 
	{
		visited[cur] = true;
		for (int adjacent : tree.get(cur))
		{
			if(visited[adjacent] == false)
			{
				parent[adjacent] = cur;
				dfs(adjacent);
			}
		}
		
	}

}
