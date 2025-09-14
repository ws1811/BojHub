import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] supoja1 = {1,2,3,4,5}; 
        int[] supoja2 = {2,1,2,3,2,4,2,5}; 
        int[] supoja3 = {3,3,1,1,2,2,4,4,5,5}; 
        int[] score = {0,0,0}; 
        
        for(int i = 0; i < answers.length; i++) {
            if(answers[i] == supoja1[i%5]) 
                score[0]++;
            if(answers[i] == supoja2[i%8]) 
                score[1]++;
            if(answers[i] == supoja3[i%10]) 
                score[2]++;
        }

        int max = Math.max(score[0], Math.max(score[1], score[2]));
        
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 1; i <= score.length; i++) {
            if(max == score[i - 1]) {
                list.add(i);
            }
        }
        
        int[] answer = new int[list.size()];
        for(int i = 1; i <= list.size(); i++){
            answer[i - 1] = list.get(i - 1);
        }

        return answer;
    }
}