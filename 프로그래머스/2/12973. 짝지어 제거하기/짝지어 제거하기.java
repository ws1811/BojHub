import java.util.*;

class Solution
{
    public int solution(String s)
    {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++)
        {
            if(stack.isEmpty())
            {
                stack.push(s.charAt(i));
            }
            else
            {
                if(stack.peek() == s.charAt(i))
                {
                    stack.pop();
                }
                else
                {
                    stack.push(s.charAt(i));
                }
            }
        }
        
        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}