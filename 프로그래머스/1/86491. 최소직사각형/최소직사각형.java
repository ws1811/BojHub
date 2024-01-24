class Solution {
    public int solution(int[][] sizes) 
    {
        int answer = 0;
        int w = sizes[0][0]; // 가로
        int h = sizes[0][1]; // 세로
                
        for (int i = 1; i < sizes.length; i++)
        {
            int curW = sizes[i][0];
            int curH = sizes[i][1];
            if (w >= curW && h >= curH) // 들어가는 경우
                continue;
            else if (w >= curH && h >= curW) // 돌리면 들어 가는 경우
            {
                int tmp = w;
                w = h;
                h = tmp;
            }
            else if (w >= curW && h < curH) // 가로는 들어가는데 세로는 안들어가는 경우
            {
                // 1. 세로를 증가
                int w1 = w;
                int h1 = curH;
                // 2. 회전시킨 후 비교
                int w2 = Math.max(w, curH);
                int h2 = Math.max(h, curW);
                if (w1 * h1 < w2 * h2)
                {
                    w = w1;
                    h = h1;
                }
                else
                {
                    w = w2;
                    h = h2;
                }
            }
            else if (w < curW && h >= curH) // 세로는 들어가는데 가로는 안들어가는 경우
            {
                // 1. 가로만 증가시키는 경우
                int w1 = curW;
                int h1 = h;
                // 2. 회전시킨 후  비교
                int w2 = Math.max(w, curH);
                int h2 = Math.max(h, curW); 
                if (w1 * h1 < w2 * h2)
                {
                    w = w1;
                    h = h1;
                }
                else
                {
                    w = w2;
                    h = h2;
                }
            }
            else    // 가로 세로 모두 안들어가는 경우
            {
                // 1. 그냥 증가
                int w1 = curW;
                int h1 = curH;
                // 2. 회전 시킨 후 증가
                int w2 = Math.max(w, curH);
                int h2 = Math.max(h, curW);       
                if (w1 * h1 < w2 * h2)
                {
                    w = w1;
                    h = h1;
                }
                else
                {
                    w = w2;
                    h = h2;
                }
            }
        }
        answer = w * h;
        return answer;
    }
    
}