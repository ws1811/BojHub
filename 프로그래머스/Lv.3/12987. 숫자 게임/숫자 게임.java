import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int aIndex = 0;
        int bIndex = 0;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        for (int i = 0; i < A.length; i++)
        {
            if (A[aIndex] >= B[bIndex])
                bIndex++;
            else
            {
                aIndex++;
                bIndex++;
                answer++;
            }
        }
        return answer;
        
    }
}