import java.util.*;

class Solution {
    static int[][] graph = new int[101][101];
    static boolean[][] visited = new boolean[101][101];
    static int[][] dir = {{1,0}, {-1,0}, {0,1}, {0, -1}};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        int answer = 0;
        // 1. 그래프세팅 (다각형의 둘레)
        initGraph(rectangle);
        // 2. 탐색(BFS)
        answer = bfs(characterX, characterY, itemX, itemY);
        
        return answer;
    }
    
    private int bfs(int characterX, int characterY, int itemX, int itemY)
    {
        Deque<int[]> que = new ArrayDeque<>();
        
        que.add(new int[] {characterY * 2, characterX * 2, 0});
        visited[characterY * 2][characterX * 2] = true;
        while(!que.isEmpty()) 
        {
            int[] curArr = que.poll();
            int curY = curArr[0];
            int curX = curArr[1];
            int curDistance = curArr[2];
            
            if(curY == itemY * 2 && curX == itemX * 2)
            {
                return curDistance / 2;
            }
            
            for(int i=0; i<4; i++) 
            {
                int nextY = curY + dir[i][0];
                int nextX = curX + dir[i][1];                 
                if(nextY > 100 || nextX > 100 || nextY < 0 || nextX < 0)
                {
                    continue;
                }
                if(graph[nextY][nextX] == 1 && !visited[nextY][nextX]) 
                {
                    que.add(new int[] {nextY, nextX, curDistance+1});
                    visited[nextY][nextX] = true;
                }
            }
        }
        return 0;
    }

    
    private void initGraph(int[][] rectangle) 
    {
        for(int[] rec : rectangle) {
            int left_under_x = rec[0] * 2;
            int left_under_y = rec[1] * 2;
            int right_upper_x = rec[2] * 2;
            int right_upper_y = rec[3] * 2;
            
            for(int y = left_under_y; y <= right_upper_y; y++) 
            {
                for (int x=left_under_x; x <= right_upper_x; x++) 
                {
                    if(y == left_under_y || y == right_upper_y
                        || x == left_under_x || x == right_upper_x) 
                    {
                        if(graph[y][x] == 2)
                        {
                            continue;
                        }
                        graph[y][x] = 1;
                    }
                    else 
                    {
                        graph[y][x] = 2;
                    }
                }
            }
            
        }
    }
}