import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];

        int num = 1; // 말하는 사람 번호
        int i = 1; // 순서
        List<String> usedWords = new ArrayList<>();
        while (i <= words.length)
        {
            System.out.printf("[%d] %d 번째 사람 -> %s\n", i - 1, num, words[i - 1]);
            // 사용했던 단어 말하는 경우
            if(usedWords.contains(words[i - 1])) 
            {
                answer[0] = num;
                if (i % n == 0)
                    answer[1] = i / n;
                else 
                    answer[1] = i / n + 1;
                return answer;
            }
            // 마지막 단어 이어 말하지 않은 경우
            if (i >= 2)
            {
                int prevLen = words[i - 2].length(); 
        
                if (words[i - 1].charAt(0) != words[i - 2].charAt(prevLen - 1))
                {
                    answer[0] = num;
                    if (i % n == 0)
                        answer[1] = i / n;
                    else 
                        answer[1] = i / n + 1;
                    return answer;
                }
            }
            
            if (num == n) 
                num = 1;
            else
                num++;      
            usedWords.add(words[i - 1]);
            i++;
        }
        
        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}