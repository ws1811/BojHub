class Solution {
    static boolean[] marked;
    public int solution(int n, int[][] computers) {
        int answer = 0; // 네트워크의 개수 리턴
        marked = new boolean[n];
        for (int i = 0; i < n; i++) 
        {
            if (marked[i] == false)
            {
                answer++;
                searchNetwork(i, computers);
            }
        }
        
        return answer;
    }
    
    // DFS 
    public void searchNetwork(int v, int[][] computers) {
        marked[v] = true; // 방문 지점 체크

        for(int i = 0; i < computers.length ; i++)
        {    
            // 연결되어있으나 방문 안한 노드
            if (marked[i] == false && computers[v][i] == 1) 
            {
                searchNetwork(i, computers);
            }
        }
    }
}
