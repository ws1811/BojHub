import java.util.*;

class Solution {
    public String solution(String s) {
        
        String[] arr = s.split(" ");
        int[] intArr = new int[arr.length];
        
        for(int i=0; i<arr.length; i++) {
            intArr[i] = Integer.parseInt(arr[i]);
        }
        
        Arrays.sort(intArr);
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append(intArr[0]);
        sb.append(" ");
        sb.append(intArr[intArr.length-1]);
        sb.append("");
        
        return sb.toString();
    }
}