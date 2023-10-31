class Solution {
    
    // 넓이가 12 라면 -> (12,1), (6,2), (4,3)
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = brown + yellow; // 카펫 넓이
        int width;  // 가로
        int height; // 세로    

       for(height = 3; height < area; height++){
            width = area / height; 
            int yellowArea = (width - 2) * (height - 2);
            if(width >= height){
                 if (yellowArea == yellow) {
                answer[0] = width;
                answer[1] = height;
                break;
                }
            }
        }
        
        return answer;
    }
    
    
}