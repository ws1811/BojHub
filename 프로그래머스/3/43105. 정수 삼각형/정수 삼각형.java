import java.util.*;
class Solution {
    
    public int solution(int[][] triangle)
    {
        int answer = 0;
        int height = triangle.length;
        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        
                
        for (int i = 1; i < height; i++)
        {
            dp[i][0] = dp[i - 1][0] + triangle[i][0];
        }
        for (int i = 1; i < height; i++)
        {
            for (int j = 1; j < triangle[i].length; j++)
            {
                dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]); 
            }
        }
        
        for (int i = 0; i < height; i++)
        {
            answer = Math.max(dp[height-1][i], answer);
        }
        return answer;
    }
    
}