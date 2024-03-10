class Solution {
    int answer;
    
    public int solution(int[] numbers, int target) {
        answer = 0;
        dfs(numbers, 0, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int depth, int target, int result) {
        if (depth == numbers.length) {
            if(target == result)
                answer++;
        } else {
            dfs(numbers, depth + 1, target, result + numbers[depth]);
            dfs(numbers, depth + 1, target, result - numbers[depth]);
        }
    }
}