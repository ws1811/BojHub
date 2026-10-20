import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        Map<Integer, Integer> map = new HashMap<>(); // <귤크기, 개수>
        for(int n : tangerine) {
            int cnt = map.getOrDefault(n, 0);
            map.put(n, cnt+1);
        }
        
        List<Integer> counts = new ArrayList<>(map.values());
        counts.sort(Collections.reverseOrder());
        
        for (int c : counts) {
            if (k <= 0) break;
            k -= c;
            answer++;
        }
                
        return answer;
    }
}