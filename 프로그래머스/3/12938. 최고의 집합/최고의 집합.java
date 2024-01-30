class Solution {
    public int[] solution(int n, int s) {
        int[] answer;
        int start = s / n;
        int remainder = s - (s / n) * n;
        System.out.printf("start : %d | remainder : %d\n", start, remainder);
        // n 이 s 보다 큰 경우 -> 집합 만들기 불가능
        if (n > s)
        {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }
        // answer 초기화
        // 곱이 최대가 되려면 -> 집합의 원소들을 최대한 비슷하게
        answer = new int[n];
        for (int i = 0; i < n; i++)
        {
            answer[i] = start;
            if (i >= n - remainder)
                answer[i]++;
        }
        return answer;
    }
    
}