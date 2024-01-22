import java.util.*;

class Solution {
    static int n;
    static int m;
    static int answer;
    static boolean[][] visited;
    static int[][] dir = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        
        answer = bfs(maps, 0, 0, 1);
        return answer;
    }
    
    public int bfs(int[][] maps, int y, int x, int d)
    {
        visited[y][x] = true;
        Queue<int[]> que = new LinkedList<>();
        int[] now = {y, x, d};
        que.add(now);
        
        while(!que.isEmpty())
        {
            int[] cur = que.poll();
            if(cur[0] == n - 1 && cur[1] == m - 1)
                return cur[2];
            for (int i = 0; i < 4; i++)
            {
                int ny = cur[0] + dir[i][0];
                int nx = cur[1] + dir[i][1];
                int nd = cur[2] + 1;
                int[] next = {ny, nx, nd};
                
                if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                    continue;
                if (maps[ny][nx] == 1 && visited[ny][nx] == false)
                {
                    visited[ny][nx] = true;
                    que.add(next);
                }
            }
        }
        return -1;
    }
}