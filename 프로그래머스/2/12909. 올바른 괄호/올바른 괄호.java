import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        if(s.charAt(0) == ')') 
            return false;
        
        Deque<Character> stack = new ArrayDeque<>();
        for(int i=0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') 
            {
                stack.addFirst(c);
            }
            else 
            {
                if(stack.isEmpty()) 
                {
                    return false;
                }
                else 
                {
                    stack.pollLast();
                }
            }
        }
        
        return stack.isEmpty();
    }
}