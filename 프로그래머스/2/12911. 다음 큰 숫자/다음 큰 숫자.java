class Solution {
    public int solution(int n) {
        
        int count = Integer.bitCount(n);
        int next = n + 1;
        while(next <= 1000000) 
        {
            int nextCount = Integer.bitCount(next) ;
            if(nextCount == count)
            {
                break;
            }
            next++;
        }
        
        return next;
    }
}